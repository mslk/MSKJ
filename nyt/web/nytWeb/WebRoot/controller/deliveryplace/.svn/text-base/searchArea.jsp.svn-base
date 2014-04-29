<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>uesr search</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>	
	<script type="text/javascript" charset="UTF-8"
			src="js/base.js"></script>	
</head>
<body>
<form  id="form1" action="deliveryplace/searchArea.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="3" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="deliveryPlaceDto.keyword"  placeholder="省/市/县名称" value="${deliveryPlaceDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>
		<td style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="5" class="thead">
 <div class="tit_box">交货地地区列表</div>
    </td>
  </tr>
	<tr>
		<td>省份</td>
		<td>城市</td>
		<td>区县</td>
		<td>简称</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="deliveryArea" >
	<tr>
		<td>${deliveryArea.provincename }</td>
		<td>${deliveryArea.cityname }</td>
		<td>${deliveryArea.countyname }</td>
	    <td>${deliveryArea.shortcountyname }</td>
	    <td>
	    	<a class="bts_link" href="deliveryplace/initAdd.action?id=${deliveryArea.id}" >添加地区下交货地</a> 
	    	<a class="bts_link" href="javascript:delTips('确定删除交货地地区?删除地区后，其下交货地将失效！', 'deliveryplace/delArea.action?id=${deliveryArea.id}')" >删除</a> 
	    </td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="5">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>

</body>
</html>