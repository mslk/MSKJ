<%@page import="com.meibaolian.util.ConfigUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>广告管理</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" charset="UTF-8"
			src="js/base.js"></script>	
</head>
<body>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="4"class="thead">
     <div class="tit_box">广告列表</div>
    </td>
  </tr>
	<tr>
	    <td width="20%">类型</td>
		<td width="30%">图片</td>
		<td width="30%">广告地址</td>
		<td width="20%">管理</td>
	</tr>
	<c:set var="len" value="0"></c:set>
<c:forEach items="${request.result}" var="advertising"   varStatus="a" >
	<tr>
		<td>
		<c:if test="${ advertising.type==1}">ios 广告</c:if>
		<c:if test="${ advertising.type==2}">android 广告</c:if>
		</td>
		<td>
		<img width="300px" height="50px" src="<%=ConfigUtil.IMAGEPREFIX %>${advertising.imageurl }"/>
		<a class="bts_link" href="<%=ConfigUtil.IMAGEPREFIX %>${advertising.imageurl }" target="_blank">查看原图</a>
		</td>
	    <td>${advertising.targeturl }</td>
	    <td><a class="bts_link" href="otherAid/advertisingManager_toUpdate.action?advId=${advertising.id }">修改</a></td>
	</tr>
	<c:set var="len" value="${a.index }"></c:set>
  </c:forEach>
  <c:if test="${len<1}">
   <tr>
     <td colspan="4">
		<a class="bts_link" href="otherAid/advertisingManager_implortDefaultData.action"> 导入数据 </a>
	 </td>
   </tr>
    </c:if>

   </table>
</body>
</html>