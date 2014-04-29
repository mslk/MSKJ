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
			src="js/My97DatePicker/WdatePicker.js"></script>	
	<script type="text/javascript" src="js/base.js"></script>
	<script>
	$(document).ready(function(){
		//
		$("#begindateBt").click(function()
			{  
			   WdatePicker({el:'begindate',dateFmt:'yyyy-MM-dd', maxDate: '#F{$dp.$D(\'enddate\')}'});
			});  
	
		$("#enddateBt").click(function()
			{  
			   WdatePicker({el:'enddate',dateFmt:'yyyy-MM-dd', minDate: '#F{$dp.$D(\'begindate\')}' });
			});
	});
	</script>
</head>
<body>
<form  id="form1" action="log/searchModule.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>有效期：</td>
		<td colspan="4">
		<input type="text" name="accessLogModuleDto.begindate" id="begindate" size="20" readonly value="${accessLogModuleDto.begindate}"  />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="accessLogModuleDto.enddate" id="enddate" size="20" readonly value="${accessLogModuleDto.enddate}"  />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
        <span class="tipsbox"><span id="dateTip" style="display:inline-block;vertical-align:2px;"></span></span>
		</td>
	</tr>
	<tr>
		<td>模块：</td>
		<td>
			<select name="accessLogModuleDto.module" >
				<option value="" >全部</option>
				<option value="USER" <c:if test="${accessLogModuleDto.module=='USER'}">selected="selected"</c:if>>用户</option>
				<option value="QUALITY" <c:if test="${accessLogModuleDto.module=='QUALITY'}">selected="selected"</c:if>>质检</option>
				<option value="PURCHASE" <c:if test="${accessLogModuleDto.module=='PURCHASE'}">selected="selected"</c:if>>买煤</option>
				<option value="PROVIDER" <c:if test="${accessLogModuleDto.module=='PROVIDER'}">selected="selected"</c:if>>卖煤</option>
				<option value="TRANSPORTSUPPLY" <c:if test="${accessLogModuleDto.module=='TRANSPORTSUPPLY'}">selected="selected"</c:if>>找车</option>
				<option value="TRANSPORTDEMAND" <c:if test="${accessLogModuleDto.module=='TRANSPORTDEMAND'}">selected="selected"</c:if>>找货</option>
				<option value="MYLOGISTICS" <c:if test="${accessLogModuleDto.module=='MYLOGISTICS'}">selected="selected"</c:if>>我的物流商</option>
				<option value="MYSUPPLIER" <c:if test="${accessLogModuleDto.module=='MYSUPPLIER'}">selected="selected"</c:if>>我的供应商</option>
				<option value="MYBUYERS" <c:if test="${accessLogModuleDto.module=='MYBUYERS'}">selected="selected"</c:if>>我的采购商</option>
			</select>
	   </td>
		<td>功能：</td>
		<td colspan="2">
			<select name="accessLogModuleDto.funcation" >
				<option value="" >全部</option>
				<option value="ADD" <c:if test="${accessLogModuleDto.funcation=='ADD'}">selected="selected"</c:if>>添加</option>
				<option value="UPDATE" <c:if test="${accessLogModuleDto.funcation=='UPDATE'}">selected="selected"</c:if>>修改</option>
				<option value="DELETE" <c:if test="${accessLogModuleDto.funcation=='DELETE'}">selected="selected"</c:if>>删除</option>
				<option value="SEARCH" <c:if test="${accessLogModuleDto.funcation=='SEARCH'}">selected="selected"</c:if>>查询</option>
				<option value="COMPLETE" <c:if test="${accessLogModuleDto.funcation=='COMPLETE'}">selected="selected"</c:if>>完善信息</option>
				<option value="UPDATEPWD" <c:if test="${accessLogModuleDto.funcation=='UPDATEPWD'}">selected="selected"</c:if>>修改密码</option>
				<option value="ROPOSAL" <c:if test="${accessLogModuleDto.funcation=='ROPOSAL'}">selected="selected"</c:if>>投诉</option>
			</select>
		</td>
	</tr>
	<tr>
	  <td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="accessLogModuleDto.keyword"  placeholder="姓名/手机号码" value="${accessLogModuleDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
	   </td>
	   <td>会员类型：</td>
		<td>
			<select name="accessLogModuleDto.type" >
				<option value="-1" >全部</option>
				<option value="2" <c:if test="${accessLogModuleDto.type==2}">selected="selected"</c:if>>交易商</option>
				<option value="3" <c:if test="${accessLogModuleDto.type==3}">selected="selected"</c:if>>物流商</option>
				<option value="100" <c:if test="${accessLogModuleDto.type==100}">selected="selected"</c:if>>游客</option>
			</select>
	   </td>
		<td  colspan="3" style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="6" class="thead">
 <div class="tit_box">模块访问日志列表</div>
    </td>
  </tr>
	<tr>
		<td width="">姓名</td>
		<td width="">手机</td>
		<td width="">会员类型</td>
		<td width="">时间</td>
		<td width="">模块功能描述</td>
		<%--<td width="">模块</td>
		<td width="">功能</td>
		--%><td width="">操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="accessLogModule" >
	<tr>
		<td>${accessLogModule.username }</td>
	    <td>${accessLogModule.phone }</td>
	    <td>
		    <c:choose>
		    	<c:when test="${accessLogModule.usertype==2}">交易商</c:when>
		    	<c:when test="${accessLogModule.usertype==3}">物流商</c:when>
		    	<c:when test="${accessLogModule.usertype==100}">游客</c:when>
		    	<c:otherwise>未知</c:otherwise>
		    </c:choose>
	    </td>
	    <td><fmt:formatDate  value="${accessLogModule.addtime}" pattern="yyyy-MM-dd" /></td>
	    <td>${accessLogModule.title }</td>
	    <%--<td>${accessLogModule.module }</td>
	    <td>${accessLogModule.funcation }</td>
	    --%><td>--</td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="6">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>