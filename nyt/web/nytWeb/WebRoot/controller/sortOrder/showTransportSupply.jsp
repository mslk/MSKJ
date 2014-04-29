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

		<title>修改车讯信息排序值</title>

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
		<form  id="form1" action="transportSupply/updateSortnumber.action" method="post">
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<input type="hidden" name="transportSupply.id" value="${transportSupply.id}" />
			<tr>
				<td colspan="2" class="thead">
					<div class="tit_box">
						修改排序值
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					当前排序值:
				</td>
				<td width="70%">
					<input type="text" name="transportSupply.sortnumber" value="${transportSupply.sortnumber }"/>
					<input type="submit" value="提交" />
				</td>
			</tr>
			<tr>
				<td colspan="2" class="thead">
					<div class="tit_box">
						车讯信息
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="30%">
					发布人:
				</td>
				<td width="70%">
					${transportSupply.username }
				</td>
			</tr>
			<tr>
				<td width="30%">
					发布时间:
				</td>
				<td width="70%">
					<fmt:formatDate  value="${transportSupply.addtime}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					车牌号码:
				</td>
				<td width="70%">
				${transportSupply.carnumber}
				</td>
			</tr>
			<tr>
				<td width="30%">
					有效期:
				</td>
				<td width="70%">
					<fmt:formatDate  value="${transportSupply.validdate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					手机:
				</td>
				<td width="70%">
					${transportSupply.phone }
				</td>
			</tr>
			<tr>
				<td width="30%">
					始发地:
				</td>
				<td width="70%">
				     <c:choose>
			    		<c:when test="${transportSupply.startshortname != null}">${transportSupply.startshortname}</c:when>
			    		<c:otherwise>${transportSupply.startprvname} - ${transportSupply.startcityname} - ${transportSupply.start }</c:otherwise>
			    	</c:choose>
				</td>
			</tr>
			<tr>
				<td width="30%">
					目的地:
				</td>
				<td width="70%">
					<c:choose>
			    		<c:when test="${transportSupply.stopshortname != null}">${transportSupply.stopshortname}</c:when>
			    		<c:otherwise>${transportSupply.stopprvname} - ${transportSupply.stopcityname} - ${transportSupply.stop }</c:otherwise>
			    	</c:choose>
				</td>
			</tr>
			<tr>
				<td width="30%">
					车数量:
				</td>
				<td width="70%">
					${transportSupply.quantity }
				</td>
			</tr>

			
			<tr>
				<td width="30%">
					价格:
				</td>
				<td width="70%">
					${transportSupply.price }
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
		</form>
	</body>
</html>
