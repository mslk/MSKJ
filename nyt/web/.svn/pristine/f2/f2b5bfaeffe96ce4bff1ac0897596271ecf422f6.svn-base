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

		<title>货讯信息详情</title>

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
						货讯信息
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="30%">
					发布人:
				</td>
				<td width="70%">
					${transportDemand.username }
				</td>
			</tr>
			<tr>
				<td width="30%">
					发布时间:
				</td>
				<td width="70%">
					<fmt:formatDate  value="${transportDemand.addtime}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					发货时间:
				</td>
				<td width="70%">
					<fmt:formatDate  value="${transportDemand.sendoutdate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					有效期:
				</td>
				<td width="70%">
					<fmt:formatDate  value="${transportDemand.validdate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					手机:
				</td>
				<td width="70%">
					${transportDemand.phone }
				</td>
			</tr>
			<tr>
				<td width="30%">
					始发地:
				</td>
				<td width="70%">
					<c:choose>
			    		<c:when test="${transportDemand.startshortname != null}">${transportDemand.startshortname}</c:when>
			    		<c:otherwise>${transportDemand.startprvname} - ${transportDemand.startcityname} - ${transportDemand.start }</c:otherwise>
			    	</c:choose>
			    </td>
			</tr>
			<tr>
				<td width="30%">
					目的地:
				</td>
				<td width="70%">
					<c:choose>
			    		<c:when test="${transportDemand.stopshortname != null}">${transportDemand.stopshortname}</c:when>
			    		<c:otherwise>${transportDemand.stopprvname} - ${transportDemand.stopcityname} - ${transportDemand.stop }</c:otherwise>
			    	</c:choose>
				</td>
			</tr>
			<tr>
				<td width="30%">
					车数量:
				</td>
				<td width="70%">
					${transportDemand.quantity }
				</td>
			</tr>

			
			<tr>
				<td width="30%">
					价格:
				</td>
				<td width="70%">
					${transportDemand.price }
				</td>
			</tr>
			<!--<tr>
				<td width="30%">
					默认排序值:
				</td>
				<td width="70%">
					${transportDemand.sortnumber }
				</td>
			</tr>
			  <tr>
				<td width="30%">
					翻译状态:
				</td>
				<td width="70%">
					<c:choose>
						<c:when test="${transportDemand.status==0 }">未翻译</c:when>
						<c:when test="${transportDemand.status==1 }">已翻译</c:when>
					</c:choose>
				</td>
			</tr>-->
		</table>
	</body>
</html>
