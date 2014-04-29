<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>后台管理登陆页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script>
		if(self!=top){
		window.parent.document.location.href = document.location.href;
		}
	</script>	
	<style type="text/css">
	body{font-size:12px; font-family:"宋体";  margin:0; padding:0}
	img{border:0}
	.inputs{ height:24px; line-height:24px; font-size:14px; font-family:Arial; padding:0 3px}
	
	#l_001{width:1000px; margin:0 auto; height:324px;overflow:hidden; clear:both}
	#l_002{width:1000px; margin:0 auto; clear:both}
	#l_002 .l_002_01{width:263px; height:121px; padding:15px 0; padding-left:306px; float:left; overflow:hidden}
	#l_002 .l_002_01 .in_01{width:250px; height:26px; padding:8px 0; line-height:26px; float:left; clear:both}
	#l_002 .l_002_01 .in_01 div{padding-right:5px; float:left; font-size:14px; color:#FFF; font-weight:bold;}
	#l_002 .l_002_02{ width:132px; height:151px; float:left; overflow:hidden}
	#l_002 .l_002_03{ width:299px; height:151px; float:left; overflow:hidden}
	#l_003{width:1000px; margin:0 auto; height:293px; overflow:hidden; clear:both}
	</style>
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript">
	function loginCheck(){
		var username    = document.getElementById("username");
		var password    = document.getElementById("password");
		var checkNumber = document.getElementById("checkNumber");
		if(username==null || username.value==""){
			alert("用户名不能为空！")
			username.focus();
			return ;
		}else if(password==null || password.value==""){
			alert("密码不能为空！");
			password.focus();
			return ;
		}else if(checkNumber.value.toUpperCase().length <=0){
			alert("请输入验证码！");
			checkNumber.focus();
			return ;
		}else{
			document.forms[0].submit();
		}
	}

	


	function hotkey(eventobj){
        var _key;
        var _event;
        var nu = navigator.userAgent.toLowerCase();
        var webtype = /msie/.test(nu) ? "msie" : /mozilla/.test(nu) ? "gecko" : "opera";
        if(webtype=="msie" || webtype=="opera"){
                    _key = window.event.keyCode;
                    _event = window.event;
        }else{
                   _key = eventobj.which;
                   _event = eventobj;
        }
        if(_key == 13){
            //alert("您点击了enter 吧！！");
            loginCheck()
        }
	}
	function reloadImage(url){
		 document.loginForm.img1.src = url+"?id="+Math.random();
	}
document.onkeydown = hotkey;
	</script>
  </head>
<body class="indexbody">
<form name="loginForm" action="user/system_login.action" method="post">
<div id="l_001"></div>
<div id="l_002">
  <div class="l_002_01">
    <div class="in_01">
      <div>用户名：</div>
      <div><input id="username" name="username" type="text" class="inputs" size="22" value="" /></div>
    </div>
    <div class="in_01">
      <div>密&nbsp;&nbsp;码：</div>
      <div><input id="password" name="password" type="password" class="inputs" size="22" value="" /></div>
    </div>
    <div class="in_01">
      <div>验证码：</div>
      <div><input type="text" class="inputs" id="checkNumber" name="checkNumber" size="10" value=""/></div>
      <div>
      <a href="JavaScript:reloadImage('base/image.jsp');">
      <img border=0 src="base/image.jsp" name="img1"/>
      </a>
      </div>
    </div>
  </div>
  <div class="l_002_02"><a href="javascript:onClick=loginCheck()"></a></div>
  <div class="l_002_03"></div>
</div>
<div id="l_003"></div>
</form>
<%if(request.getAttribute("message")!=null)
{
%>
	<script language="javascript">
	alert('${message}');
	</script>
<%
}
%>
</body>
</html>