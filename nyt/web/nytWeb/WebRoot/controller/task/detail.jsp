<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

		<title>查看推送任务</title>
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
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="2" class="thead">
 <div class="tit_box">推送任务</div>
    </td>
  </tr>
	<tr>
		<td width="200">标题：</td>
		<td>${result.title}</td>
	</tr>
	<tr>
		<td>推送开始时间：</td>
		<td>
		<fmt:formatDate  value="${result.begintime}" type="both"/>
		
		</td>
	</tr>
	<tr>
		<td>推送结束时间：</td>
		<td>
		<fmt:formatDate  value="${result.endtime}" type="both"/>
		</td>
	</tr>
	<tr>
		<td>审核状态：</td>
		<td>
		<c:if test="${status ==1 }">
		待审核
		</c:if>
		<c:if test="${status ==2 }">
		审核通过
		</c:if>
		</td>
	</tr>
	<tr style="display:none">
					<td >
						发送对象:
					</td>
					<td >
					</td>
	</tr>
	<tr style="display:none">
					<td >
						追加类型:
					</td>
					<td >
					</td>
	</tr>
	<tr style="display:none">
					<td >
						追加号码:
					</td>
					<td >
					</td>
	</tr>
	<tr style="display:none">
					<td>
						图片链接:
					</td>
					<td>
					</td>
	</tr>
	<tr>
					<td>
						通知描述:
					</td>
					<td>
					${result.sysdescription}
					</td>
	</tr>
	<tr>
					<td  colspan="2" style="text-align: center;">
					<c:if test="${status ==1 }">
	                  <a class="bts_link" href="pushTask/task_updateAudit.action?id=${result.id}">审核通过 </a>
		            </c:if>
					
					</td>
	</tr>
	<c:if test="${status !=1 }">
	<tr>
					<td  colspan="2" style="text-align: center;">
	                   <a class="bts_link"  target="main" href="pushTask/taskSearch_searchList.action?status=2">返回审核通过列表 </a>
					</td>
	</tr>
	 </c:if>
</table>
<!-- 阿斯顿发斯蒂芬 -->

	</body>
</html>
