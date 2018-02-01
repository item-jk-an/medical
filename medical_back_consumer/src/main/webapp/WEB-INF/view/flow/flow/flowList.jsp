<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/mystyle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br>
		<div class="btn-group">
			<button type="button" class="btn btn-success" onclick="showAddPro()">
				<span class="glyphicon glyphicon-plane">新增</span>
			</button>
 			<button type="button" class="btn btn-default"
				onclick="showUpdatePro()">
				<span class="glyphicon glyphicon-wrench">修改</span>
			</button> 
			<button type="button" class="btn btn-error">
				<span class="glyphicon glyphicon-scissors" onclick="deletePro()">删除</span>
			</button>
		</div>
	<table id="flowTable"></table>
	<script type="text/javascript">
     $(function (){
 		
 		$("#flowTable").bootstrapTable({
 			 url:"<%=request.getContextPath()%>/flow/queryFlowList.do",
 			 method:"post",
 			 striped: true,  	// 斑马线效果     默认false 
 			 //只允许选中一行
 			 singleSelect:true,
 			 //选中行是不选中复选框或者单选按钮
 			 clickToSelect:true,
 			 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
 			 cardView: false,                    //是否显示详细视图
 			 uniqueId: "flowId",                 //每一行的唯一标识，一般为主键列
 			 showColumns: true,                  //是否显示所有的列
 			 showRefresh: true,                  //是否显示刷新按钮
 			 minimumCountColumns: 2,     //  最少留两列
 			 detailView: false,                  //是否显示父子表
 			 //发送到服务器的数据编码类型  
 			contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
 			toolbar:'#tabToolBar',   //  工具定义位置
 			columns:[
  			     	{field:'flowId',title:'',width:50,class:"danger",
 						formatter:function(value,row,index){   //  格式化  当前单元格内容
 							return "<input type='checkbox' value="+value+" name='chk'/>";
 						}
 					},
					{field:'flowId',title:'流程ID', class:'warning',width:100},
					{field:'flowName',title:'流程名称', class:'success',width:100},
						
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
 						 //前台--排序字段
 						 //sortName:'proPrice',
 						 //sortOrder:'desc',
 						 //前台--搜索框
 						 search:true,
 						 //启动回车键做搜索功能
 						 searchOnEnterKey:true,
 				   	    //分页方式   后台请求的分页方式
 						 sidePagination:'server',
 						 pagination: true,                   //是否显示分页（*）
 						 pageNum: 1,                       //每页的记录行数（*）
 						 pageSize: 3,                       //每页的记录行数（*）
 						 pageList: [3, 6, 9,12],        //可供选择的每页的行数（*） 
 		});
 		
 	})
 	
 	
 	 //删除
     function deletePro(){
    	 
    	 var ids = "";
    	 if($("[name='chk']:checked").length>0){
    		 for (var i = 0; i < $("[name='chk']:checked").length; i++) {
 				ids +="," + $("[name='chk']:checked").eq(i).val();
 			}
    		ids = ids.substr(1);
    		//bootbox.alert(ids)
  			$.ajax({
      		    		url:"<%=request.getContextPath()%>/user/deleteUserById.do?ids="+ids,
      		    		success:function(){
      		    			bootbox.alert('删除成功');
      		    			//刷新
      		    			$("#flowTable").bootstrapTable('refresh');
      		    		}
      		    		
      		    	})
 		}else{
 			bootbox.alert("至少选择一个");	
 		}
    	 
     }
     
   //弹框
		function dialog(HTMLurl, submitUrl, title) {
			var dialog = bootbox.dialog({
				title : title,
				message : getJspHtml(HTMLurl), //调用方法  
				buttons : {
					"save" : {
						label : '保存',
						//自定义样式
						className : "btn-success",
						callback : function() {
							$.ajax({
								url : submitUrl,
								type : 'post',
								data : $("#save").serialize(),
								success : function(data) {
									bootbox.alert("保存成功");
									$("#flowTable").bootstrapTable('refresh');
								},
								error : function() {
									bootbox.alert("ajax失败");
								}
							});
						}
					},
					"unSave" : {
						label : '取消',
						//自定义样式
						className : "btn-info",
						callback : function() {
							// return false;  //dialog不关闭
						}
					}
				}
			});
		}
   
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
		


		function showAddPro(){

            dialog("<%=request.getContextPath()%>/flow/tosave.do","<%=request.getContextPath()%>/flow/save.do","新增流程");
		}
	 	
 	
 	
 	</script>
</body>
</html>