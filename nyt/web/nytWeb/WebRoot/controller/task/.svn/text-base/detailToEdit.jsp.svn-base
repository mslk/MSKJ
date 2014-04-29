<%@ page language="java" pageEncoding="UTF-8"%>
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

		<title>修改推送任务</title>
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
			
			new Entity({id:"title",name:"标题",required:true,minLen:5,maxLen:50,defaultPassed:true}),
			new Entity({id:"beginTime",name:"开始日期",required:true,type:18}),
			new Entity({id:"endTime",name:"结束日期",required:true,type:19,compareId:"beginTime"}),
		    new Entity({id:"description",name:"通知描述",required:true,type:1,minLen:10,maxLen:500,defaultPassed:true})
			     ];
			  
			  

		
		$("#beginTimeBt").click(function()
		{  
		   WdatePicker({el:'beginTime',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d}'});
		});    
		$("#endTimeBt").click(function()
		{  
		   WdatePicker({el:'endTime',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d}'});
		});    
		 
		    validateBase(list);
			
		});
		</script>
		
	</head>

	<body>
		<form  id="form1" action="pushTask/task_update.action"  method="post">
		<input type="hidden" name="id" value="${result.id}" >
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box">
							修改推送任务
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%">
						标题:
					</td>
					<td width="30%"  >
						<input type="text" id="title" name="title"  value="${result.title}"  />
					</td>
				</tr>
				<tr>
					<td>
						推送开始时间:
					</td>
					<td>
					    <fmt:formatDate var="bT" value="${result.begintime}" type="both"/>
						<input type="text" id="beginTime" name="beginTime"  value="${bT}" readonly="true"
							 />
						<input type="button" value="选择日期"  id="beginTimeBt" />
						 <div id="beginTimeTip"  style="display:inline-block;vertical-align:2px;"></div>
					</td>
				</tr>
				<tr>
					<td>
						推送结束时间:
					</td>
					<td>
					     <fmt:formatDate var="eT" value="${result.endtime}" type="both"/>
						<input type="text" id="endTime" name="endTime" value="${eT}" readonly="true"
							 />
						<input type="button" value="选择日期"  id="endTimeBt"/>
						<div id="endTimeTip"  style="display:inline-block;vertical-align:2px;"></div>
					</td>
				</tr>
				<tr style="display:none">
					<td >
						发送对象:
					</td>
					<td >
					<input type="file" id="sendUrl" name="sendUrl" size="60" />
					</td>
				</tr>
				<tr style="display:none">
					<td >
						追加类型:
					</td>
					<td >
					<input  type="radio" name="addType"  checked="true" value="1"/>追加手机号码
	                <input  type="radio" name="addType"    value="2"/>追加uuid
					</td>
				</tr>
				<tr style="display:none">
					<td >
						追加号码:
					</td>
					<td >
						<textarea rows="5" cols="60" id="superaddition" name="superaddition"></textarea>
					</td>
				</tr>
				<tr style="display:none">
					<td>
						图片链接:
					</td>
					<td>
						<input type="file" id="url" name="url" size="60" />
					</td>
				</tr>
				<tr>
					<td>
						通知描述:
					</td>
					<td>
						<textarea rows="5" cols="60" id="description" name="description">${result.sysdescription}</textarea>
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
