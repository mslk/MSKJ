<%@page import="com.meibaolian.util.ConfigUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>客户端版本信息信息列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
		<script src="js/jquery1.6.js" type="text/javascript"></script>
	</head>

	<body>
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="3" class="thead">
					<div class="tit_box">
						客户端版本信息
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					类型:
				</td>
				<td width="30%">
					地址
				</td>
				<td width="40%">
					操作
				</td>
			</tr>
			<tr>
				<td width="30%">
				android 版本
				</td>
				<td width="30%">
				<a href="<%=ConfigUtil.IMAGEPREFIX%>/manual/version/android.xml" target="_blank">查看xml</a>
				</td>
				<td>
				<a href="controller/version/edit.jsp?type=1" >更新android煤宝联版本信息</a> 
				</td>
			</tr>
			<tr>
				<td width="30%">
				ios 版本
				</td>
				<td width="30%">
				<a href="<%=ConfigUtil.IMAGEPREFIX%>/manual/version/ios.xml" target="_blank">查看xml</a>
				</td>
				<td>
				 <a href="controller/version/edit.jsp?type=2" >更新ios煤宝联版本信息</a>
				</td>
			</tr>
			
		</table>
	</body>
</html>
