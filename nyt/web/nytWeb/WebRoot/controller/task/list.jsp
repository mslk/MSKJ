<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>The Coolest DHTML Calendar - Online Demo</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script id="themeScript" type="text/javascript" src="js/theme.js"></script>
	<script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
</head>
<body>
<form action="pushTask/taskSearch_searchList.action" >
<input type="hidden" name="status" value="${status }"/>
<table class="publictable" width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="6" class="thead">
 <div class="tit_box">推送任务列表</div>
    </td>
  </tr>
	<tr>
  		<td>标题</td>
  		<td>推送开始时间</td>
  		<td>推送结束时间</td>
  		<!-- <td>推送类型</td> -->
  		<td>审核状态</td>
  		<td>添加时间</td>
  		<td>相关操作</td>
  	</tr>
<c:forEach items="${request.result.queryList}" var="task" >
	<tr>
		<td>
		${task.title }
		</td>
		<td>
		<fmt:formatDate  value="${task.begintime}" type="both"/>
		</td>
		<td>
			<fmt:formatDate  value="${task.endtime}" type="both"/>
		</td>
		<td>
		<c:if test="${status ==1 }">
		待审核
		</c:if>
		<c:if test="${status ==2 }">
		审核通过
		</c:if>
		</td>
	    <td>
	    <fmt:formatDate  value="${task.addtime}" type="both"/>
	    </td>
	    <td>
	     <a class="bts_link"  href="pushTask/taskSearch_detail.action?taskId=${task.id}&status=${status}">查看</a>  
	     <c:if test="${status ==1 }">
	     <a class="bts_link" target="_blank" href="pushTask/taskSearch_detail.action?taskId=${task.id}&type=2">修改 </a>  
	     <a class="bts_link"  href="javascript:delTips(null,'pushTask/task_delete.action?id=${task.id}');" >删除</a>
	     </c:if>  
	    </td>
	</tr>
</c:forEach>

	<tr>
  		<td colspan="6">
           <c:import url="/controller/share/fenye.jsp"></c:import>
  		</td>
  	</tr>
   </table>
</form>
</body>
</html>