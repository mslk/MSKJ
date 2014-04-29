<%@ page language="java" pageEncoding="UTF-8"%>
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

		<title>添加煤种粒度类型</title>
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
			
		<script type="text/javascript" src="js/base.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
		
		   
		    $.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});

			var list=[  
		               new Entity({id:"coalTypeName",name:"煤种",required:true,minLen:2,maxLen:15}),
		               new Entity({id:"particleSizeName",name:"煤种粒度",required:true,minLen:2,maxLen:15})
		               ];
			  
		 
		    validateBase(list);
			
		});
		</script>
		
	</head>

	<body>
	
	
		<form  id="form1" action="coal/coalParticleSizeManager_add.action"  method="post">
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box">
							新增煤种粒度
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%">
						所属煤种名称:
					</td>
					<td width="30%"  >
						<input type="text" id="coalTypeName" name="coalTypeName"    disabled="disabled" />
						<input type="hidden" id="coalTypeId" name="coalTypeId"   />
						<input type="button" value="选择煤种" onclick="chooseCoalType()"/>
						<div id="coalTypeNameTip"  style="display:inline-block;vertical-align:2px;"></div>
					</td>
				</tr>			
				<tr>
					<td width="20%">
						粒度名称:
					</td>
					<td width="30%"  >
						<input type="text" id="particleSizeName" name="particleSizeName"  />
					</td>
				</tr>			
				<tr>
					<td>
					</td>
					<td align="center">
						<input type="submit" value="新增"  />
					</td>
				</tr>
			</table>
		</form>
	
<div id="ly" style="position: absolute; top: 0px; filter: alpha(opacity=60); 
z-index: 2; left: 0px; display: none;">
</div>
<!--浮层框架开始-->
<div id="Layer2"  style="position: absolute; z-index: 3;
background-color: #fff; display: none; width:640; height:150;" >
</div>
<!--浮层框架结束-->	
		

	</body>
</html>
