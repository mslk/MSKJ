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

		<title>客户端用户信息详情</title>

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
						客户端用户信息
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					类型:
				</td>
				<td width="70%">
					<c:choose>
						<c:when test="${userInfo.type==100 }">游客</c:when>
						<c:when test="${userInfo.type==2 }">交易商</c:when>
						<c:when test="${userInfo.type==3 }">物流商</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td width="30%">
					姓名:
				</td>
				<td width="70%">
					${userInfo.realname }
				</td>
			</tr>
			<tr>
				<td width="30%">
					手机:
				</td>
				<td width="70%">
					${userInfo.phone }
				</td>
			</tr>
			<tr>
				<td width="30%">
					公司:
				</td>
				<td width="70%">
					${userInfo.companyname }
				</td>
			</tr>
			<tr>
				<td width="30%">
					联系地址:
				</td>
				<td width="70%">
					${userInfo.address }
				</td>
			</tr>
			<%--<tr>
				<td width="30%">
					登陆名:
				</td>
				<td width="70%">
					${userInfo.loginname }
				</td>
			</tr>
			--%><tr>
				<td width="30%">
					注册时间:
				</td>
				<td width="70%">
					${userInfo.registertime}
				</td>
			</tr>
			<tr>
				<td width="30%">
					状态:
				</td>
				<td width="70%">
					<c:choose>
						<c:when test="${userInfo.status==0 }">有效</c:when>
						<c:when test="${userInfo.status==2 }">黑名单</c:when>
					</c:choose>
				</td>
			</tr>
			<c:if test="${userInfo.type==3 }">
			<tr>
			<td width="30%">
					身份证:
				</td>
				<td width="70%">
				  ${userInfo.cardid}
				</td>
			</tr>
			<tr>
			<td width="30%">
					车牌号:
				</td>
				<td width="70%">
				  ${ userInfo.carnumber}
				</td>
			</tr>
			<tr>
			<td width="30%">
					车架号:
				</td>
				<td width="70%">
				  ${userInfo.frame}
				</td>
			</tr>
			<tr>
			<td width="30%">
					发动机号:
				</td>
				<td width="70%">
				  ${userInfo.engine}
				</td>
			</tr>
			</c:if>
			<!-- 
			<tr>
				<td width="30%">
					推送通知开关:
				</td>
				<td width="70%">
					<c:choose>
						<c:when test="${userInfo.pushstatus==0 }">已开启</c:when>
						<c:when test="${userInfo.pushstatus==1 }">已关闭</c:when>
					</c:choose>
				</td>
			</tr>
			 -->
		</table>
	</body>
</html>
