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

		<title>导入站台数据</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
		<script src="js/jquery1.6.js" type="text/javascript"></script>
		
	</head>

	<body>
		<form  id="form1" action="pushTask/task_add.action"  method="post">
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box">
							导入站台数据
						</div>
					</td>
				</tr>
				<tr>
					<td>
						数据来源:
					</td>
					<td>
						<input type="file" id="beginTime" name="beginTime"  readonly="true"/>
						<div id="beginTimeTip"  style="display:inline-block;vertical-align:2px;"></div>
					</td>
				</tr>
				<tr>
					<tr>
					<td colspan="2">
						数据格式:
					</td>
				</tr>
				</tr>
				<tr>
					<td colspan="2">
						
						<div id="demo2" class="demo">
							<table border="1">
								<tr>
									<td>省份</td>
									<td>城市</td>
									<td>区县</td>
									<td>站台</td>
								</tr>
								<tr>
									<td>北京市</td>
									<td>北京市</td>
									<td>石景山区</td>
									<td>石景山南</td>
								</tr>
								<tr>
									<td>河北省</td>
									<td>张家口市</td>
									<td>怀来县</td>
									<td>沙城</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align:center" colspan="2">
						<input type="submit" value="运行"  />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
