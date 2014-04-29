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
    <title>The Coolest DHTML Calendar - Online Demo</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" charset="UTF-8"
			src="js/My97DatePicker/WdatePicker.js"></script>	
	<script>
	$(document).ready(function(){
	
	
	
	$("#begindateBt").click(function()
		{  
		   WdatePicker({el:'begindate',dateFmt:'yyyy-MM-dd HH:mm:ss'});
		});  


		$("#enddateBt").click(function()
		{  
		   WdatePicker({el:'enddate',dateFmt:'yyyy-MM-dd HH:mm:ss'});
		});
		
		    
	});
	</script>
</head>
<body>
<form  id="mainForm" action="demo/search_allUser.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="3" class="thead">
 <div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>时间：</td>
		<td>
		<input type="text" name="begindate" id="begindate" size="20" readonly />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="enddate" id="enddate" size="20" readonly />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
		</td>
		<td style="text-align:center">
		<input type="submit" name="tijiao" id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="3" class="thead">
 <div class="tit_box">用户信息列表</div>
    </td>
  </tr>
	<tr>
		<td>用户名</td>
		<td>密码</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="user" >
	<tr>
		<td>
		${user.username }
		</td>
	    <td>${user.password }</td>
	    <td>修改 删除</td>
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