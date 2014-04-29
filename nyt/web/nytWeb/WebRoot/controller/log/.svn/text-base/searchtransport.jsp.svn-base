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
<form  id="form1" action="log/searchTransport.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>有效期：</td>
		<td colspan="6">
		<input type="text" name="searchLogTransportDto.begindate" id="begindate" size="20" readonly value="${searchLogTransportDto.begindate}"  />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="searchLogTransportDto.enddate" id="enddate" size="20" readonly value="${searchLogTransportDto.enddate}"  />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
        <span class="tipsbox"><span id="dateTip" style="display:inline-block;vertical-align:2px;"></span></span>
		</td>
	</tr>
	<tr>
	  <td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="searchLogTransportDto.keyword"  placeholder="姓名/手机号码" value="${searchLogTransportDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
	   </td>
		<td>会员类型：</td>
		<td>
			<select name="searchLogTransportDto.type" >
				<option value="-1" >全部</option>
				<option value="2" <c:if test="${searchLogTransportDto.type==2}">selected="selected"</c:if>>交易商</option>
				<option value="3" <c:if test="${searchLogTransportDto.type==3}">selected="selected"</c:if>>物流商</option>
				<option value="100" <c:if test="${searchLogTransportDto.type==100}">selected="selected"</c:if>>游客</option>
			</select>
	   </td>
	   <td>查询类型：</td>
		<td>
			<select name="searchLogTransportDto.searchtype" >
				<option value="-1" >全部</option>
				<option value="0" <c:if test="${searchLogTransportDto.searchtype==0}">selected="selected"</c:if>>车讯</option>
				<option value="1" <c:if test="${searchLogTransportDto.searchtype==1}">selected="selected"</c:if>>货讯</option>
			</select>
	   </td>
		<td style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="8" class="thead">
 <div class="tit_box">物流查询日志列表</div>
    </td>
  </tr>
	<tr>
		<td width="">姓名</td>
		<td width="">手机</td>
		<td width="">会员类型</td>
		<td width="">查询类型</td>
		<td width="">时间</td>
		<td width="">查询关键字</td>
		<td width="">收货地省份</td>
		<td width="">操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="searchLogTransport" >
	<tr>
		<td>${searchLogTransport.username }</td>
	    <td>${searchLogTransport.phone }</td>
	   <td>
		    <c:choose>
		    	<c:when test="${searchLogTransport.usertype==2}">交易商</c:when>
		    	<c:when test="${searchLogTransport.usertype==3}">物流商</c:when>
		    	<c:when test="${searchLogTransport.usertype==100}">游客</c:when>
		    	<c:otherwise>未知</c:otherwise>
		    </c:choose>
	    </td>
	    <td>
		    <c:choose>
		    	<c:when test="${searchLogTransport.searchtype==0}">车讯</c:when>
		    	<c:when test="${searchLogTransport.searchtype==1}">货讯</c:when>
		    	<c:otherwise>未知</c:otherwise>
		    </c:choose>
	    </td>
	    <td><fmt:formatDate  value="${searchLogTransport.addtime}" pattern="yyyy-MM-dd" /></td>
	    <td>${searchLogTransport.keyword }</td>
	    <td>${searchLogTransport.stopprvname }</td>
	    <td>--</td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="8">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>