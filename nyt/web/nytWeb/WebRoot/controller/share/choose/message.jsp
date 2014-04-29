<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>提示消息</title>
<base href="<%=basePath%>">
</base>
</head>
<style type="text/css">
body,html { height:100%; overflow:hidden;}
body { background:#f5f5f5; font-size:16px; font-weight:bold; font-family:'microsoft yahei';}
.nodata { width:300px; height:200px; line-height:200px; text-align:center; position:absolute; left:50%; top:50%; margin:-163px 0 0 -153px;
	border:#fff solid 6px;
	border-radius:6px;-webkit-border-radius:6px;-moz-border-radius:6px;
	box-shadow:0 0 6px #ccc;-webkit-box-shadow:0 0 6px #ccc;-moz-box-shadow:0 0 6px #ccc;
	text-shadow:1px 1px 1px #fff;-webkit-text-shadow:1px 1px 1px #fff;-moz-text-shadow:1px 1px 1px #fff;
}
.nodata_btn { position:absolute; bottom:-60px; left:50%; margin-left:-40px;
 width:80px;height:25px; cursor:pointer; border:1px solid #BCBCBC; background:url(images/btn_bg.png) repeat-x;
	border-radius:3px;-moz-border-radius:3px;
	line-height:25px; font-size:12px; color:#333; font-weight:normal;
}
</style>
<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
<body>

<div class="nodata">${message}
<c:if test="${targetUrl!=null && targetUrl!='' }">
<a class="nodata_btn"  href="${targetUrl}" >确定</a>
</c:if>
</div>



</body>

</html>
