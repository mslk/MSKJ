<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>uesr search</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidator-4.1.3.js"></script>
		<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidatorRegex.js"></script>
		<script language="javascript" src="jquery-validate/DateTimeMask.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/validate.js"></script>
	<script type="text/javascript" charset="UTF-8"
			src="js/My97DatePicker/WdatePicker.js"></script>	
	<script type="text/javascript" charset="UTF-8"
			src="js/base.js"></script>	
	<script>
	$(document).ready(function(){
	
	//$.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});
	
	/**var list=[  
			new Entity({id:"begindate",name:"开始日期",required:true,type:18}),
			new Entity({id:"enddate",name:"结束日期",required:true,type:19,compareId:"begindate"})
			];**/
	//
	$("#begindateBt").click(function()
		{  
		   WdatePicker({el:'begindate',dateFmt:'yyyy-MM-dd 00:00:00', maxDate: '#F{$dp.$D(\'enddate\')}'});
		});  

	$("#enddateBt").click(function()
		{  
		   WdatePicker({el:'enddate',dateFmt:'yyyy-MM-dd 23:59:59', minDate: '#F{$dp.$D(\'begindate\')}' });
		});
 	//validateBase(list);
	});
	</script>
</head>
<body>
<form  id="form1" action="userInfo/search.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>类型：</td>
		<td>
			<select name="userInfoDto.type" id="type">
			  <option value="-1">全部</option>
			    <option value="100" <c:if test="${userInfoDto.type==100}">selected="selected"</c:if> >游客</option>
			    <option value="1" <c:if test="${userInfoDto.type==1}">selected="selected"</c:if> >会员</option>
			</select> 
		</td>
		<td>客户权限：</td>
		<td>
			<select name="userInfoDto.level" id="level">
			  <option value="-1">全部</option>
			    <option value="0" <c:if test="${userInfoDto.level==0}">selected="selected"</c:if> >默认</option>
			    <option value="2" <c:if test="${userInfoDto.level==2}">selected="selected"</c:if> >指定日期</option>
			    <option value="1" <c:if test="${userInfoDto.level==1}">selected="selected"</c:if> >无限期</option>
			</select> 
		</td>
		<td>状态：</td>
		<td>
			<select name="userInfoDto.status" id="status">
			  <option value="-1">全部</option>
			  <option value="0" <c:if test="${userInfoDto.status==0}">selected="selected"</c:if> >有效</option>
			  <option value="2" <c:if test="${userInfoDto.status==2}">selected="selected"</c:if> >禁用</option>
			</select> 
		</td>
		<td />
	</tr>
	<tr>
		<td>关键字：</td>
		<td >
			<input type="text" id="keyword" name="userInfoDto.keyword" placeholder="姓名/公司名/手机号码"  value="${userInfoDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>
		<td>注册时间：</td>
		<td colspan="3">
		<input type="text" name="userInfoDto.begindate" id="begindate" size="20" readonly value="${userInfoDto.begindate}"  />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="userInfoDto.enddate" id="enddate" size="20" readonly value="${userInfoDto.enddate}" />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
        <span class="tipsbox"><span id="dateTip" style="display:inline-block;vertical-align:2px;"></span></span>
		</td>
		<td style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="16" class="thead">
 <div class="tit_box">客户端用户列表</div>
    </td>
  </tr>
	<tr>
		<td>姓名</td>
		<td>手机号码</td>
		<td>注册时间</td>
		<td>类型</td>
		<td>客户权限</td>
		<%//只有超级 管理员才显示  1超级管理员%>
		<c:if test="${admin.type==1 }">
			<td>管理员</td>
		</c:if>
		<td>状态</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="userInfo" >
	<tr>
		<td>${userInfo.realname }</td>
	    <td>${userInfo.phone }</td>
	    <td>${userInfo.registertime}</td>
	    <td>
	    	<c:choose>
	    		<c:when test="${userInfo.type==100 }">游客</c:when>
	    		<c:when test="${userInfo.type!=100 }">会员</c:when>
	    	</c:choose>
	    </td> 
	    <td>
	    	<c:choose>
	    		<c:when test="${userInfo.level==0 }">默认</c:when>
	    		<c:when test="${userInfo.level==1 }">无限期</c:when>
	    		<c:when test="${userInfo.level==2 }">指定日期</c:when>
	    	</c:choose>
	    </td>
	<c:if test="${admin.type==1 }">
		<td>
		    ${userInfo.usermanager.realname }
		</td>
	</c:if>
	    <td>
	    	<c:choose>
	    		<c:when test="${userInfo.status==0 }">有效</c:when>
	    		<c:when test="${userInfo.status==2 }"><label style="color: red">禁用</label></c:when>
	    	</c:choose>
	    </td>
	    <td>
	    	<a class="bts_link" href="userInfo/show.action?id=${userInfo.id}" target="main">详情</a> 
	    	<a class="bts_link" href="userInfo/user_toEdit.action?id=${userInfo.id}" >修改</a> 
	    	<c:choose>
	    		<c:when test="${userInfo.status==0 }">
	    			<a class="bts_link" href="javascript:delTips('确定禁用?', 'userInfo/user_disable.action?id=${userInfo.id}')" >禁用</a>
	    		</c:when>
	    		<c:when test="${userInfo.status==2 }">
	    			<a style="color: blue" class="bts_link" href="javascript:delTips('确定恢复?', 'userInfo/user_enable.action?id=${userInfo.id}')" >恢复</a>
	    		</c:when>
	    	</c:choose>
	    </td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="16">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>