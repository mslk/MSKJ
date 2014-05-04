<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
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

		<title>导入运价数据</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
		<script src="js/jquery1.6.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(document).ready(function(){
		
			$("#type").click(function()
			{  
			 	var index = $("#type").val();
				$(".demo").hide();
			 	$("#demo"+index).show();
			});    
		    $("#type").click();
		    
		    $("form").submit(function()
			{  
			 	 if(!$("#file").val()){
			 		alert("请先选择要导入数据的excel文件！"); 
			 		return false;
			 	 }
			}); 
			
		});
		
		</script>
		
	</head>

	<body>
		<form  id="form1" action="otherAid/importRateData.action"  method="post" enctype="multipart/form-data">
			<table class="publictable" width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td colspan="2" class="thead">
						<div class="tit_box">
							导入运价数据
						</div>
					</td>
				</tr>
				<tr>
					<td width="30%">
						数据类型:
					</td>
					<td width="70%"  >
						<select name="type" id="type">
							<option value="1">公路运价</option>
							<%--<option value="0">铁路运价</option>
						--%></select>
					</td>
				</tr>
				<tr>
					<td>
						数据excel文件:
					</td>
					<td>
						<input type="file" id="file" name="file"  readonly="true"/>
						<div id="fileTip"  style="display:inline-block;vertical-align:2px;"></div>
					</td>
				</tr>
				<tr>
					<td>
						导入规则:
					</td>
					<td>
						如果导入excel中的始发地不是数据库中已有的交货地，到达地不是数据库中已有的收货地，该条数据导入失败，请确保excel与数据库中的省市县名称一致，新的地区请先用后台添加。
					</td>
				</tr>
				<tr>
					<td colspan="2">
						excel文件数据格式:
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div>
							<font color="red">备注：数据excel文件第一行留做标题；已有数据自动覆盖；新数据验证通过后添加，否则返回提示。</font>
						</div>
						<div id="demo0" class="demo">
							<table border="1">
								<tr>
									<td>始发站</td>
									<td>始发站城市</td>
									<td>始发站省份</td>
									<td>到达站</td>
									<td>到达站城市</td>
									<td>到达站省份</td>
									<td>吨运费</td>
									<td>公里数</td>
								</tr>
								<tr>
									<td>牛家梁站</td>
									<td>榆林地区</td>
									<td>陕西省</td>
									<td>兵马营</td>
									<td>北京市</td>
									<td>北京市</td>
									<td>168.285</td>
									<td>1098</td>
								</tr>
							</table>
						</div>
						<div id="demo1" class="demo">
							<table border="1">
								<tr>
									<td>始发地</td>
									<td>始发地城市</td>
									<td>始发地省份</td>
									<td>到达地</td>
									<td>到达地城市</td>
									<td>到达地省份</td>
									<td>吨运费</td>
									<td>公里数</td>
								</tr>
								<tr>
									<td>榆阳区</td>
									<td>榆林地区</td>
									<td>陕西省</td>
									<td>东城区</td>
									<td>北京市</td>
									<td>北京市</td>
									<td>310</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</div>
						<div>
						<%--<font color="red">
							<c:if test="${request.result!=null}">错误的数据，总数：${request.errNums},行数：</c:if>
							<c:forEach items="${request.result}" var="row" varStatus="status">
								<c:out value="${row}"/> 
								<c:out value="${status.current}"/> 当前对象
								<c:out value="${status.index}"/> 此次迭代的索引
								<c:out value="${status.count}"/> 已经迭代的数量
								<c:out value="${status.first}"/> 是否是第一个迭代对象
								<c:out value="${status.last}"/> 是否是最后一个迭代对象
							    <c:if test="${status.last == false}">,</c:if>
							</c:forEach>
						</font>
						--%></div>
					</td>
				</tr>
				<tr>
					<td style="text-align:center" colspan="2">
						<input type="submit"  value="上传"  />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
