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
		<script type="text/javascript" src="js/validate.js"></script>
		<script type="text/javascript" src="js/jquery1.6.js"></script>
		<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidator-4.1.3.js"></script>
		<script type="text/javascript" charset="UTF-8"
			src="jquery-validate/formValidatorRegex.js"></script>
			
		<script type="text/javascript" charset="UTF-8"
			src="js/My97DatePicker/WdatePicker.js"></script>
			
		<script type="text/javascript">
		$(document).ready(function(){
		    $.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,mode:'AutoTip',wideword:true,onError:function(msg){},inIframe:true});
		    

			var list=[  
			
			 new Entity({id:"custom",name:"自定义",required:true,type:100,myValidate:function(){
			        var v=$("#custom").val();
			        if(v){
			        return true;
			        }else
			        {
			        return false;
			        } 
			     }}),
			new Entity({id:"username",name:"用户名",required:true}),
			new Entity({id:"password1",name:"密码",required:true,type:17}),
			new Entity({id:"password2",name:"密码",required:true,type:17,compareId:'password1'}),
			new Entity({id:"username2",name:"别名",required:true}),
			new Entity({id:"sex",name:"性别",required:true,type:14}),
			new Entity({id:"xqah_one",name:"兴趣爱好",required:true,type:15}),
			new Entity({id:"xueli",name:"学历",required:true,type:16}),
			new Entity({id:"begindate",name:"开始日期",required:true,type:18}),
			new Entity({id:"enddate",name:"结束日期",required:true,type:19,compareId:"begindate"}),
			new Entity({id:"mobile",name:"手机号码",required:true,type:5}),
			new Entity({id:"telephone",name:"电话号码",required:true,type:6}),
		    new Entity({id:"idcard",name:"身份证",required:true,type:7}),
		    new Entity({id:"email",name:"邮箱",required:true,type:4}),
		    new Entity({id:"integer",name:"整数",required:true,type:2}),
		    new Entity({id:"decmal",name:"浮点数",required:true,type:3}),
		    new Entity({id:"zipcode",name:"邮编",required:true,type:8}), 
		    new Entity({id:"letter",name:"字母",required:true,type:9}),
		    new Entity({id:"positiveinteger",name:"正整数",required:true,type:10}),
		    new Entity({id:"negetiveinteger",name:"负整数",required:true,type:11}),
		    new Entity({id:"positiveDecmal",name:"正浮点数",required:true,type:12}),
		    new Entity({id:"negetiveDecmal",name:"负浮点数",required:true,type:13})
			     ];
			     
			     
		    validateBase(list);		
		    
		   
		  
		    
		});
		</script>
	</head>

	<body>
		<form id="form1" action="demo/manager_add2.action" method="post">
			<table  class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box"> 
							新增管理员 
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%">
						自定义:
					</td>
					<td >
						<input type="text" id="custom" name="custom" value="" />
					</td>
				</tr>
				<tr>
					<td width="20%">
						用户名:
					</td>
					<td >
						<input type="text" id="username" name="username" value="" />
					</td>
				</tr>
				<tr>
					<td >
						别名:
					</td>
					<td >
						<input type="text" id="username2" name="username2" value=""
							 />
					</td>
				</tr>
				<tr>
					<td >
						开始日期:
					</td>
					<td >
					
						<input type="text" id="begindate" name="begindate" value="" readonly="readonly"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						<input type="button" value="选择日期" onclick="WdatePicker({el:'begindate',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                        <div id="begindateTip"  style="display:inline-block;vertical-align:2px;"></div>
					</td>
				</tr>
				<tr>
					<td >
						结束日期:
					</td>
					<td >
					
						<input type="text" id="enddate" name="enddate" value="" readonly="readonly"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						<input type="button" value="选择日期" onclick="WdatePicker({el:'enddate',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                        <div id="enddateTip"   style="display:inline-block;vertical-align:2px;"></div>
					</td>
				</tr>
				<tr>
					<td >
						性别:
					</td>
					<td >
						<input type="radio"  name="sex" value="1" />男
						<input type="radio"  name="sex" value="0" />女
						<div id="sexTip"  style="display:inline-block;vertical-align:2px;"></div>
					</td>
				</tr>
				<tr> 
      <td align="right">兴趣爱好1:</td>
      <td colspan="2"> <input type="checkbox" name="xqah_one" id="qq1"/>
        乒乓球 
        <input type="checkbox" name="xqah_one" id="qq2" value="1" />
        羽毛球 
        <input type="checkbox" name="xqah_one" id="qq3" value="2" />
        上网 
        <input type="checkbox" name="xqah_one" id="qq4" value="3" />
        旅游 
        <input type="checkbox" name="xqah_one" id="qq5" value="4" />
        购物 
        <div id="xqah_oneTip"  style="display:inline-block;vertical-align:2px;"></div>
        </td>
    </tr>
				<tr>
					<td >
						学历:
					</td>
					<td >
					<select name="xueli" id="xueli">
					  <option value="">－－请选择你的学历－－</option>
					  <option value="a">专科</option>
					  <option value="b">本科</option>
					  <option value="c">研究生</option>
					  <option value="e">硕士</option>
					  <option value="d">博士</option>
					</select> 
					</td>
				</tr>
				<tr>
					<td >
						密码:
					</td>
					<td >
						<input type="password" id="password1" name="password"/>
					</td>
				</tr>
				<tr>
					<td >
						确认密码:
					</td>
					<td >
						<input type="password" id="password2" name="password2" />
					</td>
				</tr>
				<tr>
					<td >
						手机号码
					</td>
					<td >
						<input type="text" id="mobile" name="mobile"  />
					</td>
				</tr>
				<tr>
					<td >
						电话号码
					</td>
					<td >
						<input type="text" id="telephone" name="telephone"
							 />
					</td>
				</tr>
				<tr>
					<td >
						身份证
					</td>
					<td >
						<input type="text" id="idcard" name="idcard"  />
					</td>
				</tr>
				<tr>
					<td >
						邮箱
					</td>
					<td >
						<input type="text" id="email" name="email"  />
					</td>
				</tr>
				<tr>
					<td >
						郵編
					</td>
					<td >
						<input type="text" id="zipcode" name="zipcode"  />
					</td>
				</tr>
				
				<tr>
					<td >
						字母
					</td>
					<td >
						<input type="text" id="letter" name="letter" />
					</td>
				</tr>
				<tr>
					<td >
						整数
					</td>
					<td >
						<input type="text" id="integer" name="integer"
							 />
					</td>
				</tr>
				<tr>
					<td >
						正整数
					</td>
					<td >
						<input type="text" id="positiveinteger" name="positiveinteger"
							 />
					</td>
				</tr>
				<tr>
					<td >
						负整数
					</td>
					<td >
						<input type="text" id="negetiveinteger" name="negetiveinteger"
							 />
					</td>
				</tr>
				<tr>
					<td >
						浮点数
					</td>
					<td >
						<input type="text" id="decmal" name="decmal"
							 />
					</td>
				</tr>
				<tr>
					<td >
						正浮点数
					</td>
					<td >
						<input type="text" id="positiveDecmal" name="positiveDecmal"
							 />
					</td>
				</tr>
				<tr>
					<td >
						负浮点数
					</td>
					<td >
						<input type="text" id="negetiveDecmal" name="negetiveDecmal"
							 />
					</td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: center">
						<input type="submit" name="button" id="button" value="提交" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
