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

<form action="coal/coalParticleSizeSearch.action"  method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="2" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>煤种类型：</td>
		<td>
			<input type="text" id="coalTypeName" name="coalTypeName"  value="${coalTypeName }"  readonly="readonly" />
						<input type="hidden" id="coalTypeId" name="coalTypeId"  value="${coalTypeId }" />
						<input type="button" value="选择煤种" onclick="chooseCoalType()"/>
		</td>
	</tr>
	<tr >
		<td colspan="2" style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>


<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="4" class="thead">
 <div class="tit_box">煤种粒度列表</div>
    </td>
  </tr>
	<tr>
  		<td>煤种粒度id</td>
  		<td>粒度名称</td>
  		<td>操作</td>
  	</tr>
<c:forEach items="${request.result.queryList}" var="coalParticleSize" >
	<tr>
		<td>
		${coalParticleSize.id }
		</td>
		<td>
		${coalParticleSize.name }
		</td>
		<td>
		<a class="bts_link" href="javascript:delTips('确定删除煤种粒度?', 'coal/coalParticleSizeManager_delete.action?particleSizeId=${coalParticleSize.id }')"> 删除 </a>
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