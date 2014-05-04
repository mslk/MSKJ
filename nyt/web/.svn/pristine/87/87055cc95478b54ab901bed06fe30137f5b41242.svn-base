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
    <title>桉木查询</title>
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
			$("#begindateBt").click(function()
				{  
				   WdatePicker({el:'begindate',dateFmt:'yyyy-MM-dd 00:00:00', maxDate: '#F{$dp.$D(\'enddate\')}'});
				});  
		
			$("#enddateBt").click(function()
				{  
				   WdatePicker({el:'enddate',dateFmt:'yyyy-MM-dd 23:59:59', minDate: '#F{$dp.$D(\'begindate\')}' });
				});
		});
	</script>
</head>
<body>
<form  id="form1" action="nyt/veneer_infosearch.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>状态：</td>
		<td>
			
	 
			<select name="dto.int_value2" id="int_value2">
			  <option value="-1">全部</option>
			  <option value="0" <c:if test="${dto.int_value2==1}">selected="selected"</c:if> >正常</option>
			  <option value="1" <c:if test="${dto.int_value2==2}">selected="selected"</c:if> >屏蔽</option>
			</select> 
			<select name="dto.int_value1" id="int_value1">
			  <option value="-1">全部</option>
			  <option value="1" <c:if test="${dto.int_value1==1}">selected="selected"</c:if> >供应</option>
			  <option value="2" <c:if test="${dto.int_value1==2}">selected="selected"</c:if> >求购</option>
			</select> 
		</td>
		<td />
	</tr>
	<tr>
	<%--   	<td>关键字：</td>
		<td >
			<input type="text" id="keyword" name="dto.keyword" placeholder="姓名/公司名/手机号码"  value="${dto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>   --%>
		<td>供应时间：</td>
		<td colspan="3">
		<input type="text" name="dto.begindate" id="begindate" size="20" readonly value="${dto.begindate}"  />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="dto.enddate" id="enddate" size="20" readonly value="${dto.enddate}" />
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
 <div class="tit_box">桉木供应列表</div>
    </td>
  </tr>
	<tr>
		<td>供应者</td>
	<!-- 	<td>手机号码</td> -->
		<td>注册时间</td>
		<td>类型</td>
		<td>排序</td>
		 
	<%-- 	<c:if test="${admin.type==1 }">
			<td>管理员</td>
		</c:if> --%>
		<td>状态</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="vo" >
	<tr>
		<td>${vo.userinfo.realname }</td>
	    <td>${vo.addtime }</td>
	    <td>${vo.orderid}</td>
	   <%--  <td>
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
	</c:if> --%>
	    <td>
	    	<c:choose>
	    		<c:when test="${vo.status==0 }">有效</c:when>
	    		<c:when test="${vo.status==1 }"><label style="color: red">屏蔽</label></c:when>
	    	</c:choose>
	    </td>
	    <td>
	    	<a class="bts_link" href="userInfo/show.action?id=${vo.id}" target="main">详情</a> 
	    	<a class="bts_link" href="userInfo/user_toEdit.action?id=${vo.id}" >修改</a> 
	    	<c:choose>
	    		<c:when test="${vo.status==0 }">
	    			<a class="bts_link" href="javascript:delTips('确定禁用?', 'userInfo/user_disable.action?id=${vo.id}')" >禁用</a>
	    		</c:when>
	    		<c:when test="${vo.status==2 }">
	    			<a style="color: blue" class="bts_link" href="javascript:delTips('确定恢复?', 'userInfo/user_enable.action?id=${vo.id}')" >恢复</a>
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