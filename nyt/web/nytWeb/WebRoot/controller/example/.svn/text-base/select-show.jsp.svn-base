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
    <title>煤种粒度列表</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
</head>
<body>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
	<tr>
		<td>煤种类型：</td>
		<td>
			<input type="text" id="coalTypeName" name="coalTypeName"    readonly="readonly"/>
						<input type="text" id="coalTypeId" name="coalTypeId"   />
						<input type="button" value="选择煤种" onclick="chooseCoalType()"/>
		</td>
	</tr>
	<tr>
		<td>煤种粒度类型：</td>
		<td>
			<input type="text" id="coalParticleSizeName" name="coalParticleSizeName"   readonly="readonly" />
						<input type="text" id="coalParticleSizeId" name="coalParticleSizeId"   />
						<input type="button" value="选择煤种粒度" onclick="chooseCoalParticleSize()"/>
		</td>
	</tr>
	<tr>
		<td>收货地类型：</td>
		<td>
			<input type="text" id="deliveryplaceTypeName" name="deliveryplaceTypeName"   readonly="readonly" />
						<input type="text" id="deliveryplaceTypeId" name="deliveryplaceTypeId"   />
						<input type="button" value="选择收货地类型" onclick="chooseDeliveryplaceType()"/>
		</td>
	</tr>
</table>

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