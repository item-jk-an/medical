<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/js/table/bootstrap-table.min.css" rel="stylesheet"/>
	<!-- 引入jQuery的js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/table/bootstrap-table.min.js"></script>
	<!-- 引入bootstrap表格语言的js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootbox/bootbox.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/table/locale/bootstrap-table-zh-CN.js"></script>
</head>
<body>
<div class="panel panel-primary">
	<div class="panel-body">
		<table id="userTable"></table>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$("#userTable").bootstrapTable({
		url:"<%=request.getContextPath()%>/user/selectUserShowList.do",
		 method:"post",
		 striped: true,// 斑马线效果     默认false 
		 //只允许选中一行
		 singleSelect:true,
		 //选中行是不选中复选框或者单选按钮
		 clickToSelect:true,
		 //showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		 //cardView:false,                    //是否显示详细视图
		 uniqueId: "userId",                 //每一行的唯一标识，一般为主键列
		 //showColumns: true,                  //是否显示所有的列
		 //showRefresh: true,                  //是否显示刷新按钮
		 minimumCountColumns: 2,     //  最少留两列
		 detailView: false,                  //是否显示父子表
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
		columns:[
		         	{field:'userId',title:'',width:50,class:"danger",
	                    formatter:function(value,row,index){   //  格式化  当前单元格内容
	                        return "<input type='checkbox' value="+value+" name='chk'/>";
	                    }
	                },
					{field:'userId',title:'ID',width:35,},
					{field:'userAccount',title:'账号',width:60},
					{field:'userNiki',title:'昵称',width:60},
					{field:'userPhone',title:'电话',width:60},
					{field:'userId',title:'查看用户详情', class:'success',width:100,
	                    formatter:function(value,row,index){   //  格式化  当前单元格内容
	                        return "<input type='button' value='查看' onclick='chakan("+value+")'>"
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
</script>
<script type="text/javascript">
//拿到要跳转的页面
    function getJspHtml(urlStr){
        var  jspHtml = "";
        //  async  (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
        //注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
        $.ajax({
            url:urlStr,
            type:'post',
            //同步的ajax
            async:false,
            success:function(data){
                //alert(data);//data--addProduct.jsp页面内容
                jspHtml = data;
            },
            error:function(){
                bootbox.alert("ajax失败");
            }
        });
        return jspHtml;
    }
//弹框
function dialog(HTMLurl,title) {
    var dialog = bootbox.dialog({
        title : title,
        message : getJspHtml(HTMLurl), //调用方法
    });
}
  
function chakan(id){
	dialog("<%=request.getContextPath()%>/user/queryUserListById.do?id="+id,"查看详情");
    }

<%-- 
function giveRoleToUser(userId,userName){
	bootbox.dialog({
		title:"修改角色权限信息",
		message:function(){
			var teacherPage = '';
			$.ajax({
				url:"<%=request.getContextPath()%>/user/toGiveRolePage.do",
				data:{"userId":userId,"userName":userName},
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
					var ids = getSelectionsIds();
					if (ids == null || ids == '' || ids.length == 0) {
						alert("请选择角色信息")
						giveRoleToUser(userId,userName);
						return;
					}
					alert($("#user_id").val())
					$.ajax({
						url:"<%=request.getContextPath()%>/user/giveRolesToUser.do",
						type:"post",
						data:{"ids":getSelectionsIds(),"userId":$("#user_id").val()},
						success:function(){
							bootbox.alert("成功赋权限");
							$("#userTable").bootstrapTable("refresh");
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
} --%>
</script>
</body>
</html>