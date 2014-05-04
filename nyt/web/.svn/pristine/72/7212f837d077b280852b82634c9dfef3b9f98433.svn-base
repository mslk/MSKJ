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
    <title>拨打电话统计</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" charset="UTF-8"
			src="js/My97DatePicker/WdatePicker.js"></script>	
	<script type="text/javascript" charset="UTF-8"
			src="js/base.js"></script>	
	
</head>
<body>
<form  id="mainForm" action="otherAid/phoneStats.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="3" class="thead">
 <div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>号码：</td>
		<td>
		<input type="text" name="phone"  value="${phone}" />
		<input type="submit"  value="搜索"  />
		</td>
		<td style="text-align:center">
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="2" class="thead">
 <div class="tit_box">拨打电话统计列表</div>
    </td>
  </tr>
	<tr>
		<td>手机号码</td>
		<td>拨打次数</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="callPhoneLog" >
	<tr>
		<td>
		${callPhoneLog.phone }
		</td>
	    <td>${callPhoneLog.number }</td>
	</tr>
</c:forEach>

	<tr>
  		<td colspan="2">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>