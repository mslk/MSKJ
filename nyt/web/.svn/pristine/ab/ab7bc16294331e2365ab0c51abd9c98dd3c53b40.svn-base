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
<form  id="form1" action="deliveryplace/search.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>类型：</td>
		<td>
			<%--<select name="deliveryPlaceDto.type" id="type">
			  <option value="-1">全部 </option>
			  <option value="0" <c:if test="${deliveryPlaceDto.type==0}">selected="selected"</c:if> >煤矿</option>
			  <option value="1" <c:if test="${deliveryPlaceDto.type==1}">selected="selected"</c:if> >站台</option>
			  <option value="2" <c:if test="${deliveryPlaceDto.type==2}">selected="selected"</c:if> >煤场</option>
			</select> 
		--%>
				<input type="text" id="deliveryplaceTypeName" name="deliveryPlaceDto.typename"  
					value="${deliveryPlaceDto.typename }"  readonly="readonly" />
				<input type="hidden" id="deliveryplaceTypeId" name="deliveryPlaceDto.type"  
					value="${deliveryPlaceDto.type }" />
				<input type="button" value="选择交货地类型" onclick="chooseDeliveryplaceType()"/>
		</td>
		<td>关键字：</td>
		<td colspan="3">
			<input type="text" id="keyword" name="deliveryPlaceDto.keyword"  placeholder="煤矿名称/地址" value="${deliveryPlaceDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>
		<td style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 <div class="tit_box">交货地列表</div>
    </td>
  </tr>
	<tr>
		<td>省份</td>
		<td>城市</td>
		<td>区县</td>
		<td>名称</td>
		<td>简称</td>
		<td>类型</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="deliveryPlace" >
	<tr>
		<td>${deliveryPlace.provincename }</td>
		<td>${deliveryPlace.cityname }</td>
		<td>${deliveryPlace.countyname }</td>
	    <td>${deliveryPlace.name }</td>
	    <td>${deliveryPlace.shortname }</td>
	    <td>${deliveryPlace.typename }</td>
	    <td>
	    	<a class="bts_link" href="deliveryplace/show.action?id=${deliveryPlace.id}" target="_blank">详情</a> 
	    	<a class="bts_link" href="deliveryplace/initUpdate.action?id=${deliveryPlace.id}" target="_blank">修改</a> 
	    	<a class="bts_link" href="javascript:delTips('确定删除交货地?', 'deliveryplace/delPlace.action?id=${deliveryPlace.id}')" >删除</a> 
	    </td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="7">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
<div id="ly"
			style="position: absolute; top: 0px; filter:progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=60);filter: alpha(opacity = 60); z-index: 2; left: 0px; display: none;">
	</div>
			<!--浮层框架开始-->
	<div id="Layer2"
				style="position: absolute; z-index: 3; background-color: #fff; display: none; width: 640; height: 150;">
	
	</div>
		<!--浮层框架结束-->
</body>
</html>