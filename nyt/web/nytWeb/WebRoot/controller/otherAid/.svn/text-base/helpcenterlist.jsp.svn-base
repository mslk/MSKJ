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
    <title>帮助信息管理</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" charset="UTF-8"
			src="js/base.js"></script>	
</head>
<body>
<form action="otherAid/helpCenterShow.action"  method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="2" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td width="20%" >帮助信息类型：</td>
		<td>
		   <select name="type" >
		     <option value="-1" >全部</option>
		     <option value="1" <c:if test="${type==1 }">selected="selected"</c:if>>服务</option>
		     <option value="2" <c:if test="${type==2 }">selected="selected"</c:if>>新闻</option>
		   </select>
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
    <td colspan="1" class="thead">
    <div class="tit_box">帮助信息列表</div>
    </td>
    <td colspan="4" class="thead">
           <input type="button" value="新增帮助信息"  onclick="toPageUrl('controller/otherAid/helpCenterAdd.jsp')"/>
    </td>
  </tr>
	<tr>
	    <td width="35%">标题</td>
	    <td width="20%">类型</td>
		<td width="10%">详情信息</td>
		<td width="15%">添加时间</td>
		<td width="15%">管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="helpcenter" >
	<tr>
		<td>
	    ${helpcenter.title }
		</td>
		<td>
	    <c:if test="${helpcenter.type==1 }">服务</c:if>
	    <c:if test="${helpcenter.type==2 }">新闻</c:if>
		</td>
		<td>
		<A class="bts_link" href="<%=ConfigUtil.IMAGEPREFIX %>${helpcenter.targeturl }" target="_blank">查看</A>
		</td>
		<td> ${helpcenter.addtime }</td>
	    <td><a class="bts_link" href="otherAid/helpCenterManager_toUpdate.action?helpCenter.id=${helpcenter.id }">修改</a>
	    <a class="bts_link" href="javascript:delTips('确定删除帮助信息?','otherAid/helpCenterManager_delete.action?helpCenter.id=${helpcenter.id }')">删除</a></td>
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