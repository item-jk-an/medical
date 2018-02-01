<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css" rel="stylesheet"/>
<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootbox/bootbox.js"></script>
<form id="drugForm">
	<input type="hidden"   name="drugId"  value="${user.userId}">
	<div class="form-group">
		<label>账号：</label>
		<label>${user.userAccount}</label>
	</div>
	<div class="form-group">
		<label>昵称：</label>
		<label>${user.userNiki}</label>
	</div>
	<div class="form-group">
		<label>电话：</label>
		<label>${user.userPhone}</label>
	</div>
	<div class="form-group">
		<label>密码：</label>
		<label>${user.userPass}</label>
	</div>
	<div class="form-group">
		<label>登录时间：</label>
		<label>${user.showLoginDate}</label>
	</div>
	<div class="form-group">
		<label>注册时间：</label>
		<label>${user.showRegDate}</label>
	</div>
	<div class="form-group">
		<label>用户状态：</label>
		<label>${user.userState}</label>
	</div>
	<div class="form-group">
		<label>用户类型：</label>
		<label>
			${user.userType==1?"医生 ":""}
			${user.userType==2?"医院":""}
			${user.userType==3?"普通":""}
		</label>
	</div>
	<div class="form-group">
		<label>等级：</label>
		<label>${user.userLevel}</label>
	</div>
	<div class="form-group">
		<label>积分：</label>
		<label>${user.userScore}</label>
	</div>
	
	<div class="form-group">
		<label>头像id
		：</label>
		<label>${user.userHeadId}</label>
	</div>

</form>