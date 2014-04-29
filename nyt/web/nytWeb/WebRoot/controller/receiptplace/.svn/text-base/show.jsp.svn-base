<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>地区信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	</head>

	<body>
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="4" class="thead">
					<div class="tit_box">
						地区信息
					</div>
				</td>
			</tr>
			<tr>
				<td width="15%">
					省份id:
				</td>
				<td width="35%">
					${receiptPlace.provinceid }
				</td>
				<td width="15%">
					省份:
				</td>
				<td width="35%">
					${receiptPlace.provincename }
				</td>
			</tr>
			<tr>
				<td width="15%">
					城市id:
				</td>
				<td width="35%">
					${receiptPlace.cityid }
				</td>
				<td width="15%">
					城市:
				</td>
				<td width="35%">
					${receiptPlace.cityname }
				</td>
			</tr> 
			<tr>
				<td width="15%">
					区县id:
				</td>
				<td width="35%">
					${receiptPlace.id }
				</td>
				<td width="15%">
					区县:
				</td>
				<td width="35%">
					${receiptPlace.name }
				</td>
			</tr>
			<tr>
				<td width="15%">
					简称:
				</td>
				<td width="85%" colspan="3">
					${receiptPlace.shortname }
				</td>
			</tr>
		</table>
	</body>
</html>
