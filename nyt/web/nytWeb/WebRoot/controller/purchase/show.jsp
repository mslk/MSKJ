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

		<title>求购信息详情</title>

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
						求购信息
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="30%">
					发布人:
				</td>
				<td width="70%">
					${purchase.buyername }
				</td>
			</tr>
			<tr>
				<td width="30%">
					发布时间:
				</td>
				<td width="70%">
					<fmt:formatDate  value="${purchase.addtime}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					有效期:
				</td>
				<td width="70%">
					<fmt:formatDate  value="${purchase.validdate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					手机:
				</td>
				<td width="70%">
					${purchase.phone }
				</td>
			</tr>
			<tr>
				<td width="30%">
					煤种:
				</td>
				<td width="70%">${purchase.coalname }</td>
			</tr>
			<tr>
				<td width="30%">
					粒度:
				</td>
				<td width="70%">
					${purchase.coalsizename }
				</td>
			</tr>
			<tr>
				<td width="30%">
					交货地:
				</td>
				<td width="70%">${purchase.startprvname} - ${purchase.startcityname} - ${purchase.startcountyname} - ${purchase.place}
					<%--<c:choose>
			    		<c:when test="${purchase.startshortname != null}">${purchase.startshortname}</c:when>
			    		<c:otherwise>${purchase.startprvname} - ${purchase.startcityname} - ${purchase.startcountyname} - ${purchase.place}</c:otherwise>
			    	</c:choose>
				--%></td>
			</tr>
			<tr>
				<td width="30%">
					发热量:
				</td>
				<td width="70%">
					${purchase.heating } 大卡
				</td>
			</tr>
			
			<tr>
				<td width="30%">
					硫分:
				</td>
				<td width="70%">
					${purchase.sulphur } %
				</td>
			</tr>
			<tr>
				<td width="30%">
					灰分:
				</td>
				<td width="70%">
					${purchase.ash } %
				</td>
			</tr>
			<tr>
				<td width="30%">
					全水:
				</td>
				<td width="70%">
					${purchase.moisture } %
				</td>
			</tr>
			<%--<tr>
				<td width="30%">
					不含税价格:
				</td>
				<td width="70%">
					${purchase.price }
				</td>
			</tr>
			<tr>
				<td width="30%">
					含税价格:
				</td>
				<td width="70%">
					${purchase.taxprice }
				</td>
			</tr>
			<tr>
				<td width="30%">
					运输方式:
				</td>
				<td width="70%">
					<c:choose>
			    		<c:when test="${purchase.transportype==null }">无</c:when>
			    		<c:when test="${purchase.transportype==0 }">铁路</c:when> 
			    		<c:when test="${purchase.transportype==1 }">公路</c:when>
			    	</c:choose>
				</td>
			</tr>
			--%>
			
			<tr>
				<td width="30%">
					收货地:
				</td>
				<td width="70%">
					<c:choose>
			    		<c:when test="${purchase.stopshortname != null}">${purchase.stopshortname}</c:when>
			    		<c:otherwise>${purchase.stopprvname} - ${purchase.stopcityname} - ${purchase.receiptplace }</c:otherwise>
			    	</c:choose>
				</td>
			</tr>
			<tr>
				<td width="30%">
					数量:
				</td>
				<td width="70%">
					${purchase.quantity } 吨
				</td>
			</tr>
			<tr>
				<td width="30%">
					默认排序值:
				</td>
				<td width="70%">
					${purchase.sortnumber }
				</td>
			</tr>
			<!--  <tr>
				<td width="30%">
					翻译状态:
				</td>
				<td width="70%">
					<c:choose>
						<c:when test="${purchase.status==0 }">未翻译</c:when>
						<c:when test="${purchase.status==1 }">已翻译</c:when>
					</c:choose>
				</td>
			</tr>-->
		</table>
	</body>
</html>
