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

		<title>供应详情</title>

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
					<c:choose>
				    	<%--2胶合板,3原木,4淀粉 --%>
				    	<c:when test="${dto.int_valueA ==2 }">
				    		 <div class="tit_box">胶合板供应详情</div>
				    	</c:when>
				    	<c:when test="${dto.int_valueA ==3 }">
				    		 <div class="tit_box">原木供应详情</div>
				    	</c:when>
				    	<c:when test="${dto.int_valueA ==4 }">
				    		 <div class="tit_box">淀粉供应详情</div>
				    	</c:when>
				    </c:choose>
				</td>
			</tr>

		　	<tr>
				<td width="30%">
					发布人
				</td>
				<td width="70%">
					${vo.userinfo.realname }
				</td>
			</tr>
			
			<tr>
				<td>价格</td>
				<td>${vo.price }</td>
			</tr>
			
			<tr>
				<td>数量</td>
				<td>${vo.number }</td>
			</tr>
  
			<tr>
				<td>发布时间</td>
				<td>${vo.addtime }</td>
			</tr>
<c:choose>
			<%--2胶合板,3原木,4淀粉 --%>
			<c:when test="${dto.int_valueA ==2 }">
				 <tr>
					<td>长</td>
					<td>${vo.length }</td>
				</tr>
				<tr>
					<td>宽</td>
					<td>${vo.width }</td>
				</tr>
				<tr>
					<td>厚</td>
					<td>${vo.thickness }</td>
				</tr>
			</c:when>
			<c:when test="${dto.int_valueA ==3 }">
				 <tr>
					<td>材种</td>
					<td>${vo.cultivated }</td>
				</tr>
				<tr>
					<td>尾径</td>
					<td>${vo.tail_directly }</td>
				</tr>
				<tr>
					<td>单位</td>
					<td>
						<c:choose>
							<c:when test="${vo.unit==1 }">吨</c:when>
							<c:when test="${vo.unit!=1 }">立方米</c:when>
						</c:choose>
					</td>
				</tr>
			</c:when>
			<c:when test="${dto.int_valueA ==4 }">
				 <tr>
					<td>品牌</td>
					<td>${vo.brand }</td>
				</tr>
				<tr>
					<td>等级</td>
					<td>	
						<c:choose>
							<c:when test="${vo.level==1 }">优质品</c:when>
							<c:when test="${vo.level==2 }">一级品</c:when>
							<c:when test="${vo.level==3 }">合格品</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>产地</td>
					<td>${vo.producer }</td>
				</tr>
			</c:when>
		</c:choose>			
			<tr>
				<td>状态</td>
			 	<td>
			    	<c:choose>
			    		<c:when test="${vo.status==0 }">正常</c:when>
			    		<c:when test="${vo.status==1 }"><label style="color: red">屏蔽</label></c:when>
			    	</c:choose>
	   		 	</td>
			</tr>
			
			<tr>
				<td>描述</td>
				<td>${vo.description }</td>
			</tr>
			
			 <tr>
	    		<td colspan="2"  style="text-align: center;">
					<input type="button" value="返回"  onclick="javascript:location.href='nyt/woodSupplysearch.action?dto.int_valueA=${dto.int_valueA}'" />
			 	</td>
			 </tr>
		</table>
	</body>
</html>
