<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="lefthtml">
  <head>
    <base href="<%=basePath%>">
    <title>后台操作首页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	
   <style type="text/css">
   html{ height:100%; padding-right:10px;}
    body{  overflow-x : hidden ;font-size:12px; font-family:"宋体";  margin:0; padding:0}
    
	img{border:0}
	
	ul,li{margin:0; padding:0; float:left; list-style:none; list-style-type:none}
	
	#content_box{margin:10px 0 10px 10px; clear:both}
	
	#content_box .left_bg{background-color:#E6E6E6;}
	
	#content_box .left_box{ background-color:#F0F2F3;/* border:1px solid #D6D6D6*/}

	.one_m_over{ width:220px; padding-left:34px; height:32px; line-height:32px; display:block; font-size:14px; color:#004D91; font-weight:bold; clear:both; text-decoration:none}
	.one_m_out{ width:176px; padding-left:34px; height:32px; line-height:32px; display:block; font-size:14px; color:#222; font-weight:bold; clear:both; text-decoration:none}
	
	#content_box .left_box ul{width:100%; /*border:1px solid #D6D6D6; border-bottom:none;*/}
	#content_box .left_box li{ height:28px; padding:1px 0; clear:both}
	.tow_m_over{background:url(images/two_m_over.jpg); width:178px; padding-left:34px; height:28px; line-height:28px; display:block; font-size:14px; color:#069DBF; font-weight:bold; clear:both; text-decoration:none}
	.tow_m_over:hover{background:url(images/two_m_over.jpg);}
	.tow_m_out{background:url(images/two_m_bg.jpg); width:177px; padding-left:34px; height:28px; line-height:28px; display:block; font-size:14px; color:#454545; clear:both; text-decoration:none}
	.tow_m_out:hover{background:url(images/two_m_over.jpg);}
   </style>
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	
	<script type="text/javascript">
	function viewChild(str){
		var styleValue=document.getElementById(str).style.display;
		if(styleValue==""){
			document.getElementById(str).style.display="none";
		}else if (styleValue=="none"){
			document.getElementById(str).style.display="";
		}
	}
	</script>
  </head>
  
  <body>
<div id="content_box">
  <div class="left_bg">
    <div class="left_box">
    <!-- 
       <a href="javascript:onClick=viewChild('child_1')" class="one_m_out">demo</a>
      <ul id="child_1" style="display:none">
        <li><a href="controller/example/demo-js.jsp" class="tow_m_out" target="main">js 封装验证 demo</a></li>
        <li><a href="controller/example/demo-add1.jsp" class="tow_m_out" target="main">添加-对象传值1</a></li>
        <li><a href="controller/example/demo-add2.jsp" class="tow_m_out" target="main">添加-字段传值2</a></li>
        <li><a href="controller/example/demo-search.jsp" class="tow_m_out" target="main">搜索页面1</a></li>
        <li><a href="demo/search_allUser.action" class="tow_m_out" target="main">搜索页面2</a></li>
        <li><a href="controller/example/userInfo.jsp" class="tow_m_out" target="main">修改密码</a></li>
        <li><a href="" class="tow_m_out" target="_top">重新登录</a></li>
      </ul>
       -->
      <a href="javascript:onClick=viewChild('child_2')" class="one_m_out">推送任务管理</a>
      <ul id="child_2" style="display:none">
             <li><a href="controller/task/add.jsp" class="tow_m_out" target="main">添加推送任务</a></li>
             <li><a href="pushTask/taskSearch_searchList.action" class="tow_m_out" target="main">待审核任务列表</a></li>
      </ul>
      <a href="javascript:onClick=viewChild('child_3')" class="one_m_out">审核通过的任务</a>
      <ul id="child_3" style="display:none">
             <li><a href="pushTask/taskSearch_searchList.action?status=2" class="tow_m_out" target="main">审核通过任务列表</a></li>
      </ul>
      <a href="javascript:onClick=viewChild('child_4')" class="one_m_out">煤种管理</a>
      <ul id="child_4" style="display:none">
             <li><a href="controller/coaltype/add.jsp" class="tow_m_out" target="main">添加煤种</a></li>
             <li><a href="coal/coaltypeSearch.action" class="tow_m_out" target="main">煤种列表</a></li>
      </ul>
      <a href="javascript:onClick=viewChild('child_41')" class="one_m_out">粒度管理</a>
      <ul id="child_41" style="display:none">
             <li><a href="controller/coalparticlesize/add.jsp" class="tow_m_out" target="main">添加粒度</a></li>
             <li><a href="coal/coalParticleSizeSearch.action" class="tow_m_out" target="main">粒度列表</a></li>
      </ul>
      <a href="javascript:onClick=viewChild('child_5')" class="one_m_out">客户端用户管理</a>
      <ul id="child_5" style="display:none">
        <li><a href="userInfo/search.action" class="tow_m_out" target="main">客户端用户列表</a></li>
      </ul>
      <a href="javascript:onClick=viewChild('child_6')" class="one_m_out">求购信息管理</a>
      <ul id="child_6" style="display:none">
        <li><a href="purchase/search.action" class="tow_m_out" target="main">求购信息列表</a></li>
      </ul>
      <a href="javascript:onClick=viewChild('child_7')" class="one_m_out">供应信息管理</a>
      <ul id="child_7" style="display:none">
        <li><a href="provider/search.action" class="tow_m_out" target="main">供应信息列表</a></li>
      </ul>
	  <!---->
      <a href="javascript:onClick=viewChild('child_8')" class="one_m_out">信息排序置顶管理</a>
      <ul id="child_8" style="display:none">
        <li><a href="sortOrder/searchPurchase.action" class="tow_m_out" target="main">求购信息</a></li>
        <li><a href="sortOrder/searchProvider.action" class="tow_m_out" target="main">供应信息</a></li>
        <li><a href="sortOrder/searchTransportDemand.action" class="tow_m_out" target="main">货讯信息</a></li>
        <li><a href="sortOrder/searchTransportSupply.action" class="tow_m_out" target="main">车讯信息</a></li>
      </ul>
 	  <a href="javascript:onClick=viewChild('child_10')" class="one_m_out">交货地管理</a>
      <ul id="child_10" style="display:none">
      	<li><a href="controller/deliveryplacetype/add.jsp" class="tow_m_out" target="main">添加交货地类型</a></li>
      	<li><a href="deliveryplace/searchType.action" class="tow_m_out" target="main">交货地类型列表</a></li>
        <li><a href="deliveryplace/searchArea.action" class="tow_m_out" target="main">交货地地区列表</a></li>
        <%--<li><a href="controller/deliveryplace/add.jsp" class="tow_m_out" target="main">添加交货地</a></li>
        --%><li><a href="deliveryplace/search.action" class="tow_m_out" target="main">交货地列表</a></li>
      </ul>
 	  <a href="javascript:onClick=viewChild('child_11')" class="one_m_out">地区管理</a>
      <ul id="child_11" style="display:none">
        <li><a href="controller/receiptplace/add.jsp" class="tow_m_out" target="main">添加地区</a></li>
        <li><a href="receiptplace/search.action" class="tow_m_out" target="main">地区列表</a></li>
      </ul>
      
      <a href="javascript:onClick=viewChild('child_12')" class="one_m_out">货讯管理</a>
      <ul id="child_12" style="display:none">
        <li><a href="transportDemand/search.action" class="tow_m_out" target="main">货讯列表</a></li>
      </ul>
      <a href="javascript:onClick=viewChild('child_13')" class="one_m_out">车讯管理</a>
      <ul id="child_13" style="display:none">
         <li><a href="transportSupply/search.action" class="tow_m_out" target="main">车讯列表</a></li>
      </ul>
      <a href="javascript:onClick=viewChild('child_9')" class="one_m_out">广告与菜单信息功能</a>
      	 <ul id="child_9" style="display:none">
      	    <li><a href="otherAid/advertisingShow.action" class="tow_m_out" target="main">广告管理</a></li>
	        <li><a href="controller/otherAid/upFile.jsp" class="tow_m_out" target="main">图片上传</a></li>
	        <li><a href="otherAid/helpCenterShow.action" class="tow_m_out" target="main">帮助信息管理</a></li>
      	   </ul>
      	<a href="javascript:onClick=viewChild('child_14')" class="one_m_out">版本管理</a>
      	    <ul id="child_14" style="display:none">
      	   <li><a href="controller/version/upFile.jsp" class="tow_m_out" target="main">上传android新版本</a></li>
      	   <li><a href="controller/version/list.jsp" class="tow_m_out" target="main">修改版本信息</a></li>
      	   </ul>
      <a href="javascript:onClick=viewChild('child_15')" class="one_m_out">留言管理</a>
   	   <ul id="child_15" style="display:none">
	   	   <li><a href="userProposal/search.action" class="tow_m_out" target="main">留言列表</a></li>
   	   </ul>
   	   <a href="javascript:onClick=viewChild('child_16')" class="one_m_out">日志管理</a>
   	   <ul id="child_16" style="display:none">
	   	   <li><a href="log/searchLogin.action" class="tow_m_out" target="main">用户登录日志</a></li>
	   	   <li><a href="log/searchModule.action" class="tow_m_out" target="main">模块访问日志</a></li>
	   	   <li><a href="log/searchCoal.action" class="tow_m_out" target="main">煤炭查询日志</a></li>
	   	   <li><a href="log/searchTransport.action" class="tow_m_out" target="main">物流查询日志</a></li>
   	   </ul>
   	   <a href="javascript:onClick=viewChild('child_17')" class="one_m_out">质检管理</a>
   	   <ul id="child_17" style="display:none">
	   	   <li><a href="otherAid/searchQualityControl.action" class="tow_m_out" target="main">质检报告查询</a></li>
           <li><a href="controller/otherAid/addQualityControl.jsp" class="tow_m_out" target="main">添加质检报告</a></li>
   	   </ul>
   	   
   	   
      <a href="javascript:onClick=viewChild('child_18')" class="one_m_out">其他辅助功能</a>
      <ul id="child_18" style="display:none">
        <li><a href="otherAid/skipToImportRateData.action" class="tow_m_out" target="main">导入运价数据</a></li>
        <li><a href="otherAid/phoneStats.action" class="tow_m_out" target="main">拨打电话次数统计</a></li>
        <li><a href="controller/userManager/update.jsp" class="tow_m_out" target="main">修改管理员密码</a></li>
         <%--<li><a href="otherAid/searchQualityControl.action" class="tow_m_out" target="main">质检报告查询</a></li>
        <li><a href="controller/otherAid/addQualityControl.jsp" class="tow_m_out" target="main">添加质检报告</a></li>
       
        <li><a href="controller/otherAid/importAreaData.jsp" class="tow_m_out" target="main">导入地区数据</a></li>
        <li><a href="controller/otherAid/importStationData.jsp" class="tow_m_out" target="main">导入站台数据</a></li>
        <li><a href="controller/otherAid/importPlacdData.jsp" class="tow_m_out" target="main">导入交货地数据</a></li>
        --%>
      </ul>
    </div>
  </div>
</div>
  </body>
</html>