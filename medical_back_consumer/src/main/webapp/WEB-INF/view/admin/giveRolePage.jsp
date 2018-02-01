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
<div class="panel panel-primary">
    <div class="panel-heading">${admin.adminMane}赋角色列表</div>
    <div class="panel-body">
   		<div id="tabToolBar" class="btn-group">
		    <button type="button" class="btn btn-success">
		    	<span class="glyphicon glyphicon-plane">赋角色</span>
		    </button>
	  	</div>
	  	<input type="hidden" value="${admin.adminId}" id="user_id"/>
        <table id="rolesTable"></table>
    </div>
</div>
<script type="text/javascript">
$(function() {
	$("#rolesTable").bootstrapTable({
		url:"<%=request.getContextPath()%>/role/queryRoleAllShowList.do",
		 method:"post",
		 striped: true,// 斑马线效果     默认false 
		 //只允许选中一行
		 //singleSelect:true,
		 //选中行是不选中复选框或者单选按钮
		 clickToSelect:true,
		 //showToggle:true,    //是否显示详细视图和列表视图的切换按钮
		 //cardView:false,     //是否显示详细视图
		 uniqueId: "roleId",   //每一行的唯一标识，一般为主键列
		 //showColumns: true,  //是否显示所有的列
		 //showRefresh: true,  //是否显示刷新按钮
		 //minimumCountColumns: 2, //  最少留两列
		 detailView: false,        //是否显示父子表
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
		columns:[
					{field:'',title:'',width:35,checkbox:true},
					{field:'roleId',title:'角色ID',width:35,},
					{field:'roleName',title:'角色名称',width:60},
		        ],
     //分页方式   后台请求的分页方式
	 sidePagination:'server',
	 pagination: true,                   //是否显示分页（*）
	 pageNum: 1,                       //每页的记录行数（*）
	 pageSize: 20,                       //每页的记录行数（*）
	 pageList: [20],        //可供选择的每页的行数（*）
	 paginationVAlign:"bottom",
	});
})

function getSelectionsIds(){
	var ids = '';
	var datas = $("#rolesTable").bootstrapTable("getSelections");
	if (datas != null) {
		for (var i = 0; i < datas.length; i++) {
			ids += datas[i].roleId + ",";
		}
	}
	return ids;
}
</script>
</body>
</html>