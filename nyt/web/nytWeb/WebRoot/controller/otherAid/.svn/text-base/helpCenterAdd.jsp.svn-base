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

		<title>新增帮助信息</title>
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
		               new Entity({id:"title",name:"标题",required:true}),
		               new Entity({id:"target",name:"详细信息",required:true})
		               ];
			  
		 
		    validateBase(list);
			
		});
		</script>
		
	</head>

	<body>
		<form  id="form1" action="otherAid/helpCenterManager_add.action"  enctype="multipart/form-data" method="post">
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box">
							新增帮助信息
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%">
						标题:
					</td>
					<td width="30%"  >
					   <input type="text"   id="title" name="helpCenter.title"/>
					</td>
				</tr>			
				<tr>
					<td width="20%">
						类型:
					</td>
					<td width="30%"  >
				      <select name="helpCenter.type" >
					     <option value="1" <c:if test="${type==1 }">selected="selected"</c:if>>服务</option>
					     <option value="2" <c:if test="${type==2 }">selected="selected"</c:if>>新闻</option>
					   </select>
					</td>
				</tr>			
				<tr>
					<td>
					详细信息: <font color="red">上传文件请参考  <a class="bts_link" href="controller/otherAid/template.html" target="_blank"> 查看 </a> </font> 
					只能上传 html与htm 格式文件
					</td>
					<td align="center">
					 <input size="30" type="file" id="target" name="target"  />
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td align="center">
						<input type="submit" value="增加"  />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
