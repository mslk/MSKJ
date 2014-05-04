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

		<title>修改管理员密码</title>

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
			
		<script type="text/javascript" charset="UTF-8"
			src="js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){

		    $.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});

			var list=[  
				new Entity({id:"oldpwd",name:"原始密码",required:true,type:17,minLen:6,maxLen:6}),
				new Entity({id:"pwd1",name:"新密码",required:true,type:17,minLen:6,maxLen:6}),
				new Entity({id:"pwd2",name:"确定新密码",required:true,type:17,compareId:'pwd1',minLen:6,maxLen:6})
			     ];
			
		    validateBase(list);
		});
		</script>
	</head>

	<body>
	  <form id="form1" action="user/system_updatePwd.action" method="post">
	  	
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="3" class="thead">
					<div class="tit_box">
						修改管理员密码
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					原始密码：
				</td>
				<td colspan="2" width="70%">
				 <input type="password" id="oldpwd" name="password">
				</td>
			</tr>
			<tr>
				<td width="30%">
					 新密码：
				</td>
				<td colspan="2" width="70%">
				 <input type="password" id="pwd1" name="pwd1">
				</td>
			</tr>
			<tr>
				<td width="30%">
				确认新密码：
				</td>
				<td colspan="2" width="70%">
				 <input type="password" id="pwd2" name="pwd2">
				</td>
			</tr>
			
			<tr>
				<td colspan="3" style="text-align: center">
					  <input type="submit"  value="修改" />
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>
