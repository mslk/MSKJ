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
    <title>木材查询</title>
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
<form  id="form1" action="nyt/woodPurchasesearch.action" method="post">
<table class="publictable" width="95%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>状态：</td>
		<td>
			<% //1供应, 2求购  %>
			<input type="hidden" name="dto.int_valueA" id="int_valueA" value="${dto.int_valueA}"/>

			<select name="dto.int_valueB" id="int_valueB">
			  <option value="-1">全部</option>
			  <option value="0" <c:if test="${dto.int_valueB==0}">selected="selected"</c:if> >正常</option>
			  <option value="1" <c:if test="${dto.int_valueB==1}">selected="selected"</c:if> >屏蔽</option>
			</select>  
	  <%--   <td>关键字：</td>
		<td >
			<input type="text" id="keyword" name="dto.keyword" placeholder="价格/数量/用途"  value="${dto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>     --%>
		<td>时间：</td>
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

<table class="publictable" width="95%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="16" class="thead">
 <div class="tit_box">桉木供应列表</div>
    </td>
  </tr>
	<tr>
		<td>供应者</td>
	<!-- 	<td>手机号码</td> -->
		<td>价格</td>
		<td>数量</td>
		<td>有效期</td>
		<td>发布时间</td>
		<td>状态</td>
		<!--  <td>排序值</td>-->
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="vo" varStatus="voindex">
	<tr>
		<td>${vo.userinfo.realname }</td>
		<td>${vo.price }</td>
		<td>${vo.number }</td>
		<td>${vo.valid }</td>
	    <td>${vo.addtime }</td>
	 
	    <td>
	    	<c:choose>
	    		<c:when test="${vo.status==0 }">正常</c:when>
	    		<c:when test="${vo.status==1 }"><label style="color: red">屏蔽</label></c:when>
	    	</c:choose>
	    </td>
	    <%--  <td>${vo.orderid}</td> --%>
	    <td>	
	    	<a class="bts_link" href="nyt/woodPurchasedetail.action?dto.int_valueA=${dto.int_valueA}&dto.int_id=${vo.id}" target="main">详情</a> 
	    	<c:choose>
	    		<c:when test="${vo.status==0 }">
	    			<a class="bts_link" href="javascript:delTips('确定屏蔽?', 'nyt/woodPurchaseshield.action?dto.int_valueA=${dto.int_valueA}&dto.int_valueB=${vo.id}&dto.int_valueC=1')" >屏蔽</a>
	    		</c:when>
	    		<c:when test="${vo.status==1 }">
	    			<a style="color: blue" class="bts_link" href="javascript:delTips('确定恢复?', 'nyt/woodPurchaseshield.action?dto.int_valueA=${dto.int_valueA}&dto.int_valueB=${vo.id}&dto.int_valueC=0')" >恢复</a>
	    		</c:when>
	    	</c:choose>
	    	<a class="bts_link" href="javascript:delTips('确定删除?','nyt/woodPurchasedelete.action?dto.int_valueA=${dto.int_valueA}&dto.int_id=${vo.id}')" target="main">删除</a> 
	    	<%--首页,前5条显示取消置顶链接 --%>
	    	<c:if test="${1==result.currentlyPage && voindex.index ==0}">
	    		<a class="bts_link" href="javascript:delTips('确定取消置顶?', 'nyt/woodPurchasesortTop.action?dto.int_valueA=${dto.int_valueA}&dto.int_valueC=0&dto.int_valueB=${vo.id }')" >取消置顶</a> 
	    	</c:if>
	    	<%--首页第1条就不用置顶了 A类型1供应,2求购 B记录id C置顶值--%>
	    	<c:if test="${!(1==result.currentlyPage && 0 == voindex.index)}">
	    		<a class="bts_link" href="javascript:delTips('确定置顶?', 'nyt/woodPurchasesortTop.action?dto.int_valueA=${dto.int_valueA }&dto.int_valueC=${vo.orderid+1}&dto.int_valueB=${vo.id }')" >置顶</a> 
	    	</c:if>
	    	
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