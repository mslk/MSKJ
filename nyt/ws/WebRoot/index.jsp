<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>meibaolian webservice index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is meibaolian webservice index page. <br><br><br>
     <strong>用户相关</strong>
    <hr>
    <p>
    	<ul>
    		<li><a href="user.html#user0" target="_blank" >删除用户(供测试使用)</a></li>
    		<li><a href="user.html#user1" target="_blank" >短信验证码</a></li>
    		<li><a href="user.html#user2" target="_blank" >用户注册接口<font style="color:red">(停用)</font></a></li>
    		<li><a href="user.html#user3" target="_blank" >用户登录接口(含注册功能)</a></li>
    		<li><a href="user.html#user30" target="_blank" >完善用户信息接口</a></li>
    		<li><a href="user.html#user31" target="_blank" >用户修改密码接口</a></li>
    		<li><a href="user.html#user4" target="_blank" >点击号码统计接口</a></li>
    		<li><a href="user.html#user5" target="_blank" >修改用户信息接口</a></li>
    		<li><a href="user.html#user18" target="_blank" >用户投诉信息接口</a></li>
    		<li><a href="user.html#user6" target="_blank" >更新用户推送状态</a></li>
    		<li><a href="user.html#user7" target="_blank" >通用查询求购信息,供应信息详情</a></li>
    		<li><a href="user.html#user8" target="_blank" >通用查询车讯信息,货讯信息详情</a></li>
    	</ul>
    </p>
    
    <strong>我的好友</strong>
    <hr>
    <p>
    	<ul>
   		 	<li><a href="customer.html#add" target="_blank" >添加好友</a></li>
   		 	<li><a href="customer.html#del" target="_blank" >删除好友</a></li>
   		 	<li><a href="customer.html#get" target="_blank" >好友列表</a></li>
    	</ul>
    </p>
    
    <strong>我的收藏</strong>
    <hr>
    <p>
    	<ul>
   		 	<li><a href="collect.html#add" target="_blank" >收藏信息</a></li>
   		 	<li><a href="collect.html#del" target="_blank" >删除收藏信息</a></li>
   		 	<li><a href="collect.html#get" target="_blank" >收藏列表</a></li>
    	</ul>
    </p>
    
    <strong>辅助功能</strong>
    <hr>
    <ul>
            <li><a href="dict/advertising?type=1" target="_blank" >广告地址接口(ios)</a></li>
    	    <li><a href="dict/advertising?type=2" target="_blank" >广告地址接口（android）</a></li>
    	    <li><a href="dict/helpCenter?type=1" target="_blank" >帮助中心 （新闻）接口</a><font style="color:red">（修改）</font></li>
    	    <li><a href="dict/helpCenter?type=2" target="_blank" >帮助中心 （服务）接口</a><font style="color:red">（修改）</font></li>
    </ul>
    <strong>字典数据</strong>
    <hr>
    <p>
    	<ul>
    		<li><a href="dict/provinces" target="_blank" >省市接口</a></li>
    		<li><a href="station.html" target="_blank" >区县接口</a></li>
    		<li><a href="rate.html#rate1" target="_blank" >运价</a></li>
    		<li><a href="dirc/typeList" target="_blank" >桉木、淀粉、原木 下拉菜单数据</a></li>
    	</ul>
    </p>
    
    <strong>车讯相关</strong>
    <hr>
    <p>
    	<ul>
    	    <li><a href="transportSupply.html#form1" target="_blank" >关键字查询车讯</a></li>
    		<li><a href="transportSupply.html#form2" target="_blank" >发布车讯</a></li>
    		<li><a href="transportSupply.html#form6" target="_blank" >发布车讯后展示车讯列表</a></li>
    		<li><a href="transportSupply.html#form3" target="_blank" >获取已发布车讯</a></li>
    		<li><a href="transportSupply.html#form4" target="_blank" >删除已发布车讯</a></li>
    		<li><a href="transportSupply.html#form5" target="_blank" >重新发布车讯</a></li>
    		<li><a href="transportSupply.html#form7" target="_blank" >起止地查询车讯<font style="color:red">(新增)</font></a></li>
    	</ul>
    </p>
    
    <strong>货讯相关</strong>
    <hr>
    <p>
    	<ul>
    	    <li><a href="transportDemand.html#form1" target="_blank" >关键字查询货讯</a></li>
    		<li><a href="transportDemand.html#form2" target="_blank" >发布货讯</a></li>
    		<li><a href="transportDemand.html#form6" target="_blank" >发布货讯后展示货讯列表</a></li>
    		<li><a href="transportDemand.html#form3" target="_blank" >获取已发布货讯</a></li>
    		<li><a href="transportDemand.html#form4" target="_blank" >删除已发布货讯</a></li>
    		<li><a href="transportDemand.html#form5" target="_blank" >重新发布货讯</a></li>
    		<li><a href="transportDemand.html#form7" target="_blank" >起止地查询货讯<font style="color:red">(新增)</font></a></li>
    	</ul>
    </p>

    
     <strong>桉木信息</strong>
    <hr>
    <p>
    	<ul>
    	    <li><a href="Veneer.html#form1" target="_blank" >查询桉木供应信息</a></li>
    	    <li><a href="VeneerInfo.html#form1" target="_blank" >查询桉木求购信息可根据字段排序</a></li>
    		<li><a href="VeneerInfo.html#form2" target="_blank" >发布桉木信息</a></li>
    		<li><a href="VeneerInfo.html#form3" target="_blank" >根据输入值模糊查询桉木求购信息</a></li>
    		<li><a href="VeneerInfo.html#form4" target="_blank" >修改桉木信息</a></li>
    		<li><a href="VeneerInfo.html#form5" target="_blank" >根据用户id和类型查询用户的桉木求购或供应信息</a></li>
    		<li><a href="VeneerInfo.html#form6" target="_blank" >根据用户id和主键id删除桉木信息</a></li>
    	</ul>
    </p>
     
     
    <strong>胶合板、原木、淀粉</strong>
    <p>
    	<ul>
    	    <li><a href="supply.html#form1" target="_blank" >发布胶合板、原木、淀粉供应</a></li>
    	    <li><a href="supply.html#form10" target="_blank" >修改胶合板、原木、淀粉供应</a></li>
    	    <li><a href="supply.html#form4" target="_blank" >胶合板、原木、淀粉供应查询 </a></li>
    	    <li><a href="supply.html#form4" target="_blank" >个人胶合板、原木、淀粉供应查询 </a></li>
    	     <li><a href="supply.html#form9" target="_blank" >根据用户id和主键id删除胶合板 ， 原木 ，淀粉 供应信息 </a></li>
    	    <li><a href="purchase.html#form1" target="_blank" >发布胶合板、原木、淀粉求购</a></li>
    	    <li><a href="purchase.html#form10" target="_blank" >修改胶合板、原木、淀粉求购</a></li>
    	     <li><a href="purchase.html#form7" target="_blank" >胶合板、原木、淀粉求购查询 </a></li>
    	     <li><a href="purchase.html#form7" target="_blank" >个人胶合板、原木、淀粉求购查询 </a></li>
    	     <li><a href="purchase.html#form8" target="_blank" >根据用户id和主键id删除胶合板 ， 原木 ，淀粉 求购信息 </a></li>
    	</ul>
    </p>

  </body>
</html>
