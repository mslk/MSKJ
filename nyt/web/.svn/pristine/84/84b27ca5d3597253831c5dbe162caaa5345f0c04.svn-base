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
		   WdatePicker({el:'enddate',dateFmt:'yyyy-MM-dd 00:00:00', minDate: '#F{$dp.$D(\'begindate\')}' });
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
			  <option value="2" <c:if test="${userInfoDto.type==2}">selected="selected"</c:if> >交易商</option>
			  <option value="3" <c:if test="${userInfoDto.type==3}">selected="selected"</c:if> >物流商</option>
			</select> 
		</td>
		<td>状态：</td>
		<td>
			<select name="userInfoDto.status" id="status">
			  <option value="-1">全部</option>
			  <option value="0" <c:if test="${userInfoDto.status==0}">selected="selected"</c:if> >有效</option>
			  <option value="2" <c:if test="${userInfoDto.status==2}">selected="selected"</c:if> >黑名单</option>
			</select> 
		</td>
		<td>关键字：</td>
		<td >
			<input type="text" id="keyword" name="userInfoDto.keyword" placeholder="姓名/公司名/手机号码"  value="${userInfoDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>
		<td></td>
	</tr>
	<tr>
		<td>注册时间：</td>
		<td colspan="5">
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
    <td colspan="6" class="thead">
 <div class="tit_box">客户端用户列表</div>
    </td>
  </tr>
	<tr>
		<td>姓名</td>
		<td>手机号码</td>
		<td>注册时间</td>
		<td>类型</td>
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
	    		<c:when test="${userInfo.type==2 }">交易商</c:when>
	    		<c:when test="${userInfo.type==3 }">物流商</c:when>
	    	</c:choose>
	    </td>
	    <td>
	    	<c:choose>
	    		<c:when test="${userInfo.status==0 }">有效</c:when>
	    		<c:when test="${userInfo.status==2 }">黑名单</c:when>
	    	</c:choose>
	    </td>
	    <td>
	    	<a class="bts_link" href="userInfo/show.action?id=${userInfo.id}" target="_blank">详情</a> 
	    	<a class="bts_link" href="userInfo/user_toEdit.action?id=${userInfo.id}" >修改</a> 
	    	<c:choose>
	    		<c:when test="${userInfo.status==0 }">
	    			<a class="bts_link" href="javascript:delTips('确定拉入黑名单?', 'userInfo/user_disable.action?id=${userInfo.id}')" >拉入黑名单</a>
	    		</c:when>
	    		<c:when test="${userInfo.status==2 }">
	    			<a class="bts_link" href="javascript:delTips('确定恢复?', 'userInfo/user_enable.action?id=${userInfo.id}')" >恢复</a>
	    		</c:when>
	    	</c:choose>
	    </td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="6">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>