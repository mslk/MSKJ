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
    <title>菜单选项列表查询</title>
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
<form  id="form1" action="nyt/typeListsearch.action" method="post">
<table class="publictable" width="95%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>所属模块：</td>
		<td>
			<% //1桉木, 2胶合板, 3原木, 4淀粉   %>
			<select name="dto.int_valueA" id="int_valueA">
			  <option value="-1">全部</option>
			  <option value="1" <c:if test="${dto.int_valueB==1}">selected="selected"</c:if> >桉木</option>
			  <option value="2" <c:if test="${dto.int_valueB==2}">selected="selected"</c:if> >胶合板</option>
			  <option value="3" <c:if test="${dto.int_valueB==3}">selected="selected"</c:if> >原木</option>
			  <option value="4" <c:if test="${dto.int_valueB==4}">selected="selected"</c:if> >淀粉</option>
			</select>  
	    </td>
	    <td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="dto.keyword" placeholder="选项值/描述"  value="${dto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
		</td>    
		<td>添加时间：</td>
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
	      <div class="tit_box">菜单选项列表</div>
	    </td>
    </tr>
	<tr>
		<td>选项值</td>
		<td>选项描述</td>
		<td>所属模块</td>
	    <td>排序值</td> 
		<td>添加时间</td>
		<td>操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="vo" varStatus="voindex">
	<tr>
		<td>${vo.itemvalue }</td>
		<td>${vo.item_describe }</td>
		<td>
	    	<c:choose>
	    		<c:when test="${vo.type==1 }">桉木</c:when>
	    		<c:when test="${vo.type==2 }">胶合板</c:when>
	    		<c:when test="${vo.type==3 }">原木</c:when>
	    		<c:when test="${vo.type==4 }">淀粉</c:when>
	    	</c:choose>
	    </td>
		<td>${vo.orderid }</td>
	    <td>${vo.addtime }</td>
	    <td>	
	    	<a class="bts_link" href="nyt/typeListdetail.action?dto.int_valueA=${dto.int_valueA}&dto.int_id=${vo.id}" target="main">修改</a> 
	    <%-- 	<c:choose>
	    		<c:when test="${vo.status==0 }">
	    			<a class="bts_link" href="javascript:delTips('确定屏蔽?', 'nyt/typeListshield.action?dto.int_valueA=${dto.int_valueA}&dto.int_valueB=${vo.id}&dto.int_valueC=1')" >屏蔽</a>
	    		</c:when>
	    		<c:when test="${vo.status==1 }">
	    			<a style="color: blue" class="bts_link" href="javascript:delTips('确定恢复?', 'nyt/typeListshield.action?dto.int_valueA=${dto.int_valueA}&dto.int_valueB=${vo.id}&dto.int_valueC=0')" >恢复</a>
	    		</c:when>
	    	</c:choose> --%>
	    	<a class="bts_link" href="javascript:delTips('确定删除?','nyt/typeListdelete.action?dto.int_valueA=${dto.int_valueA}&dto.int_id=${vo.id}')" target="main">删除</a> 
	    	<a class="bts_link" href="javascript:delTips('确定前移?', 'nyt/typeListsortTop.action?dto.int_valueA=${dto.int_valueA }&dto.int_valueC=${vo.orderid+1}&dto.int_valueB=${vo.id }')" >前移</a> 
	    	<a class="bts_link" href="javascript:delTips('确定后移?', 'nyt/typeListsortTop.action?dto.int_valueA=${dto.int_valueA}&dto.int_valueC=${vo.orderid>1?vo.orderid-1:0}&dto.int_valueB=${vo.id }')" >后移</a> 
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