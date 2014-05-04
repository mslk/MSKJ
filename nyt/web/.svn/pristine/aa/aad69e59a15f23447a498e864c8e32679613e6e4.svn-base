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
	<script type="text/javascript" src="js/base.js"></script>
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
<form  id="form1" action="otherAid/searchQualityControl.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
	  <td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="qualityControlDto.keyword"  placeholder="报告序号" value="${qualityControlDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
	   </td>
		<td style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="18" class="thead">
 <div class="tit_box">质检报告列表</div>
    </td>
  </tr>
	<tr>
		<td width="">报告序号</td>
		<td width="">全水分</td>
		<td width="">水分</td>
		<td width="">灰分</td>
		<td width="">挥发分</td>
		<td width="">焦渣特征</td>
		<td width="">固定碳</td>
		<td width="">全硫</td>
		<td width="">氢</td>
		<td width="">发热量Ｑgr,d</td>
		<td width="">发热量Ｑnet,ar</td>
		<td width="">灰熔融性 DT</td>
		<td width="">灰熔融性 ST</td>
		<td width="">灰熔融性 HT</td>
		<td width="">灰熔融性 FT</td>
		<td width="">粘结指数</td>
		<td width="">减灰（回收率）</td>
		<%--<td width="">添加时间</td>
		--%><td width="60px">操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="qualityControl" >
	<tr>
		<td>${qualityControl.number }</td>
	    <td>${qualityControl.quanshuifen }</td>
		 <td>${qualityControl.shuifen }</td>
	    <td>${qualityControl.huifen }</td>
	    <td>${qualityControl.huifafen }</td>
	    <td>${qualityControl.jiaozha }</td>
	    <td>${qualityControl.gudingtan }</td>
	    <td>${qualityControl.quanniu }</td>
	    <td>${qualityControl.qing }</td>
	    <td>${qualityControl.fareliang1 }</td>
	    <td>${qualityControl.fareliang2 }</td>
	    <td>${qualityControl.huiDt }</td>
	    <td>${qualityControl.huiSt }</td>
	    <td>${qualityControl.huiHt }</td>
	    <td>${qualityControl.huiFt }</td>
	    <td>${qualityControl.nianjie }</td>
	    <td>${qualityControl.jianhui }</td><%--
	    <td><fmt:formatDate  value="${qualityControl.addtime}" pattern="yyyy-MM-dd" /></td>
	    --%><td>
	    <a class="bts_link" href="otherAid/initUpdateQualityControl.action?id=${qualityControl.id}" target="_blank">修改</a> 
	    	<a class="bts_link" href="javascript:delTips('确定删除?', 'otherAid/delQualityControl.action?id=${qualityControl.id}')" >删除</a> 
	    </td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="18">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>