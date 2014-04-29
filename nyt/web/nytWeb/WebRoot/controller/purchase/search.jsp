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
<form  id="form1" action="purchase/search.action" method="post">
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="7" class="thead">
 		<div class="tit_box">条件搜索</div>
    </td>
  </tr>
	<tr>
		
		<td>煤种：</td>
		<td colspan="2">
			<input type="text" id="coalTypeName" name="purchaseDto.coalname" value="${purchaseDto.coalname}"  />
			<input type="button" value="选择煤种" onclick="chooseCoalType()"/>
			<input type="hidden" id="coalTypeId" name="purchaseDto.coaltype" value="${purchaseDto.coaltype}">
			<div class="tipsbox"><div id="coalTypeNameTip"></div></div>
		</td>
		<td>粒度：</td>
		<td colspan="3">
			<input type="text" id="coalParticleSizeName" name="purchaseDto.coalsizename" value="${purchaseDto.coalsizename}"  />
			<input type="button" value="选择粒度" onclick="chooseCoalParticleSize()"/>
			<input type="hidden" id="coalParticleSizeId" name="purchaseDto.coalsize" value="${purchaseDto.coalsize}">
			<div class="tipsbox"><div id="coalTypeNameTip"></div></div>
		</td>
	</tr>
	<tr>
	<td>发热量：</td>
		<td colspan="6">
			<input type="text" id="minheating" name="purchaseDto.minheating"   value="${purchaseDto.minheating}" size="10" />
			-
			<input type="text" id="maxheating" name="purchaseDto.maxheating"   value="${purchaseDto.maxheating}" size="10" />大卡
			<div id="minheatingTip" style="display:inline-block;"></div>
		</td>
	</tr>
	<tr>
		<td>硫分：</td>
		<td colspan="1">
			&le;<input type="text" id="sulphur" name="purchaseDto.sulphur"   value="${purchaseDto.sulphur}"  />%
			<div id="sulphurTip" style="display:inline-block;"></div>
		</td>
		<td>灰分：</td>
		<td colspan="4"> 
			&le;<input type="text" id="ash" name="purchaseDto.ash"   value="${purchaseDto.ash}"  />%
			<div id="ashTip" style="display:inline-block;"></div>
		</td>
	</tr>
	<tr>
	<td>全水：</td>
		<td colspan="6">
			&le;<input type="text" id="moisture" name="purchaseDto.moisture"   value="${purchaseDto.moisture}"  />%
			<div id="moistureTip" style="display:inline-block;"></div>
		</td>
	</tr>
	<tr>
		<td>有效期：</td>
		<td colspan="6">
		<input type="text" name="purchaseDto.begindate" id="begindate" size="20" readonly value="${purchaseDto.begindate}"  />
		<input type="button" value="选择日期"   id="begindateBt"/>
		至
		<input type="text" name="purchaseDto.enddate" id="enddate" size="20" readonly value="${purchaseDto.enddate}"  />
		<input type="button" value="选择日期" id="enddateBt" />
        <span id="showMsg"></span>
        <span class="tipsbox"><span id="dateTip" style="display:inline-block;vertical-align:2px;"></span></span>
		</td>
	</tr>
	<tr>
	 <td>关键字：</td>
	 <td>
			<input type="text" id="keyword" name="purchaseDto.keyword"  placeholder="姓名/手机号码" value="${purchaseDto.keyword}"  />
			<div class="tipsbox"><div id="keywordTip"></div></div>
	</td>
	<td>状态：</td>
		<td>
			<select name="purchaseDto.status" >
				<option value="-1" >全部</option>
				<option value="0" <c:if test="${purchaseDto.status==0}">selected="selected"</c:if>>有效</option>
				<option value="1" <c:if test="${purchaseDto.status==1}">selected="selected"</c:if>>无效</option>
			</select>
	   </td>
	<td  colspan="3" style="text-align:center">
		<input type="submit"  id="tijiao" value="搜索"  />
		</td>
	</tr>
</table>

<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="9" class="thead">
 <div class="tit_box">求购信息列表</div>
    </td>
  </tr>
	<tr>
		<td width="15%">发布人</td>
		<td width="10%">煤种</td>
		<td width="15%">粒度</td>
		<td width="5%">发热量<br>(大卡)</td>
		<td width="5%">硫分(%)</td>
		<td width="5%">灰分(%)</td>
		<td width="5%">全水(%)</td>
		<td width="10%">有效期</td>
		<td width="20%">操作管理</td>
		
	</tr>
<c:forEach items="${request.result.queryList}" var="purchaseInfo" >
	<tr>
		<td>${purchaseInfo.buyername }</td>
		<td>${purchaseInfo.coalname }</td>
	    <td>${purchaseInfo.coalsizename }</td>
	    <td>${purchaseInfo.heating }</td>
	    <td>${purchaseInfo.sulphur }</td>
	    <td>${purchaseInfo.ash }</td>
	    <td>${purchaseInfo.moisture }</td>
	    <td><fmt:formatDate  value="${purchaseInfo.validdate}" pattern="yyyy-MM-dd"/></td>
	    <td>
	    	<a class="bts_link" href="purchase/show.action?id=${purchaseInfo.purid}" target="_blank">详情</a> 
	    	<a class="bts_link" href="javascript:delTips('','purchase/delete.action?purId=${purchaseInfo.purid}');" >删除</a> 
	   		<c:if test="${purchaseInfo.validstatus==0}">
				<a class="bts_link" href="javascript:delTips('您确定要屏蔽这条信息？','purchase/invalid.action?purId=${purchaseInfo.purid}');" >屏蔽</a> 
			</c:if>
	    	<c:if test="${purchaseInfo.validstatus==1}">
	    		<a class="bts_link" href="javascript:delTips('您确定要恢复这条信息？','purchase/enable.action?purId=${purchaseInfo.purid}');" >恢复</a> 
	    	</c:if>
	    </td>
	</tr>
	
</c:forEach>

	<tr>
  		<td colspan="9">
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