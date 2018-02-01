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
<body class="container">
<div class="row">
	<div id="tabToolBar" class="btn-group" style="margin-left: 150px;margin-bottom: 10px;">
	    <button type="button" class="btn btn-success" onclick="movePowerToRole()">
	    	<span class="glyphicon glyphicon-plane">添加到角色</span>
	    </button>
	    <button type="button" class="btn btn-success" onclick="romovePowerFromRole()">
	    	<span class="glyphicon glyphicon-plane">从角色删除</span>
	    </button>
  	</div>
</div>
<div class="row">
    <div class="col-xs-5" style="margin-left: 110px">
        <div class="panel panel-primary">
            <div class="panel-heading">角色权限</div>
            <div class="panel-body">
                <ul id="menuTree" class="ztree"></ul>
            </div>
        </div>
    </div>
    <div class="col-xs-5">
        <div class="panel panel-primary">
            <div class="panel-heading">修改${role.roleName}权限</div>
            <div class="panel-body">
				<input type="hidden" name="roleId" id="role_Id" value="${role.roleId}"/>
				<ul id="rolePowerTree" class="ztree"></ul>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
var powerData = new Array();
var setting = {
		check:{
			enable: true,
			chkStyle: "checkbox",
			chkboxType : {
                "Y" : "ps",
                "N" : "ps"
            }
		},
		data:{
			simpleData:{
				enable:true,
				idKey:"id",
				pIdKey:"pid",
			},
			key:{
				url:"Xurl",
				name:"text"
			}
		},
	}
	$(function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/power/queryPowerInfoByRoleId.do",
			data:{"roleId":"${role.roleId}"},
			dataType:'json',
			async:true,
			success:function(trees){
				$.fn.zTree.init($("#rolePowerTree"),setting,trees);
				powerData = trees;
			},
			error:function(){
				alert("加载失败")
			}
		})
		$.ajax({
			url:"<%=request.getContextPath()%>/power/queryPowerAllInfo.do",
			dataType:'json',
			type:'post',
			async:true,
			success:function(trees){
				$.fn.zTree.init($("#menuTree"),setting,trees);
				var treeObj = $.fn.zTree.getZTreeObj("menuTree");
				for (var i = 0; i < powerData.length; i++) {
					var power = treeObj.getNodeByParam("id",powerData[i].id);
					treeObj.checkNode(power,true,true);
				}
			},
			error:function(){
				alert("加载失败")
			}
		});
	})

	function movePowerToRole(){
		var treeObj = $.fn.zTree.getZTreeObj("menuTree");
		var selectNodes = treeObj.getCheckedNodes(true);
		$.fn.zTree.destroy("rolePowerTree");
		if (selectNodes != null && selectNodes.length != 0) {
			var nodesData = new Array();
			for (var i = 0; i < selectNodes.length; i++) {
				var power = {"id":selectNodes[i].id,"pid":selectNodes[i].pid,"url":selectNodes[i].url,"text":selectNodes[i].text}
				nodesData.push(power);
			}
			setting = {
					check:{
						enable: true,
						chkStyle: " radio",
						chkboxType : {
			                "Y" : "s",
			                "N" : "s"
			            }
					},
					data:{
						simpleData:{
							enable:true,
							idKey:"id",
							pIdKey:"pid",
						},
						key:{
							url:"Xurl",
							name:"text"
						}
					},
				}
			$.fn.zTree.init($("#rolePowerTree"),setting,nodesData);
		} else {
			alert("请选择权限");
		}
	}
	function romovePowerFromRole(){
		var treeObjRole = $.fn.zTree.getZTreeObj("rolePowerTree");
		var selectNodes = treeObjRole.getCheckedNodes(true);
		var treeObj = $.fn.zTree.getZTreeObj("menuTree");
		if (selectNodes.length!=0) {
			for (var i = 0; i < selectNodes.length; i++) {
				treeObjRole.removeNode(selectNodes[i]);
				var power = treeObj.getNodeByParam("id",selectNodes[i].id);
				treeObj.checkNode(power,false,true);
			}
		}else {
			alert("请选择要删除的角色权限");
		}
	}
	function getRolePowerIds(){
		var ids = "";
		var treeObjRole = $.fn.zTree.getZTreeObj("rolePowerTree");
		var rootNodes = treeObjRole.getNodes();
		var roleNodes = treeObjRole.transformToArray(rootNodes)
		for (var i = 0; i < roleNodes.length; i++) {
			ids += roleNodes[i].id + ","
		}
		return ids;
	}
</script>
</body>
</html>