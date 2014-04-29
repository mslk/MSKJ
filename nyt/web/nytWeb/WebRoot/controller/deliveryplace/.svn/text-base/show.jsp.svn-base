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

		<title>交货地信息</title>

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
				<td colspan="2" class="thead">
					<div class="tit_box">
						交货地信息
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					省份:
				</td>
				<td width="70%">
					${deliveryPlace.provincename }
				</td>
			</tr>
			<tr>
				<td width="30%">
					城市:
				</td>
				<td width="70%">
					${deliveryPlace.cityname }
				</td>
			</tr> 
			<tr>
				<td width="30%">
					区县:
				</td>
				<td width="70%">
					${deliveryPlace.countyname }
				</td>
			</tr>
			<tr>
				<td width="30%">
					类型:
				</td>
				<td width="70%">${deliveryPlace.typename}</td>
			</tr>
			<tr>
				<td width="30%">
					名称:
				</td>
				<td width="70%">
					${deliveryPlace.name }
				</td>
			</tr>
			<tr>
				<td width="30%">
					简称:
				</td>
				<td width="70%">
					${deliveryPlace.shortname }
				</td>
			</tr>
			<tr>
				<td width="30%">
					地址:
				</td>
				<td width="70%">
					${deliveryPlace.address }
				</td>
			</tr>
			
			<c:if test="${deliveryPlace.type==0 }">
				<tr>
					<td width="30%">
						发热量:
					</td>
					<td width="70%">
						${deliveryPlace.heating} 大卡
					</td>
				</tr>
				<tr>
					<td width="30%">
						硫分:
					</td>
					<td width="70%">
						${deliveryPlace.sulphur } %
					</td>
				</tr>
				<tr>
					<td width="30%">
						灰分:
					</td>
					<td width="70%">
						${deliveryPlace.ash } %
					</td>
				</tr>
				<tr>
					<td width="30%">
						全水:
					</td>
					<td width="70%">
						${deliveryPlace.moisture } %
					</td>
				</tr>
			</c:if>
		</table>
	</body>
</html>
