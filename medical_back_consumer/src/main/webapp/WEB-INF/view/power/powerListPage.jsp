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
	<!-- 引入ztree实例的样式 -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/zTree/css/demo.css" type="text/css">
	<!-- 引入ztree的样式 -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
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
	<!-- 引入ztree的js -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/zTree/js/jquery.ztree.core.js"></script>
	<!-- 引入ztree复选框的js -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/zTree/js/jquery.ztree.excheck.js"></script>
	<!-- 引入ztree编辑的js -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/zTree/js/jquery.ztree.exedit.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
	    <div class="col-xs-6" style="margin-top: 50px">
	        <div class="panel panel-primary">
	            <div class="panel-heading">权限管理</div>
	            <div class="panel-body">
	                <ul id="menuTree" class="ztree" style="width: 300px;margin-left: 25px"></ul>
	            </div>
	        </div>
	    </div>
	    <div class="col-xs-6" style="margin-top: 50px">
	        <div class="panel panel-primary">
	            <div class="panel-heading">添加权限</div>
	            <div class="panel-body">
	                <button type="button" class="btn btn-success" onclick="createChildNode()">
				    	<span class="glyphicon glyphicon-plane">新建子节点</span>
				    </button>
	                <button type="button" class="btn btn-success" onclick="createRootNode()">
				    	<span class="glyphicon glyphicon-plane">新建根节点</span>
				    </button>
	                <button type="button" class="btn btn-success" onclick="updateNodeInfo()">
				    	<span class="glyphicon glyphicon-plane">修改节点</span>
				    </button><br><br>
				    <form id="powerForm">
				    	<div class="form-group">
							<input type="hidden" name="id">
						</div>
				    	<div class="form-group">
							<input type="text" class="form-control" name="text" placeholder="节点名称">
						</div>
				    	<div class="form-group">
							<input type="text" class="form-control" name="url" placeholder="节点路径">
						</div>
				    	<div class="form-group">
							<input type="text" class="form-control" name="pid" placeholder="选择父级ID">
						</div>
				    </form>
				    <button type="button" class="btn btn-success" onclick="saveOrUpdatePowerInfo()">
				    	<span class="glyphicon glyphicon-plane">保存信息</span>
				    </button>
				    <button type="button" class="btn btn-success" onclick="deletePowerInfo()">
				    	<span class="glyphicon glyphicon-plane">删除权限</span>
				    </button>
	            </div>
	        </div>
	    </div>
	</div>
</div>
<script type="text/javascript">
var setting = {
	data:{
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pid",
			rootPId:0,
		},
		key:{
			url:"xurl",
			name: "text",
		}
	},
};
$(function (){
	loadPower();
})
function createChildNode(){
	var treeObj = $.fn.zTree.getZTreeObj("menuTree");
	var checkedNodes = treeObj.getSelectedNodes();
	if (checkedNodes.length != 0) {
		$('[name="pid"]').val(checkedNodes[0].id);
	} else {
		bootbox.alert("请选择节点");
	}
}
function createRootNode(){
	$('[name="pid"]').val(0);
}

function loadPower(){
	$.ajax({
		url:"<%=request.getContextPath()%>/power/queryPowerAllInfo.do",
		dataType:'json',
		type:'post',
		async:true,
		success:function(trees){
			$.fn.zTree.init($("#menuTree"),setting,trees);
		},
		error:function(){
			alert("加载失败")
		}
	});
}
function updateNodeInfo(){
	var treeObj = $.fn.zTree.getZTreeObj("menuTree");
	var checkedNodes = treeObj.getSelectedNodes();
	if (checkedNodes.length != 0) {
		$('[name="pid"]').val(checkedNodes[0].pid);
		$('[name="id"]').val(checkedNodes[0].id);
		$('[name="url"]').val(checkedNodes[0].url);
		$('[name="text"]').val(checkedNodes[0].text);
	} else {
		bootbox.alert("请选择节点");
	}
}
function saveOrUpdatePowerInfo(){
	$.ajax({
		url:"<%=request.getContextPath()%>/power/saveOrUpdatePowerInfo.do",
		data:$("#powerForm").serialize(),
		type:'post',
		success:function(trees){
			bootbox.alert("新增成功");
			loadPower();
			location.href=location;
		},
		error:function(){
			bootbox.alert("失败");
		}
	});
}

function deletePowerInfo(){
	var treeObj = $.fn.zTree.getZTreeObj("menuTree");
	var checkedNodes = treeObj.getSelectedNodes();
	if (checkedNodes.length != 0) {
		$('[name="pid"]').val(checkedNodes[0].pid);
		$('[name="id"]').val(checkedNodes[0].id);
		$('[name="url"]').val(checkedNodes[0].url);
		$('[name="text"]').val(checkedNodes[0].text);
		if (confirm("确定要删除信息吗？")) {
			$.ajax({
				url:"<%=request.getContextPath()%>/power/deletePowerInfo.do",
				data:{"id":checkedNodes[0].id},
				type:'post',
				success:function(trees){
					bootbox.alert("删除成功");
					loadPower();
					location.href=location;
				},
				error:function(){
					bootbox.alert("失败");
				}
			});
		}
	} else {
		bootbox.alert("请选择节点");
	}
}
</script>
</body>
</html>