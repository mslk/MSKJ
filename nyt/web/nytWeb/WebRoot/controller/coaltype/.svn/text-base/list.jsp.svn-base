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
    <title>煤种列表</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
</head>
<body>
<form action="coal/coaltypeSearch.action" >
<input type="hidden" name="status" value="${status }"/>
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="3" class="thead">
 <div class="tit_box">煤种列表</div>
    </td>
  </tr>
	<tr>
  		<td>煤种id</td>
  		<td>煤种名称</td>
  		<td>操作</td>
  	</tr>
<c:forEach items="${request.result.queryList}" var="coaltype" >
	<tr>
		<td>
		${coaltype.id }
		</td>
		<td>
		${coaltype.coalName }
		</td>
		<td>
		<a class="bts_link" href="javascript:delTips('确定删除煤种?', 'coal/coaltypeManager_delete.action?coalTypeId=${coaltype.id }')"> 删除 </a>
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