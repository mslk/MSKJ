<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改地区信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
		<script src="js/jquery1.6.js" type="text/javascript"></script>
		<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidator-4.1.3.js"></script>
		<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidatorRegex.js"></script>
		<script language="javascript" src="jquery-validate/DateTimeMask.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/validate.js"></script>
			
		<script type="text/javascript">
		$(document).ready(function(){

		    $.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});

			var list=[  
				new Entity({id:"name",name:"区县",required:true,minLen:2,maxLen:50,defaultPassed:true}),
				new Entity({id:"provincename",name:"省份",required:true,minLen:2,maxLen:50,defaultPassed:true}),
				new Entity({id:"cityname",name:"城市",required:true,minLen:2,maxLen:50,defaultPassed:true})
			     ];
		    validateBase(list);
		});
		</script>
	</head>

	<body>
	  <form id="form1" action="receiptplace/update.action" method="post">
	  
	  	<input type="hidden" name="county.id" value="${county.id}" />
	  	<input type="hidden" name="county.cityid" value="${county.cityid}" />
	  	<input type="hidden" name="county.provinceid" value="${county.provinceid}" />
	  	
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="3" class="thead">
					<div class="tit_box">
						修改地区信息
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					省份:
				</td>
				<td width="30%">
					<input type="text" id="provincename" name="county.provincename" value="${county.provincename }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="provincenameTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					城市:
				</td>
				<td width="30%">
					<input type="text" id="cityname" name="county.cityname" value="${county.cityname }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="citynameTip"></div></div>
				</td>
			</tr> 
			<tr>
				<td width="30%">
					区县:
				</td>
				<td width="30%">
					<input type="text" id="name" name="county.name" value="${county.name }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="nameTip"></div></div>
				</td>
			</tr>
			
			<tr>
				<td width="30%">
					简称:
				</td>
				<td width="30%">
					<input type="text" id="shortname" name="county.shortname" value="${county.shortname }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="shortnameTip"></div></div>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center">
					  <input type="submit"  value="提交" />
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>
