<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'MyJsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
		<script src="js/jquery1.6.js" type="text/javascript"></script>
		<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidator-4.1.3.js"></script>
		<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidatorRegex.js"></script>
		<script language="javascript" src="jquery-validate/DateTimeMask.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/validate.js"></script>
			
		<script type="text/javascript" charset="UTF-8"
			src="js/My97DatePicker/WdatePicker.js"></script>	
		<script type="text/javascript">
		$(document).ready(function(){
		
		
	
		
		
		   
		    $.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});
		    
		 // $.formValidator.initConfig({formID:"form1",theme:'ArrowSolidBox',mode:'AutoTip',onError:function(msg){alert(msg)},inIframe:true});
		    
		    
		//	$("#username").formValidator({onShow:"请输入用户名",onFocus:"至少2个长度",onCorrect:"用户名"}).inputValidator({min:2,empty:{leftEmpty:false,rightEmpty:false,emptyError:"用户名两边不能有空符号"},onError:"用户名不能为空,请确认"});
		//	$("#password").formValidator({onShow:"请输入密码",onFocus:"至少1个长度",onCorrect:"密码合法"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码不能为空,请确认"});
		//	$("#confirmPassword").formValidator({onShow:"请输入密码",onFocus:"至少1个长度",onCorrect:"密码合法"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码不能为空,请确认"});
			
		//	   $.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});
		//$.formValidator.initConfig({formID:"form1",theme:'ArrowSolidBox',mode:'AutoTip',onError:function(msg){alert(msg)},inIframe:true});	
			var list=[  
			
			new Entity({id:"username",name:"用户名",required:true}),
			new Entity({id:"password",name:"密码1",required:true}),
			new Entity({id:"begindate",name:"开始日期",required:true,type:18}),
			new Entity({id:"enddate",name:"结束日期",required:true,type:19,compareId:"begindate"}),
		    new Entity({id:"demo.sex",name:"性别",required:true,type:14}),
		    new Entity({id:"demo.xqah_one",name:"兴趣爱好",required:true,type:15}),
		    new Entity({id:"xueli",name:"学历",required:true,type:16}) ,
		   new Entity({id:"mobile",name:"手机号码",required:false,type:5})
			     ];
			  
			  
	//onclick=""
		
		$("#begindateBt").click(function()
		{  
		   WdatePicker({el:'begindate',dateFmt:'yyyy-MM-dd HH:mm:ss'});
		});    
		$("#enddateBt").click(function()
		{  
		   WdatePicker({el:'enddate',dateFmt:'yyyy-MM-dd HH:mm:ss'});
		});    
		 
	      //$(":radio[name='demo.sex']").formValidator({empty:false,tipID:"sexTip",onShow:"请选择",onFocus:"请选择"+obj.name,onCorrect:"选择正确"}).inputValidator({min:1,max:1,onError:"请确认选择"}); 
		    validateBase(list);
			
		});
		</script>
		
	</head>

	<body>
		<form  id="form1" action="demo/manager_add1.action"  method="post">
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="3" class="thead">
						<div class="tit_box">
							新增管理员
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%">
						用户名:
					</td>
					<td width="30%"  >
						<input type="text" id="username" name="demo.username"  value="11111"  />
					</td>
                    <td width="40%"><div class="tipsbox"><div id="usernameTip"></div></div></td>
				</tr>
				<tr>
					<td>
						密码:
					</td>
					<td>
						<input type="password" id="password" name="demo.pwd1"
							style="width: 150px"  />
					</td>
                    <td><div class="tipsbox"><div id="passwordTip"></div></div></td>
				</tr>
				<tr>
					<td>
						确认密码:
					</td>
					<td>
						<input type="password" id="confirmPassword" name="demo.pwd2"
							style="width: 150px" />
					</td>
                    <td><div class="tipsbox"><div id="confirmPasswordTip"></div></div></td>
				</tr>
				<tr>
					<td >
						开始日期:
					</td>
					<td >
					
						<input type="text" id="begindate" name="demo.begindate"  readonly="readonly"
							 />
						<input type="button" value="选择日期"  id="begindateBt"/>
					</td>
					<td><div class="tipsbox"><div id="begindateTip"  style="display:inline-block;vertical-align:2px;"></div></div></td>
				</tr>
				<tr>
					<td >
						结束日期:
					</td>
					<td >
					
						<input type="text" id="enddate" name="demo.enddate"  readonly="readonly"
							 />
						<input type="button" value="选择日期"  id="enddateBt"/>
                        
					</td>
					<td><div class="tipsbox"><div id="enddateTip"   style="display:inline-block;vertical-align:2px;"></div></div></td>
				</tr>
				<tr>
					<td >
						性别:
					</td>
					<td >
						<input type="radio"  name="demo.sex" value="1" />男
						<input type="radio"  name="demo.sex" value="2" />女
						
					</td>
					<td><div class="tipsbox"><div id="sexTip"  style="display:inline-block;vertical-align:2px;"></div></div></td>
				</tr>
				<tr> 
      <td align="right">兴趣爱好1:</td>
      <td > <input type="checkbox" name="demo.xqah_one" id="qq1"/>
        乒乓球 
        <input type="checkbox" name="demo.xqah_one" id="qq2" value="1" />
        羽毛球 
        <input type="checkbox" name="demo.xqah_one" id="qq3" value="2" />
        上网  
        <input type="checkbox" name="demo.xqah_one" id="qq4" value="3" />
        旅游 
        <input type="checkbox" name="demo.xqah_one" id="qq5" value="4" />
        购物 
      
        </td>
        <td><div class="tipsbox"> <div id="xqah_oneTip"  style="display:inline-block;vertical-align:2px;"></div></div></td>
        
    </tr>
				<tr>
					<td >
						学历:
					</td>
					<td >
					<select name="demo.xueli" id="xueli">
					  <option value="">－－请选择你的学历－－</option>
					  <option value="a">专科</option>
					  <option value="b">本科</option>
					  <option value="c">研究生</option>
					  <option value="e">硕士</option>
					  <option value="d">博士</option>
					</select> 
					</td>
					<td><div class="tipsbox"><div id="xueliTip"  style="display:inline-block;vertical-align:2px;"></div></div></td>
				</tr>
				<tr>
					<td>
						手机号码
					</td>
					<td>
						<input type="text" id="mobile" name="mobile" style="width: 150px" />
					</td>
                    <td><div class="tipsbox"><div id="mobileTip"></div></div></td>
				</tr>
				<tr>
					<td>
						电话号码
					</td>
					<td>
						<input type="text" id="temphone" name="temphone"
							style="width: 150px" />
					</td>
                    <td><div class="tipsbox"><div id="temphoneTip"></div></div></td>
				</tr>
				<tr>
					<td>
						电话号码
					</td>
					<td>
						<input type="text" id="temphone" name="temphone"
							style="width: 150px" />
					</td>
                    <td><div class="tipsbox"><div id="temphoneTip"></div></div></td>
				</tr>
				<tr>
					<td>
						身份证
					</td>
					<td>
						<input type="text" id="sfz" name="sfz" style="width: 150px" />
					</td>
                    <td><div class="tipsbox"><div id="sfzTip"></div></div></td>
				</tr>
				<tr>
					<td>
						邮箱
					</td>
					<td>
						<input type="text" id="email" name="email" style="width: 150px" />
					</td>
                    <td><div class="tipsbox"><div id="emailTip"></div></div></td>
				</tr>
				<tr>
					<td>
						整数
					</td>
					<td>
						<input type="text" id="zhenshu" name="zhenshu"
							style="width: 150px" />
					</td>
                    <td><div class="tipsbox"><div id="zhenshuTip"></div></div></td>
				</tr>
				<tr>
					<td>
						小数
					</td>
					<td>
						<input type="text" id="xiaoshu" name="xiaoshu"
							style="width: 150px" />
					</td>
                    <td><div class="tipsbox"><div id="xiaoshuTip"></div></div></td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center">
						  <input type="submit" name="button" id="button" value="提交" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
