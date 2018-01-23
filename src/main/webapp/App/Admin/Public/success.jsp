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
<title>登录信息</title>
<link rel="stylesheet" type="text/css" href="<%=contentPath %>/css/login.css">
<style type="text/css">
*{ padding: 0; margin: 0; }
.system-message{ padding: 24px 48px; }
.system-message h1{ font-size: 80px; font-weight: normal; line-height: 120px; margin-bottom: 12px }
.system-message .jump{ padding-top: 10px;margin-bottom:20px}
.system-message .jump a{ color: #333;}
.system-message .success,.system-message .error{ line-height: 1.8em; font-size: 36px }
.system-message .detail{ font-size: 12px; line-height: 20px; margin-top: 12px; display:none}
#wait {
    font-size:46px;
}
#btn-stop,#href{
    display: inline-block;
    margin-right: 10px;
    font-size: 16px;
    line-height: 18px;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    border: 0 none;
    background-color: #360;
    padding: 10px 20px;
    color: #fff;
    font-weight: bold;
    border-color: transparent;
    text-decoration:none;
}

#btn-stop:hover,#href:hover{
    background-color: #390;
}
</style>
</head>
<body>
<div class="login">
    <div class="logo"></div>
    <div id="tip"><h1>跳转页面</h1></div>
    <div id="tip">${error}</div>
    <div id="tip"><b id="wait">${waittime}</b> 秒</div>
    <div id="tip"><a id="href" id="btn-now" href="${jumpUrl}">跳转页面</a> 
    <button id="btn-stop" type="button" onclick="stop()">停止</button> 
    </div>
    <div class="foot">Copyright &copy; 2015 - 2020.新胜达ERP</div>
    <script type="text/javascript">
(function(){
 var wait = document.getElementById('wait'),href = document.getElementById('href').href;
 var interval = setInterval(function(){
     	var time = --wait.innerHTML;
     	if(time <= 0) {
     		location.href = href;
     		clearInterval(interval);
     	};
     }, 1000);
  window.stop = function (){
         console.log(111);
            clearInterval(interval);
 }
 })();
</script>
</div>
</body>
</html>