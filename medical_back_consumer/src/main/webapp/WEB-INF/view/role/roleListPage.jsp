<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<!-- 引入bootstrap样式 -->
	<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
	<!-- 引入bootstrap表格的样式 -->
	<link href="<%=request.getContextPath()%>/js/table/bootstrap-table.min.css" rel="stylesheet"/>
	<!-- 引入jQuery的js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
	<!-- 引入bootstrap的js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/js/bootstrap.min.js"></script>
	<!-- 引入bootstrap的bootbox的js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootbox/bootbox.js"></script>
	<!-- 引入bootstrap表格的js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/table/bootstrap-table.min.js"></script>
	<!-- 引入bootstrap表格语言的js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/table/locale/bootstrap-table-zh-CN.js"></script>
</head>
<body>
<div class="panel panel-primary" style="margin-top: 10px;">
    <div class="panel-heading">角色列表</div>
    <div class="panel-body">
    	<div id="tableColumnButton" class="btn-group" style="display: none;">
			<button id="deleteRoleButtonId" type="button" class="btn btn-error">
				<span class="glyphicon glyphicon-scissors">删除</span>
			</button>
			<button id="updateRoleButtonId" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-wrench">修改</span>
			</button>
			<button id="givePowerButtonId" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-wrench">赋权限</span>
			</button>
		</div>
	    <div id="tabToolBar" class="btn-group">
		    <button type="button" class="btn btn-success" onclick="addRoleInfo()">
		    	<span class="glyphicon glyphicon-plane">新增</span>
		    </button>
	  	</div>
        <table id="roleTable"></table>
    </div>
</div>
<script type="text/javascript">
$(function() {
	$("#roleTable").bootstrapTable({
		url:"<%=request.getContextPath()%>/role/queryRoleShowList.do",
		 method:"post",
		 striped: true,// 斑马线效果     默认false 
		 //只允许选中一行
		 singleSelect:true,
		 //选中行是不选中复选框或者单选按钮
		 clickToSelect:true,
		 //showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		 //cardView:false,                    //是否显示详细视图
		 uniqueId: "roleId",                 //每一行的唯一标识，一般为主键列
		 //showColumns: true,                  //是否显示所有的列
		 //showRefresh: true,                  //是否显示刷新按钮
		 minimumCountColumns: 2,     //  最少留两列
		 detailView: false,                  //是否显示父子表
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
		columns:[
					{field:'roleId',title:'角色ID',width:35,},
					{field:'roleName',title:'角色名称',width:60},
					{field:'',title:'操作',width:100,
						formatter:function(value,row,index){
							$("#deleteRoleButtonId").attr("onclick","deleteRoleInfo("+row.roleId+")");
		        			$("#updateRoleButtonId").attr("onclick","updateRoleInfo("+row.roleId+",'"+row.roleName+"')");
		        			$("#givePowerButtonId").attr("onclick","givePowerToRole("+row.roleId+",'"+row.roleName+"')");
							return $("#tableColumnButton").html();
						}
					},
		        ],
        //传递参数（*）
	 	queryParams: function(params) {
		 	var whereParams = {    
		 			/*
		 			分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）           
		 			*/
		 			"pageSize":params.limit,
		 			"start":params.offset,
		 	}
			 return whereParams;
		 },
		 //前台--搜索框
		 search:true,
		 //启动回车键做搜索功能
		 searchOnEnterKey:true,
   	    //分页方式   后台请求的分页方式
		 sidePagination:'server',
		 pagination: true,                   //是否显示分页（*）
		 pageNum: 1,                       //每页的记录行数（*）
		 pageSize: 5,                       //每页的记录行数（*）
		 pageList: [5, 10, 15,20],        //可供选择的每页的行数（*）
		 paginationVAlign:"bottom",
	});
})

function addRoleInfo(){
	bootbox.dialog({
		title:"新增角色信息",
		message:function(){
			var teacherPage = '<form id="addRoleForm">'+
									'<div class="form-group">'+
										'<label for="role_name">教师姓名</label>'+
										'<input type="text" class="form-control" name="roleName"  id="role_name" placeholder="角色名称">'+
									'</div>'+
								'</form>';
			return teacherPage;
		},
		buttons:{
			"save":{
				label:"保存信息",
				className:"btn-success",
				callback:function(){
					$.ajax({
						url:"<%=request.getContextPath()%>/role/saveOrUpdateRoleInfo.do",
						type:"post",
						data:$("#addRoleForm").serialize(),
						success:function(){
							bootbox.alert("保存成功");
							$("#roleTable").bootstrapTable("refresh");
						},
						error:function(){
							bootbox.alert("系统错误");
						}
						
					})
				},
			},
			"unSave":{
				label:"取消",
				className:"btn-info",
				callback:function(){
					//return true;//FALSE不关闭
				}
			}
		}
	})
}

function givePowerToRole(roleId,roleName){
	bootbox.dialog({
		title:"修改角色权限信息",
		message:function(){
			var teacherPage = '';
			$.ajax({
				url:"<%=request.getContextPath()%>/role/toGivePowerPage.do",
				data:{"roleId":roleId,"roleName":roleName},
				async:false,
				success:function(data){
					teacherPage = data;
				},
				error:function(){
					bootbox.alert("系统错误");
				}
			})
			return teacherPage;
		},
		buttons:{
			"save":{
				label:"保存信息",
				className:"btn-success",
				callback:function(){
					var ids = getRolePowerIds();
					alert(ids+roleId);
					$.ajax({
						url:"<%=request.getContextPath()%>/role/givePowerToRole.do",
						data:{"ids":ids,"roleId":roleId},
						type:"post",
						success:function(){
							bootbox.alert("保存成功");
							$("#roleTable").bootstrapTable("refresh");
						},
						error:function(){
							bootbox.alert("系统错误");
						}
						
					})
				},
			},
			"unSave":{
				label:"取消",
				className:"btn-info",
				callback:function(){
					//return true;//FALSE不关闭
				}
			}
		}
	})
}

function deleteRoleInfo(roleId){
	if(confirm("你确定要删除这条信息吗?")){
		$.ajax({
			url:"<%=request.getContextPath()%>/role/deleteRole.do",
			data:{"roleId":roleId},
			type:"post",
			success:function(data){
				$("#roleTable").bootstrapTable("refresh");
				alert("成功");
			},error:function(){
				bootbox.alert("系统错误");
			}
		})
	};
}
function updateRoleInfo(roleId,roleName){
	bootbox.dialog({
		title:"修改角色信息",
		message:function(){
			var teacherPage = '<form id="updateRoleForm">'+
									'<input type="hidden" name="roleId" value="'+roleId+'"/>'+
									'<div class="form-group">'+
										'<label for="role_name">教师姓名</label>'+
										'<input type="text" class="form-control" value="'+roleName+'" name="roleName" id="role_name" placeholder="角色名称">'+
									'</div>'+
								'</form>';
			return teacherPage;
		},
		buttons:{
			"save":{
				label:"保存信息",
				className:"btn-success",
				callback:function(){
					$.ajax({
						url:"<%=request.getContextPath()%>/role/saveOrUpdateRoleInfo.do",
						type:"post",
						data:$("#updateRoleForm").serialize(),
						success:function(){
							bootbox.alert("保存成功");
							$("#roleTable").bootstrapTable("refresh");
						},
						error:function(){
							bootbox.alert("系统错误");
						}
						
					})
				},
			},
			"unSave":{
				label:"取消",
				className:"btn-info",
				callback:function(){
					//return true;//FALSE不关闭
				}
			}
		}
	})
}
</script>
</body>
</html>