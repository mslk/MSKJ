<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<title>更新煤宝联客户端版本信息</title>
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
<script language="javascript" src="jquery-validate/DateTimeMask.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/validate.js"></script>

<script type="text/javascript" charset="UTF-8"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$.formValidator.initConfig({
			formID : "form1",
			theme : "Default",
			submitOnce : true,
			mode : 'AutoTip',
			wideword : true,
			onError : function(msg) {
			},
			inIframe : true
		});

		var list = [ new Entity({
			id : "version",
			name : "新版本",
			required : true,
			type : 3,
			minLen : 2,
			maxLen : 10
		}), new Entity({
			id : "downurl",
			name : "下载地址",
			required : true,
			type : 1,
			minLen : 5,
			maxLen : 200
		}), new Entity({
			id : "title",
			name : "提示标题",
			required : true,
			type : 1,
			minLen : 2,
			maxLen : 50
		}), new Entity({
			id : "desc",
			name : "更新描述",
			required : true,
			type : 1,
			minLen : 2,
			maxLen : 100
		}) ];
		validateBase(list);
	});
</script>
</head>

<body>
	<form id="form1" action="otherAid/version_update.action" method="post">
		<table class="publictable" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td colspan="2" class="thead">
					<div class="tit_box">客户端版本信息</div>
				</td>
			</tr>
			<tr>
				<td width="30%">类型:</td>
				<td width="70%"><c:choose>
						<c:when test="${param.type==1 }">android版本</c:when>
						<c:when test="${param.type==2 }">ios版本</c:when>
					</c:choose> <input type="hidden" name="type" value="${param.type}" /></td>
			</tr>
			<tr>
				<td width="30%">新版本号:(如：1.5 、2.1 等)</td>
				<td width="70%"><input type="text" id="version" name="version" />
				</td>
			</tr>
			<tr>
				<td width="30%">是否强制更新:</td>
				<td width="70%"><select name="isforce"
					<c:if test="${param.type==2 }">disabled="disabled"</c:if>>
						<option value="0">否</option>
						<option value="1">是</option>
				</select></td>
			</tr>
			<tr>
				<td width="30%">下载地址:</td>
				<td width="70%"><input type="text" id="downurl" name="downurl" />
				</td>
			</tr>
			<tr>
				<td width="30%">提示标题:</td>
				<td width="70%"><input type="text" id="title" name="title" /></td>
			</tr>
			<tr>
				<td width="30%">更新描述：</td>
				<td width="70%"><textarea name="desc" id="desc"></textarea> <br>
					<span id="descTip"></span></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="修改"
					<c:if test="${userInfo.type==100 }">disabled="disabled"</c:if> />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
