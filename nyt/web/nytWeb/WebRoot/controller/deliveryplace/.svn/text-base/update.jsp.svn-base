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

		<title>修改交货地信息</title>

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
				new Entity({id:"name",name:"名称",required:true,minLen:2,maxLen:50,defaultPassed:true}),
				//new Entity({id:"address",name:"地址",required:false}),
				new Entity({id:"heating",name:"发热量",required:true,type:10,defaultPassed:true}),
				new Entity({id:"sulphur",name:"硫分",required:true,type:12,defaultPassed:true}),
			    new Entity({id:"ash",name:"灰分",required:true,type:12,defaultPassed:true}),
			    new Entity({id:"moisture",name:"全水",required:true,type:12,defaultPassed:true})
			     ];
		    validateBase(list);
		});
		</script>
	</head>

	<body>
	  <form id="form1" action="deliveryplace/update.action" method="post">
	  
	  	<input type="hidden" name="deliveryPlace.id" value="${deliveryPlace.id}" />
	  	
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="3" class="thead">
					<div class="tit_box">
						修改交货地信息
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					省份:
				</td>
				<td colspan="2" width="70%">
					${deliveryPlace.provincename }
				</td>
			</tr>
			<tr>
				<td width="30%">
					城市:
				</td>
				<td colspan="2" width="70%">
					${deliveryPlace.cityname }
				</td>
			</tr> 
			<tr>
				<td width="30%">
					区县:
				</td>
				<td colspan="2" width="70%">
					${deliveryPlace.countyname }
				</td>
			</tr>
			<tr>
				<td width="30%">
					类型:
				</td>
				<td colspan="2" width="70%">${deliveryPlace.typename}</td>
			</tr>
			<tr>
				<td width="30%">
					名称:
				</td>
				<td width="30%">
					<input type="text" id="name" name="deliveryPlace.name" value="${deliveryPlace.name }" />
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
					<input type="text" id="shortname" name="deliveryPlace.shortname" value="${deliveryPlace.shortname }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="shortnameTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					地址:
				</td>
				<td width="30%">
					<input type="text" id="address" name="deliveryPlace.address" value="${deliveryPlace.address }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="addressTip"></div></div>
				</td>
			</tr>
			
			<c:if test="${deliveryPlace.type==0 }">
				<tr>
					<td width="30%">
						发热量:
					</td>
					<td width="30%">
						<input type="text" id="heating" name="deliveryPlace.heating" value="${deliveryPlace.heating }" /> 大卡
					</td>
					<td width="40%">
						<div class="tipsbox"><div id="heatingTip"></div></div>
					</td>
				</tr>
				<tr>
					<td width="30%">
						硫分:
					</td>
					<td width="30%">
						<input type="text" id="sulphur" name="deliveryPlace.sulphur" value="${deliveryPlace.sulphur }" /> %
					</td>
					<td width="40%">
						<div class="tipsbox"><div id="sulphurTip"></div></div>
					</td>
				</tr>
				<tr>
					<td width="30%">
						灰分:
					</td>
					<td width="30%">
						<input type="text" id="ash" name="deliveryPlace.ash" value="${deliveryPlace.ash }" /> %
					</td>
					<td width="40%">
						<div class="tipsbox"><div id="ashTip"></div></div>
					</td>
				</tr>
				<tr>
					<td width="30%">
						全水:
					</td>
					<td width="30%">
						<input type="text" id="moisture" name="deliveryPlace.moisture" value="${deliveryPlace.moisture }" /> %
					</td>
					<td width="40%">
						<div class="tipsbox"><div id="moistureTip"></div></div>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="3" style="text-align: center">
					  <input type="submit"  value="提交" />
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>
