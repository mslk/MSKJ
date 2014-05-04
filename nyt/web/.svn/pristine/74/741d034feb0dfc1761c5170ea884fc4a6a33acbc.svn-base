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

		<title>修改客户端用户信息</title>
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
				new Entity({id:"password",name:"密码",required:true,type:17,minLen:4,maxLen:16}),
				new Entity({id:"realname",name:"姓名",required:true,type:1,minLen:2,maxLen:20}),
				new Entity({id:"companyname",name:"公司名称",required:true,type:1,minLen:2,maxLen:50}),
				new Entity({id:"address",name:"联系地址",required:false,type:1,minLen:2,maxLen:50})
				<c:if test="${userInfo.type==7 }">
				,
				new Entity({id:"cardid",name:"身份证",required:true,type:7}),
				new Entity({id:"carnumber",name:"车牌号",required:true,type:1,minLen:6,maxLen:50}),
				new Entity({id:"frame",name:"车架号",required:true,type:1,minLen:6,maxLen:50}),
				new Entity({id:"engine",name:"发动机号",required:true,type:1,minLen:6,maxLen:50})
				</c:if>
				
			     ];
		    validateBase(list);
		});
		</script>
	</head>

	<body>
	<form  id="form1" action="userInfo/user_update.action" method="post">
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="2" class="thead">
					<div class="tit_box">
						客户端用户信息
					</div>
				</td>
			</tr>
			<tr>
				<td width="30%">
					手机:
				</td>
				<td width="70%">
				 ${userInfo.phone }
				 <input type="hidden" name="userInfo.id" value="${userInfo.id }">
				</td>
			</tr>
			<tr>
				<td width="30%">
					类型:
				</td>
				<td width="70%">
					<c:choose>
						<c:when test="${userInfo.type==100 }">游客</c:when>
						<c:when test="${userInfo.type!=100 }">会员</c:when>
					</c:choose>
				</td>
			<tr>
				<td width="30%">
					密码:
				</td>
				<td width="70%">
				  <input type="text"	 value="${userInfo.password }"  id="password" name="userInfo.password"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					姓名:
				</td>
				<td width="70%">
				 <input type="text"	 value="${userInfo.realname }"  id="realname" name="userInfo.realname"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					公司名称:
				</td>
				<td width="70%">
				 <input type="text" value="${userInfo.companyname }" id="companyname" name="userInfo.companyname"/>
				</td>
			</tr>
			<tr>
				<td width="30%">
					联系地址:
				</td>
				<td width="70%">
				<input type="text"	value="${userInfo.address }"  id="address" name="userInfo.address"/>
				</td>
			</tr>
			<c:if test="${userInfo.type==7 }">
			<tr>
			<td width="30%">
					身份证:
				</td>
				<td width="70%">
				  <input type="text"	value="${userInfo.cardid}" id="cardid" name="userInfo.cardid"/>
				</td>
			</tr>
			<tr>
			<td width="30%">
					车牌号:
				</td>
				<td width="70%">
				  <input type="text"	value="${ userInfo.carnumber}" id="carnumber" name="userInfo.carnumber"/>
				</td>
			</tr>
			<tr>
			<td width="30%">
					车架号:
				</td>
				<td width="70%">
				  <input type="text"	value="${userInfo.frame}" id="frame" name="userInfo.frame"/>
				</td>
			</tr>
			<tr>
			<td width="30%">
					发动机号:
				</td>
				<td width="70%">
				  <input type="text"	value="${userInfo.engine}" id="engine" name="userInfo.engine"/>
				</td>
			</tr>
			</c:if>
		<tr>
			<td>客户权限：</td>
			<td>
				<select name="userInfo.level" id="level">
				    <option value="0" <c:if test="${userInfo.level==0}">selected="selected"</c:if> >默认</option>
				    <option value="2" <c:if test="${userInfo.level==2}">selected="selected"</c:if> >指定日期</option>
				    <option value="1" <c:if test="${userInfo.level==1}">selected="selected"</c:if> >无限期</option>
				</select> 
			</td>
		</tr>
		<tr>
			<td>状态：</td>
			<td>
				<select name="userInfo.status" id="status">
				  <option value="0" <c:if test="${userInfo.status==0}">selected="selected"</c:if> >有效</option>
				  <option value="2" <c:if test="${userInfo.status!=0}">selected="selected"</c:if> >禁用</option>
				</select> 
			</td>
			<td />
		</tr>
		<%//超级管理员可以指定店小二 %>
	<c:if test="${admin.type==1 }">
		<tr>
			<td width="30%">
					管理员:
			</td>
			<td width="70%">
				<select name="userInfo.usermanager.id" id="usermanagerid">
					<c:forEach items="${usermanagers}" var="usermanager" >
						  <option value="${usermanager.id }" <c:if test="${usermanager.id==userInfo.usermanager.id}">selected="selected"</c:if> >${usermanager.realname }</option>
					</c:forEach>
				</select> 
			</td>
		</tr>
	</c:if>
	<c:if test="${admin.type!=1 }">
		<tr>
			<td width="30%">
					管理员:
			</td>
			<td width="70%">
				<input type="hidden" name="userInfo.usermanager.id" value="${userInfo.usermanager.id}">
			 	${userInfo.usermanager.realname }
			</td>
		</tr>
	</c:if>
		<tr>
			<td width="30%">
					注册时间:
				</td>
				<td width="70%">
					${userInfo.registertime}
				</td>
			</tr>
			
			<%--<tr>
				<td width="30%">
					登陆名:
				</td>
				<td width="70%">
					${userInfo.loginname }
				</td>
			</tr>
			--%><tr>
				
			<!-- 
			<tr>
				<td width="30%">
					推送通知开关:
				</td>
				<td width="70%">
					<c:choose>
						<c:when test="${userInfo.pushstatus==0 }">已开启</c:when>
						<c:when test="${userInfo.pushstatus==1 }">已关闭</c:when>
					</c:choose>
				</td>
			</tr>
			 -->
			 <tr>
				<td colspan="2"  style="text-align: center;">
					
					<input type="submit" value="修改" <c:if test="${userInfo.type==100 }">disabled="disabled"</c:if>  />
					
				</td>
			</tr>
		</table>
	</form>	
	</body>
</html>
