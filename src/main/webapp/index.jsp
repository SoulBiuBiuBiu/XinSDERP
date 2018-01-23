<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String bathPath = request.getContextPath();
%>
<%
	String contentPath = bathPath + "/Public/Admin/";
%>
<%
	String imgPath = bathPath + "/Public/Admin/images/";
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>新胜达ERP</title>
<link rel="stylesheet" type="text/css"
	href="<%=bathPath%>/sta/easyui/themes/gms/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=contentPath%>/css/main.css">
<link rel="stylesheet" type="text/css"
	href="<%=bathPath%>/sta/iconfont/iconfont.css">
<link rel="stylesheet"
	href="<%=bathPath%>/sta/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="<%=bathPath%>/sta/kindeditor/themes/simple/simple.css" />
<script type="text/javascript" src="<%=bathPath%>/sta/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=bathPath%>/sta/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=bathPath%>/sta/easyui/datagrid-detailview.js"></script>
<script type="text/javascript"
	src="<%=bathPath%>/sta/easyui/easyui-lang-zh_CN.js"></script>
<script charset="utf-8"
	src="<%=bathPath%>/sta/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="<%=bathPath%>/sta/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="<%=contentPath%>js/main.js"></script>

</head>
<body id="layout_main" class="easyui-layout">
	<div id="layout_north" data-options="region:'north',border:false">
		<div class="top_left">
			<a href="#" class="logo"><img src="<%=imgPath%>/logo.png"></a>
		</div>
		<ul class="top_nav">
			<c:forEach items="${menulist }" var="item">
				<li><a onclick="MainMenuClick(${item.id})"
					id='t_nav_${item.id}'><span class="${item.icon}"></span>
						<h2>${item.title}</h2></a></li>
			</c:forEach>
		</ul>
		<div class="top_right">
			<ul>
				<li><span class="iconfont icon-help" style="font-size:12px;"></span><a
					href="#">帮助</a></li>
				<!--li><span class="iconfont icon-edit" style="font-size:12px;"></span><a href="{:U('User/updatePassword')}" class="topbar_menu">ä¿®æ¹å¯ç </a></li>
      <li><span class="iconfont icon-set" style="font-size:12px;"></span><a href="{:U('User/updateNickname')}" class="topbar_menu">ä¿®æ¹æµç§°</a></li-->
				<li><span class="iconfont icon-more" style="font-size:12px;"></span><a
					href="/XinSDERP/gmsuser/loginout" class="topbar_menu">退出</a></li>
			</ul>
			<div class="top_user">
				<span><font class="iconfont icon-account"
					style="color:#fff; padding-right:5px;"></font>admin</span> <i>消息</i> <b>0</b>
			</div>
		</div>
	</div>
	<div id="layout_west"
		data-options="region:'west',split:true,title:'菜单栏'">
		<ul id="LeftMenu" class="easyui-tree"
			data-options="url:'#',id:'id',text:'name',animate:true,lines:true,onClick:function(node){LeftMenuClick(node);}">
		</ul>
	</div>
	<div id="layout_center" data-options="region:'center',split:true">
		<div id="MainTabs" class="easyui-tabs"
			data-options="fit:true,border:false">
			<div title="首页"
				data-options="closable:false,id:-1,iconCls:'iconfont icon-all',bodyCls:'tabs_box'"
				style="padding:5px;"></div>
		</div>
	</div>
</body>
</html>