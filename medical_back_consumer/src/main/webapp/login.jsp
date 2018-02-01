<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" media="all" href="login/css/pc/login/login-sz.css-v=1514474372141.css" tppabs="https://passport.pinganwj.com/resources/css/pc/login/login-sz.css?v=1514474372141"/>
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js" tppabs="https://passport.pinganwj.com/resources/js/common/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/login/js/common/jquery.cookie.js" tppabs="https://passport.pinganwj.com/resources/js/common/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/login/js/common/jquery.placeholder.min.js" tppabs="https://passport.pinganwj.com/resources/js/common/jquery.placeholder.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/login/js/common/base64.min.js" tppabs="https://passport.pinganwj.com/resources/js/common/base64.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/login/js/common/ares/pawebjs-1.3.0.js" tppabs="https://passport.pinganwj.com/resources/js/common/ares/pawebjs-1.3.0.js"></script>
</head>
<body>
<div id="updateId"></div>
<!-- 页面主体 start -->
<div class="page">
    <div class="login-main">
        <div class="login-content" style="overflow:hidden">
            <div class="login-win">
                <form  id="loginForm" autocomplete="off">
                    <div class="code-type js_login_main js_login_with_pwd">
                        <div class="choice">
                            <span class="code-choice active" name="css_normal_login">登 录</span>
                            <p class="error-tip"></p>
                        </div>
                    </div>
                    <div class="codes-login login-way" data-loginType='1' data-is-curr='1'>
                        <div class="name-box">
                            <!-- <span class="touxiang"></span> -->
                            <input id="username" name="adminMane" type="text" class="name" placeholder="用户名" autocomplete="off" tabindex="1" maxlength="64" style="width: 264px">
                        </div>
                        <div class="code-box">
                            <!-- <span class="code"></span> -->
                            <input type="password" name="adminPwd" class="password" placeholder="账户密码" autocomplete="off" tabindex="2" maxlength="16" style="width: 264px">
                        </div>
                        <div class="remember" style="height: 19px;">
                            <div class="checkbox" style="float: left">
	                            <input type="checkbox" />
	                            <span>记住密码</span>
                            </div>
                            <div class="forget" style="float: right">
                            	<a href="index.jsp" onclick="buttonCollect()" target="_blank">忘记密码</a>
                            </div>
                        </div>
                    </div>
                    <a href="javascript:userLogin();" class="login-btn" tabindex="4" style="display: block; text-decoration: none">登录</a>
					<div class="registerNo"><div class="clear"><i></i><span>还没有云诊所？&nbsp;&nbsp;&nbsp;</span>
					<a href="javascript:userRegister();" rel="leanModal"><span>立即注册</span></a></div></div>
					<div class="serviceNo"><div class="clear"><i></i><span>服务热线：</span><em>400-1028-120&nbsp;（09:00-18:00）</em></div></div>
                </form>
                <a href="#" class="collect" title='万家云诊所' rel="sidebar">收藏到本地</a>
            </div>
        </div>
    </div>
    <div class="page-bottom">版权所有:&nbsp;平安万家医疗投资管理有限责任公司&nbsp;&nbsp;粤ICP备16081915</div>
</div>

<script >
    function userLogin() {
        $.ajax({
            url:"<%=request.getContextPath()%>/login/adminLogin.do",
            type:"post",
            data:$("#loginForm").serialize(),
            dataType:"text",
            success:function(aaa){
            	alert(aaa)
            	if(aaa==0){
                	alert("×账号错误");
                } else if(aaa==1){
					alert("×账号和密码不匹配");
                } else if(aaa==2){
                	location.href="index.jsp";
                } else if(aaa==4) {
                	location.href="show.jsp";
				}
            },
            error:function(){
                alert("QnMb!!!");
            }
        })
    }
</script>
</body>
</html>
