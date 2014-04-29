<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'advertising.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		h1{text-align: center}
		ul{list-style-type: upper-roman}
		li ul{list-style-type: lower-roman}
		div ul{list-style-type: decimal}
		div{border: 1px solid #696969 }
		img.width{width: 100%}
	</style>
  </head>
  
  <body>
  <h1>煤宝联管理后台使用说明</h1>
  <ul>
  <%--<li><a href="controller/share/advertising.jsp#push">推送任务管理</a></li>
  <li><a href="controller/share/advertising.jsp#coalsize">粒度管理</a></li>
  --%><li><a href="controller/share/advertising.jsp#user">客户端用户黑名单功能</a></li>
  <li><a href="controller/share/advertising.jsp#sort">供求信息人工置顶功能</a></li>
  <li><a href="controller/share/advertising.jsp#delivery">交货地管理</a></li>
  <li><a href="controller/share/advertising.jsp#receive">地区(收货地)管理</a></li>
  <li><a href="controller/share/advertising.jsp#otheraid">其他功能辅助</a>
  	<ul>
  		<li><a href="controller/share/advertising.jsp#rate">导入运价数据</a></li>
  		<li><a href="controller/share/advertising.jsp#upfile">图片上传</a></li>
  		<li><a href="controller/share/advertising.jsp#helpcenter">帮助信息管理</a></li>
  	</ul>
  </li>
  <%--<li><a href="controller/share/advertising.jsp#other">其他模块</a></li>
  --%></ul>
<%--<h3 id="push">推送任务管理</h3>
<div>暂无描述</div>
<h3 id="coalsize">粒度管理</h3>
<div>暂无描述</div>
--%><h3 id="user">客户端用户黑名单功能</h3>
<div>
	<ul>
		<%--<li>进入客户端用户列表</li><img class="width" src="images/home/user1.jpg" />
		--%><li>点击“拉入黑名单”将用户设为黑名单状态</li><img class="width" src="images/home/user2.jpg" />
		<%--<li>点击“确定”提交</li><img class="width" src="images/home/user3.jpg" />
		<li>操作结果提示</li><img class="width" src="images/home/user4.jpg" />
		--%><li>点击“恢复”将用户恢复为有效状态</li><img class="width" src="images/home/user5.jpg" />
		<%--<li>点击“确定”提交</li><img class="width" src="images/home/user6.jpg" />
		<li>操作结果提示</li><img class="width" src="images/home/user7.jpg" />
		--%><li>已经恢复状态</li><img class="width" src="images/home/user8.jpg" />
	</ul>
</div>
<h3 id="sort">供求信息人工置顶功能</h3>
<div><p>排序值，人工干预信息在客户端/后台列表默认排序时的展示，值越大，信息越排前。</p>
<img class="width" src="images/home/sort1.jpg" />
</div>
<h3 id="delivery">交货地管理</h3>

<div>
	<p>交货地有交货地地区与下层交货地（如煤矿）两大块，其中交货地地区只能在地区管理中添加，而下层交货地（如煤矿）在选定的交货地地区下添加。</p>
	<ul>
		<li>在交货地地区列表中，选择地区，点击“添加地区下交货地”进入添加煤矿（或其它已有的交货地类型）页面</li><img class="width" src="images/home/delivery1.jpg" />
		<li>点击“修改”可进入修改页面，修改交货地信息</li><img class="width" src="images/home/delivery2.jpg" />
	</ul>
</div>
<h3 id="receive">地区(收货地)管理</h3>

<div>
	<p>地区列表是全国省市县地区的集合，也是收货地信息，而交货地的地区只能从这些地区中选择，并添加到交货地地区。</p>
	<ul>
		<li>在添加地区信息（亦是收货地）时，可选择同步加入到交货地地区</li><img class="height" src="images/home/recieve1.jpg" />
		<li>在地区列表中，点击“加入交货地”，可将此地区信息加入交货地地区中</li><img class="width" src="images/home/recieve2.jpg" />
		<li>交货地地区从地区管理添加</li><img class="width" src="images/home/recieve3.jpg" />
	</ul>
</div>
<h3 id="otheraid">其他功能辅助</h3>
<div>
<h5 id="rate">导入运价数据</h5> 
<p>请看导入运价页面的“导入规则”与“excel文件数据格式”说明。</p>
<h5 id="upfile">图片上传</h5>
<p>本功能是配合帮助信息管理，提供其所需图片的服务器端保存地址。</p>
<h5 id="helpcenter">帮助信息管理</h5>
<p>“类型”为此信息归属那个帮助模块，内容需以html网页来记录，内容若包含图片，请先用“图片上传”模块上传好，将反馈的图片地址按网页模版添加到内容网页中。查看网页模版，请点击“查看”按钮。</p>
<img class="height" src="images/home/help1.jpg" />
</div>
<%--<h3 id="other">其他模块</h3>
<div>暂无描述</div>

  --%></body>
</html>
