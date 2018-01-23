<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String bathPath=request.getContextPath();%>
<% String contentPath=bathPath+"/Public/Admin/";%>
<% String imgPath=bathPath+"/Public/Admin/images/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width">
<title>登录</title>
<script type="text/javascript" src="<%=bathPath%>/sta/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contentPath%>/css/login.css">
</head>
<body>
<div class="login">
  <form method="POST" action="<%=bathPath%>/gmsuser/login">
    <div class="logo"></div>
    <div class="login_form">
      <div class="user">
        <input class="text_value" value="" name="user.username" type="text" id="username" placeholder="用户名  | username">
        <input class="text_value" value="" name="user.password" type="password" id="password" placeholder="密码   | password">
      </div>
      <button class="button" id="submit" type="submit">登录</button>
    </div>
    <div id="tip"></div>
    <div class="foot">Copyright &copy; 2015 - 2020.新胜达ERP</div>
  </form>
</div></body>
</html>
<script>
$(function(){
	$('#register').click(function(){
		window.location.href="App/Admin/Public/register.html"
	})
})
</script>