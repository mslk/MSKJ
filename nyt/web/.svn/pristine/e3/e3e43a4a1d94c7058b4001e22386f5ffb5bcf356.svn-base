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

		<title>导入地区数据</title>
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
		<form  id="form1" action="otherAid/importAreaData.action"  method="post" enctype="multipart/form-data">
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box">
							导入地区数据
						</div>
					</td>
				</tr>
				<tr>
					<td>
						数据来源:
					</td>
					<td>
						<input type="file" id="file" name="file"  readonly="true"/>
						<div id="fileTip"  style="display:inline-block;vertical-align:2px;"></div>
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
						<div id="demo1" class="demo">
							<table border="1">
								<tr>
									<td>省份</td>
									<td>城市</td>
									<td>区县</td>
								</tr>
								<tr>
									<td>天津市</td>
									<td>天津市</td>
									<td>汉沽区</td>
								</tr>
								<tr>
									<td>河北省</td>
									<td>石家庄市</td>
									<td>平山县</td>
								</tr>
								<tr>
									<td>内蒙古</td>
									<td>赤峰市</td>
									<td>巴林右旗</td>
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
