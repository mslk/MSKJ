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
	<script language="javascript" src="jquery-validate/DateTimeMask.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="js/validate.js"></script>
	<script type="text/javascript" charset="UTF-8"
		src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" charset="UTF-8" src="js/base.js"></script>
	<script>
	$(document).ready(function(){
		//
		$("#begindateBt").click(function()
			{  
			   WdatePicker({el:'begindate',dateFmt:'yyyy-MM-dd', maxDate: '#F{$dp.$D(\'enddate\')}'});
			});  
	
		$("#enddateBt").click(function()
			{  
			   WdatePicker({el:'enddate',dateFmt:'yyyy-MM-dd', minDate: '#F{$dp.$D(\'begindate\')}' });
			});
	});
	</script>
	</head>
<body>
<form  id="form1" action="userProposal/search.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="5" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>有效期：</td>
		<td colspan="4">
		<input type="text" name="userProposalDto.begindate" id="begindate" size="20" readonly value="${userProposalDto.begindate}"  />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="userProposalDto.enddate" id="enddate" size="20" readonly value="${userProposalDto.enddate}"  />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
        <span class="tipsbox"><span id="dateTip" style="display:inline-block;vertical-align:2px;"></span></span>
		</td>
	</tr>
	<tr>
	  <td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="userProposalDto.keyword"  placeholder="姓名/手机号码" value="${userProposalDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
	   </td>
	   <td>状态：</td>
		<td>
			<select name="userProposalDto.status" >
				<option value="-1" >全部</option>
				<option value="0" <c:if test="${userProposalDto.status==0}">selected="selected"</c:if>>未处理</option>
				<option value="1" <c:if test="${userProposalDto.status==1}">selected="selected"</c:if>>已处理</option>
			</select>
	   </td>
		<td style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="5" class="thead">
 <div class="tit_box">留言列表</div>
    </td>
  </tr>
	<tr>
		<td>姓名</td>
		<td>手机</td>
		<td>内容</td>
		<td>时间</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="userProposal" >
	<tr>
		<td>${userProposal.username }</td>
		<td>${userProposal.phone }</td>
	    <td>${userProposal.content }</td>
	    <td><fmt:formatDate  value="${userProposal.addtime}" pattern="yyyy-MM-dd" /></td>
	    <td>
	    	<c:if test="${userProposal.status==0}">
				<a class="bts_link" href="javascript:delTips('您确定要标为已处理？','userProposal/process.action?id=${userProposal.id}');" >处理</a> 
			</c:if>
	    	<c:if test="${userProposal.status==1}">已处理</c:if> 
	    </td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="5">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>