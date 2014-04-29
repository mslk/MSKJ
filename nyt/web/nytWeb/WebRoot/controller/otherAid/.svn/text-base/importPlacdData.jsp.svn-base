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

		<title>导入交货地数据</title>
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
							导入交货地数据
						</div>
					</td>
				</tr>
				<tr>
					<td width="30%">
						数据类型:
					</td>
					<td width="70%"  >
						<select name="type" id="type">
							<option value="1">煤矿</option>
							<option value="2">站台</option>
							<option value="3">煤场</option>
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
					<td colspan="2">
						数据格式:
					</td>
				</tr>
				<tr>
					
					<td colspan="2">
						<div id="demo1" class="demo">
							<table border="1">
								<tr>
									<td>省份</td>
									<td>城市</td>
									<td>区县</td>
									<td>煤矿</td>
									<td>发热量</td>
									<td>硫分</td>
									<td>灰分</td>
									<td>全水</td>
								</tr>
								<tr>
									<td>陕西省</td>
									<td>榆林市</td>
									<td>榆阳区</td>
									<td>十八墩煤矿</td>
									<td>6800</td>
									<td>2</td>
									<td>2</td>
									<td>10</td>
								</tr>
							</table>
						</div>
						<div id="demo2" class="demo">
							<table border="1">
								<tr>
									<td>省份</td>
									<td>城市</td>
									<td>区县</td>
									<td>站台</td>
								</tr>
								<tr>
									<td>陕西省</td>
									<td>榆林市</td>
									<td>榆阳区</td>
									<td>牛家梁站</td>
								</tr>
							</table>
						</div>
						<div id="demo3" class="demo">
							<table border="1">
								<tr>
									<td>省份</td>
									<td>城市</td>
									<td>区县</td>
									<td>煤场</td>
								</tr>
								<tr>
									<td>陕西省</td>
									<td>榆林市</td>
									<td>神木县</td>
									<td>海红洗煤厂</td>
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
