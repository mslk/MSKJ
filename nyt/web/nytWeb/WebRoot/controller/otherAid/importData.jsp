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

		<title>批量导入数据</title>
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
		
			$("#type").click(function()
			{  
			 	var index = $("#type").val();
				$(".demo").hide();
			 	$("#demo"+index).show();
			});    
		    $("#type").click();
			
		});
		
		</script>
		
	</head>

	<body>
		<form  id="form1" action="pushTask/task_add.action"  method="post">
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box">
							批量导入数据
						</div>
					</td>
				</tr>
				<tr>
					<td width="30%">
						数据类型:
					</td>
					<td width="70%"  >
						<select name="type" id="type">
							<option value="1">地区信息</option>
							<option value="2">站台信息</option>
							<option value="3">交货地信息</option>
							<option value="4">运价信息</option>
						</select>
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
					<td>
					</td>
					<td align="center">
						<input type="submit" value="运行"  />
					</td>
				</tr>
				<tr>
					<td>
						数据格式:
					</td>
					<td>
						<div id="demo1" class="demo">
							<table border="1">
								<tr>
									<td>省份名称</td>
									<td>城市名称</td>
									<td>区县名称</td>
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
						<div id="demo2" class="demo">
							<table border="1">
								<tr>
									<td>省份名称</td>
									<td>城市名称</td>
									<td>区县名称</td>
									<td>站台名称</td>
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
						<div id="demo3" class="demo">
							<table border="1">
								<tr>
									<td>省份名称</td>
									<td>城市名称</td>
									<td>区县名称</td>
									<td>交货地名称</td>
								</tr>
								
							</table>
						</div>
						<div id="demo4" class="demo">
							<table border="1">
								<tr>
									<td>起始站城市名称</td>
									<td>起始站名称</td>
									<td>目的站城市名称</td>
									<td>目的站名称</td>
									<td>运价</td>
									<td>路程</td>
								</tr>
							</table>
						</div>
						
							
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
