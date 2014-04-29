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
			src="jquery-validate/formValidator-4.1.3.js"></script>
		<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidatorRegex.js"></script>
		<script language="javascript" src="jquery-validate/DateTimeMask.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/validate.js"></script>
			<script type="text/javascript" charset="UTF-8"
			src="js/base.js"></script>	
		
</head>
<body>
<form  id="form1" action="receiptplace/search.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="3" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="receiptPlaceDto.keyword"  value="${receiptPlaceDto.keyword}"  />
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
 <div class="tit_box">地区列表</div>
    </td>
  </tr>
	<tr>
		<td>省份</td>
		<td>城市</td>
		<td>区县</td>
		<td>简称</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="receiptPlace" >
	<tr>
		<td>${receiptPlace.provincename }</td>
		<td>${receiptPlace.cityname }</td>
	    <td>${receiptPlace.name }</td>
	    <td>${receiptPlace.shortname }</td>
	    <td>
	    	<a class="bts_link" href="receiptplace/show.action?id=${receiptPlace.id}" target="_blank">详情</a> 
	    	<a class="bts_link" href="receiptplace/initUpdate.action?id=${receiptPlace.id}" target="_blank">修改</a> 
	    	<a class="bts_link" href="javascript:delTips('确定加入交货地?', 'receiptplace/addDelivery.action?id=${receiptPlace.id}')" >加入交货地</a> 
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