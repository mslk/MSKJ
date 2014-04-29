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
	//validateBase(list);
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
<form  id="form1" action="transportDemand/search.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="4" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
  </tr>
	<tr>
	<td width="10%">始发地：</td>
		<td width="40%">
			<input type="text" id="start" name="transportDemandDto.start"   value="${transportDemandDto.start}"  />
			<div class="tipsbox"><div id="startTip"></div></div>
		</td>
		<td width="10%">目的地：</td>
		<td width="40%">
			<input type="text" id="stop" name="transportDemandDto.stop"   value="${transportDemandDto.stop}"  />
			<div class="tipsbox"><div id="stopTip"></div></div>
		</td>
	</tr>
	<tr>
		<td>有效期：</td>
		<td colspan="3" >
		<input type="text" name="transportDemandDto.begindate" id="begindate" size="20" readonly value="<fmt:formatDate  value="${transportDemandDto.begindate}" pattern="yyyy-MM-dd"/>" />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="transportDemandDto.enddate" id="enddate" size="20" readonly value="<fmt:formatDate  value="${transportDemandDto.enddate}" pattern="yyyy-MM-dd"/>" />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
        <span class="tipsbox"><span id="dateTip" style="display:inline-block;vertical-align:2px;"></span></span>
		</td>
	</tr>
	<tr>
		<td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="transportDemandDto.keyword"  placeholder="姓名"  value="${transportDemandDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>
		<td>状态：</td>
		<td>
			<select name="transportDemandDto.status" >
				<option value="-1" >全部</option>
				<option value="0" <c:if test="${transportDemandDto.status==0}">selected="selected"</c:if>>有效</option>
				<option value="1" <c:if test="${transportDemandDto.status==1}">selected="selected"</c:if>>无效</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit"  id="tijiao" value="搜索"  />
	   </td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="6" class="thead">
 <div class="tit_box">货讯信息列表</div>
    </td>
  </tr>
	<tr>
		<td>发布人</td>
		<td>始发地</td>
		<td>目的地</td>
		<td>车数量</td>
		<td>有效期</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="transportDemand" >
	<tr>
		<td>${transportDemand.username }</td>
		<td><c:choose>
	    		<c:when test="${transportDemand.startshortname != null}">${transportDemand.startshortname}</c:when>
	    		<c:otherwise>${transportDemand.startprvname}${transportDemand.startcityname}${transportDemand.start }</c:otherwise>
	    	</c:choose>
	    </td>
	    <td><c:choose>
	    		<c:when test="${transportDemand.stopshortname != null}">${transportDemand.stopshortname}</c:when>
	    		<c:otherwise>${transportDemand.stopprvname}${transportDemand.stopcityname}${transportDemand.stop }</c:otherwise>
	    	</c:choose>
	    </td>
	    <td>${transportDemand.quantity }</td>
	    <td><fmt:formatDate  value="${transportDemand.validdate}" pattern="yyyy-MM-dd"/></td>
	    <td>
	    	<a class="bts_link" href="transportDemand/show.action?id=${transportDemand.id}" target="_blank">详情</a>
	    	<a class="bts_link" href="javascript:delTips('','transportDemand/delete.action?demandId=${transportDemand.id}');" >删除</a>  
	    	<c:if test="${transportDemand.validstatus==0}">
				<a class="bts_link" href="javascript:delTips('您确定要屏蔽这条信息？','transportDemand/invalid.action?demandId=${transportDemand.id}');" >屏蔽</a> 
			</c:if>
	    	<c:if test="${transportDemand.validstatus==1}">
	    		<a class="bts_link" href="javascript:delTips('您确定要恢复这条信息？','transportDemand/enable.action?demandId=${transportDemand.id}');" >恢复</a> 
	    	</c:if>
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