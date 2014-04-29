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
	<script type="text/javascript" charset="UTF-8" src="js/base.js"></script>	
</head>
<body>
<form  id="form1" action="deliveryplace/searchType.action" method="post">

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="3" class="thead">
 <div class="tit_box">交货地类型列表</div>
    </td>
  </tr>
	<tr>
		<td>交货地类型值</td>
		<td>交货地类型名称</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="deliveryplaceType" >
	<tr>
		<td>${deliveryplaceType.type }</td>
	    <td>${deliveryplaceType.typeName }</td>
	    <td>
	    	<a class="bts_link" href="javascript:delTips('确定删除交货地类型?', 'deliveryplace/delType.action?id=${deliveryplaceType.id}')" >删除</a> 
	    </td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="3">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>