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

		<title>添加交货地类型信息</title>

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
		<script type="text/javascript" src="js/validate.js"></script>
		<script type="text/javascript" src="js/base.js"></script>	

		<script type="text/javascript">
		$(document).ready(function(){

		    $.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});

			var list=[  
				new Entity({type:21,id:"type",name:"交货地类型值",required:true,defaultPassed:false}),
				new Entity({id:"typeName",name:"交货地类型名称",required:true,minLen:2,maxLen:50,defaultPassed:false})
			     ];
		    validateBase(list);
		});
		</script>
	</head>

	<body>
	  <form id="form1" action="deliveryplace/addType.action" method="post">
	  	
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="3" class="thead">
					<div class="tit_box">
						添加交货地类型信息
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					交货地类型值:
				</td>
				<td width="30%">
					<input type="text" id="type" name="deliveryplaceType.type" 
					value="${deliveryplaceType.type }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="typeTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					交货地类型名称:
				</td>
				<td width="30%">
					<input type="text" id="typeName" name="deliveryplaceType.typeName" 
					value="${deliveryplaceType.typeName }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="typeNameTip"></div></div>
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
