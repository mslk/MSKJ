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

		<title>添加质检报告</title>

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
			    new Entity({id:"number",name:"报告序号",required:true,defaultPassed:false})
			     ];
		    validateBase(list);
		});
		</script>
	</head>

	<body>
	  <form id="form1" action="otherAid/addQualityControl.action" method="post">
	  	
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="3" class="thead">
					<div class="tit_box">
						添加质检报告
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					报告序号:
				</td>
				<td width="30%">
					<input type="text" id="number" name="qualityControl.number" 
					value="${qualityControl.number }" />
				</td>
				<td width="40%"><div class="tipsbox"><div id="numberTip"></div></div></td>
			</tr>
			<tr>
				<td width="30%">
					全水分:
				</td>
				<td width="30%">
					<input type="text" name="qualityControl.quanshuifen" 
					value="${qualityControl.shuifen }" />
				</td>
				<td width="40%"></td>
			</tr> 
			<tr>
				<td width="30%">
					水分:
				</td>
				<td width="30%">
					<input type="text" name="qualityControl.shuifen" 
					value="${qualityControl.quanshuifen }" />
				</td>
				<td width="40%"></td>
			</tr>
			<tr>
				<td width="30%">
					灰分:
				</td>
				<td width="30%">
					<input type="text" id="huifen" name="qualityControl.huifen" 
						value="${qualityControl.huifen }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="huifenTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					挥发分:
				</td>
				<td width="30%">
					<input type="text" id="name" name="qualityControl.huifafen" value="${qualityControl.huifafen }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="nameTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					焦渣特征:
				</td>
				<td width="30%">
					<input type="text" id="shortname" name="qualityControl.jiaozha" value="${qualityControl.jiaozha }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="shortnameTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					固定碳:
				</td>
				<td width="30%">
					<input type="text" id="address" name="qualityControl.gudingtan" value="${qualityControl.gudingtan }" />
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="addressTip"></div></div>
				</td>
			</tr>

			<tr>
				<td width="30%">
					全硫:
				</td>
				<td width="30%">
					<input type="text" id="heating" name="qualityControl.quanniu" value="${qualityControl.quanniu }" /> 
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="heatingTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					氢:
				</td>
				<td width="30%">
					<input type="text" id="heating" name="qualityControl.qing" value="${qualityControl.qing }" /> 
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="heatingTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					发热量Ｑgr,d:
				</td>
				<td width="30%">
					<input type="text" id="sulphur" name="qualityControl.fareliang1" value="${qualityControl.fareliang1 }" />  
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="sulphurTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					发热量Ｑnet,ar:
				</td>
				<td width="30%">
					<input type="text" id="ash" name="qualityControl.fareliang2" value="${qualityControl.fareliang2 }" />  
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="ashTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					灰熔融性 DT:
				</td>
				<td width="30%">
					<input type="text" id="moisture" name="qualityControl.huiDt" value="${qualityControl.huiDt }" /> 
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="moistureTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					灰熔融性 ST:
				</td>
				<td width="30%">
					<input type="text" id="moisture" name="qualityControl.huiSt" value="${qualityControl.huiSt }" /> 
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="moistureTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					灰熔融性 HT:
				</td>
				<td width="30%">
					<input type="text" id="moisture" name="qualityControl.huiHt" value="${qualityControl.huiHt }" /> 
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="moistureTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					灰熔融性 FT:
				</td>
				<td width="30%">
					<input type="text" id="moisture" name="qualityControl.huiFt" value="${qualityControl.huiFt }" /> 
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="moistureTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					粘结指数:
				</td>
				<td width="30%">
					<input type="text" id="moisture" name="qualityControl.nianjie" value="${qualityControl.nianjie }" /> 
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="moistureTip"></div></div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					减灰（回收率）:
				</td>
				<td width="30%">
					<input type="text" id="moisture" name="qualityControl.jianhui" value="${qualityControl.jianhui }" /> 
				</td>
				<td width="40%">
					<div class="tipsbox"><div id="moistureTip"></div></div>
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
