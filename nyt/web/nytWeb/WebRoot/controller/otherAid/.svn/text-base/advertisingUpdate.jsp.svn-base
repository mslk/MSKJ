<%@page import="com.meibaolian.util.ConfigUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>广告修改</title>
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
		               new Entity({id:"targetUrl",name:"广告地址",required:false})
		               ];
			  
		 
		    validateBase(list);
			
		});
		</script>
		
	</head>

	<body>
		<form  id="form1" action="otherAid/advertisingManager_update.action"  enctype="multipart/form-data" method="post">
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box">
							广告修改
							<input type="hidden" value="${result.id }" name="advId"/>
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%">
						广告类型:
					</td>
					<td width="30%"  >
					   <c:if test="${ result.type==1}">ios 广告</c:if>
		               <c:if test="${ result.type==2}">android 广告</c:if>
					</td>
				</tr>			
				<tr>
					<td>
					修改广告地址:
					</td>
					<td align="center">
						<input size="30" type="text" id="targetUrl" name="targetUrl" value="${ result.targeturl}"  />
					</td>
				</tr>
				<tr>
				<td>
					修改图片地址:
					(只能上传图片类型 jpg ,png )
					<c:if test="${ result.type==1}">ios 广告大小(宽440x高98)</c:if>
		            <c:if test="${ result.type==2}">android 广告(宽800x高80)</c:if>
					</td>
					<td align="center">
						<input type="file" id="image" name="image"/>
					</td>
				</tr>
				<tr>
					<td>
					现有图片展示
					</td>
					<td align="center">
					    <img src="<%=ConfigUtil.IMAGEPREFIX %>${result.imageurl  }"/>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td align="center">
						<input type="submit" value="修改"  />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
