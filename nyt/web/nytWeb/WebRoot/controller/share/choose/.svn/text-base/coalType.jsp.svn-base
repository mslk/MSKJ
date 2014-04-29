<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<html>
  <head>
    <title>煤种列表</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/chooseStyle.css">
    <script type="text/javascript" src="js/jquery1.6.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
    <script type="text/javascript">
     function toPage(i){
    	 if(i)
    	 {
    		 chooseCoalType(i); 
    	 }
     }
     
     function goPage(obj){
 		//var gotoPage = document.getElementById("gotoPage");
 		var gotoPage =$(obj).prev();
 		if(isNumber($(gotoPage).val())){
 			chooseCoalType($(gotoPage).val()); 
 		}else{
 			alert("请输入正整数！");
 		}
    }
     
  
    </script>
  </head>
  
  <body> 
<table width="90%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td colspan="2" class="thead">
     <div class="tit_box">煤种列表</div>
    </td>
    <td colspan="2" class="thead">
     <input type="button" value="清除" onclick="clearCoalType()" />
     <input type="button" value="取消" onclick="unLock()" />
    </td>
  </tr>
  <tr>
  <c:forEach items="${request.result.queryList}" var="coaltype"  varStatus="coal">
  <td><a href="javascript:checkCoalType(${coaltype.id },'${coaltype.coalName }');"  >${coaltype.coalName }</a></td>
  <c:if test="${coal.index%4==3 }"></tr><tr></c:if>
  </c:forEach>
  
  </tr>
  <tr>
    <td colspan="4">
    <form action="choose/controller.action?type=1"  id="paginationAction" method="post">
    <c:import url="/controller/share/fenye.jsp"></c:import>
    </form>
    </td>
  </tr>
</table>
  </body>
</html>
