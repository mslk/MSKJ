<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>后台操作首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
  </head>
  
  <body class="topbody">
    <div id="top_box">
    <div class="tow_links">
    <ul>
    	<li><img src="images/home.png" /></li>
        <li style="padding-right:10px;"><a href="controller/share/advertising.jsp" target="main">首页</a></li>
        <li><img src="images/i_001.gif" /></li>
        <li style="padding-right:10px;"><a href="controller/userManager/update.jsp" target="main">修改密码</a></li>
        <li><img src="images/i_002.gif" /></li>
        <li><a href="user/system_outLogin.action" target="_top">退出系统</a></li>
    </ul>
    </div>
    </div>
  </body>
</html>
