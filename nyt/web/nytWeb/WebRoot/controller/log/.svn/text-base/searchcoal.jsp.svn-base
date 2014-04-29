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
	
		$.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});
		
		var list=[  
			new Entity({id:"minheating",compareId:"maxheating",name:"发热量",required:false,type:22}),	
			new Entity({id:"maxheating",compareId:"minheating",name:"发热量",required:false,type:23}),
			new Entity({id:"sulphur",name:"硫分",required:false,type:12}),
			new Entity({id:"ash",name:"灰分",required:false,type:12}),
			new Entity({id:"moisture",name:"全水",required:false,type:12})
				];
		validateBase(list);
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
<form  id="form1" action="log/searchCoal.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="5" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		<td>煤种：</td>
		<td>
			<input type="text" id="coalTypeName" name="searchLogCoalDto.coalname" value="${searchLogCoalDto.coalname}"  />
			<input type="button" value="选择煤种" onclick="chooseCoalType()"/>
			<input type="hidden" id="coalTypeId" name="searchLogCoalDto.coaltype" value="${searchLogCoalDto.coaltype}">
			<div class="tipsbox"><div id="coalTypeNameTip"></div></div>
		</td>
		<td>粒度：</td>
		<td colspan="2">
			<input type="text" id="coalParticleSizeName" name="searchLogCoalDto.coalsizename" value="${searchLogCoalDto.coalsizename}"  />
			<input type="button" value="选择粒度" onclick="chooseCoalParticleSize()"/>
			<input type="hidden" id="coalParticleSizeId" name="searchLogCoalDto.coalsize" value="${searchLogCoalDto.coalsize}">
			<div class="tipsbox"><div id="coalTypeNameTip"></div></div>
		</td>
	</tr>
	<tr>
	<td>发热量：</td>
		<td colspan="4">
			<input type="text" id="minheating" name="searchLogCoalDto.minheating"   value="${searchLogCoalDto.minheating}" size="10" />
			-
			<input type="text" id="maxheating" name="searchLogCoalDto.maxheating"   value="${searchLogCoalDto.maxheating}" size="10" />大卡
			<div id="minheatingTip" style="display:inline-block;" ></div>
		</td>
	</tr>
	<tr>
	<td>硫分：</td>
		<td >
			&le;<input type="text" id="sulphur" name="searchLogCoalDto.sulphur"   value="${searchLogCoalDto.sulphur}"  />%
			<div id="sulphurTip" style="display:inline-block;"></div>
		</td>
		<td>灰分：</td>
		<td colspan="2">
			&le;<input type="text" id="ash" name="searchLogCoalDto.ash"   value="${searchLogCoalDto.ash}"  />%
			<div id="ashTip" style="display:inline-block;"></div>
		</td>
	</tr>
	<tr>
	<td>全水：</td>
		<td colspan="4">
			&le;<input type="text" id="moisture" name="searchLogCoalDto.moisture"   value="${searchLogCoalDto.moisture}"  />%
			<div id="moistureTip" style="display:inline-block;"></div>
		</td>
	</tr>
	<tr>
		<td>有效期：</td>
		<td colspan="2">
		<input type="text" name="searchLogCoalDto.begindate" id="begindate" size="20" readonly value="${searchLogCoalDto.begindate}"  />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="searchLogCoalDto.enddate" id="enddate" size="20" readonly value="${searchLogCoalDto.enddate}"  />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
        <span class="tipsbox"><span id="dateTip" style="display:inline-block;vertical-align:2px;"></span></span>
		</td>
		<td>关键字：</td>
		<td>
			<input type="text" id="keyword" name="searchLogCoalDto.keyword"  placeholder="姓名/手机号码/交货地" value="${searchLogCoalDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
	   </td>
	</tr>
	<tr>
	  
	   <td>会员类型：</td>
		<td>
			<select name="searchLogCoalDto.type" >
				<option value="-1" >全部</option>
				<option value="2" <c:if test="${searchLogCoalDto.type==2}">selected="selected"</c:if>>交易商</option>
				<option value="3" <c:if test="${searchLogCoalDto.type==3}">selected="selected"</c:if>>物流商</option>
				<option value="100" <c:if test="${searchLogCoalDto.type==100}">selected="selected"</c:if>>游客</option>
			</select>
	   </td>
	   <td>查询类型：</td>
		<td>
			<select name="searchLogCoalDto.searchtype" >
				<option value="-1" >全部</option>
				<option value="0" <c:if test="${searchLogCoalDto.searchtype==0}">selected="selected"</c:if>>供应信息</option>
				<option value="1" <c:if test="${searchLogCoalDto.searchtype==1}">selected="selected"</c:if>>求购信息</option>
			</select>
	   </td>
		<td  style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="13" class="thead">
 <div class="tit_box">煤炭查询日志列表</div>
    </td>
  </tr>
	<tr>
		<td width="">姓名</td>
		<td width="10%">手机</td>
		<td width="">会员类型</td>
		<td width="">查询类型</td>
		<td width="10%">煤种</td>
		<td width="15%">粒度</td>
		<td width="10%">发热量(大卡)</td>
		<td width="5%">硫分(%)</td>
		<td width="5%">灰分(%)</td>
		<td width="5%">全水(%)</td>
		<td width="">交货地</td>
		<td width="10%">时间</td>
		<td width="">操作管理</td>
	</tr>
<c:forEach items="${request.result.queryList}" var="searchLogCoal" >
	<tr>
		<td>${searchLogCoal.username }</td>
		<td>${searchLogCoal.phone }</td>
		<td>
		    <c:choose>
		    	<c:when test="${searchLogCoal.usertype==2}">交易商</c:when>
		    	<c:when test="${searchLogCoal.usertype==3}">物流商</c:when>
		    	<c:when test="${searchLogCoal.usertype==100}">游客</c:when>
		    	<c:otherwise>未知</c:otherwise>
		    </c:choose>
	    </td>
	    <td>
		    <c:choose>
		    	<c:when test="${searchLogCoal.searchtype==0}">供应信息</c:when>
		    	<c:when test="${searchLogCoal.searchtype==1}">求购信息</c:when>
		    	<c:otherwise>未知</c:otherwise>
		    </c:choose>
	    </td>
	    <td>${searchLogCoal.coalname }</td>
	    <td>${searchLogCoal.coalsizename }</td>
	    <td>${searchLogCoal.minheatingtype }-${searchLogCoal.maxheatingtype }</td>
	    <td>${searchLogCoal.maxsulphur }</td>
	    <td>${searchLogCoal.maxash }</td>
	    <td>${searchLogCoal.maxmoisture }</td>
	    <td>${searchLogCoal.startprvname}-${searchLogCoal.startcityname}-${searchLogCoal.startcountyname}-${searchLogCoal.place }</td>
	    <td><fmt:formatDate  value="${searchLogCoal.addtime}" pattern="yyyy-MM-dd" /></td>
	    <td>--</td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="13">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
<div id="ly" style="position: absolute; top: 0px; filter: alpha(opacity=60); 
z-index: 2; left: 0px; display: none;">
</div>
<!--浮层框架开始-->
<div id="Layer2"  style="position: absolute; z-index: 3;
background-color: #fff; display: none; width:640; height:150;" >
</div>
<!--浮层框架结束-->	
</body>
</html>