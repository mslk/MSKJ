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
    <title>车讯信息</title>
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
<form  id="form1" action="sortOrder/searchTransportSupply.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="4" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
	<td width="10%">始发地：</td>
		<td width="40%">
			<input type="text" id="begin" name="transportSupplyDto.start"   value="${transportDemandDto.start}"  />
			<div class="tipsbox"><div id="beginTip"></div></div>
		</td>
		<td width="10%">目的地：</td>
		<td width="40%">
			<input type="text" id="end" name="transportSupplyDto.stop"   value="${transportDemandDto.stop}"  />
			<div class="tipsbox"><div id="endTip"></div></div>
		</td>
	</tr>
	<tr>
		<td>有效期：</td>
		<td colspan="3">
		<input type="text" name="transportSupplyDto.begindate" id="begindate" size="20" readonly value="<fmt:formatDate  value="${transportDemandDto.begindate}" pattern="yyyy-MM-dd"/>" />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="transportSupplyDto.enddate" id="enddate" size="20" readonly value="<fmt:formatDate  value="${transportDemandDto.enddate}" pattern="yyyy-MM-dd"/>" />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
        <span class="tipsbox"><span id="dateTip" style="display:inline-block;vertical-align:2px;"></span></span>
		</td>
	</tr>
	<tr >
	<td >关键字：</td>
		<td colspan="1">
			<input type="text" id="keyword" name="transportSupplyDto.keyword"  placeholder="姓名/车牌号"  value="${transportDemandDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>
		<td colspan="2" style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 <div class="tit_box">车讯信息列表</div>
    </td>
  </tr>
	<tr>
		<td>发布人</td>
		<td>始发地</td>
		<td>目的地</td>
		<td>车数量</td>
		<td>有效期</td>
		<td>排序值</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="transportSupply" >
	<tr>
		<td>${transportSupply.username }</td>
		<td><c:choose>
	    		<c:when test="${transportSupply.startshortname != null}">${transportSupply.startshortname}</c:when>
	    		<c:otherwise>${transportSupply.startprvname}${transportSupply.startcityname}${transportSupply.start }</c:otherwise>
	    	</c:choose>
	    </td>
	    <td><c:choose>
	    		<c:when test="${transportSupply.stopshortname != null}">${transportSupply.stopshortname}</c:when>
	    		<c:otherwise>${transportSupply.stopprvname}${transportSupply.stopcityname}${transportSupply.stop }</c:otherwise>
	    	</c:choose>
	    </td>
	    <td>${transportSupply.quantity }</td>
	    <td><fmt:formatDate  value="${transportSupply.validdate}" pattern="yyyy-MM-dd"/></td>
	    <td>${transportSupply.sortnumber }</td>
	    <td>
	    	<a class="bts_link" href="sortOrder/showTransportSupply.action?id=${transportSupply.id}" target="_blank">修改排序值</a>
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