<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>

<% 
//< s :iterator step="#result.rowDisplay.start"  end="#result.rowDisplay.stop" status="base" >
//   < s:if test="%{base.count!=result.currentlyPage }">
 //  < A href="javascript:toPage(%{base})">${base.count}</A> &nbsp;&nbsp;
 ////  < /s:if>
 // < s:elseif test="%{base.count==result.currentPage}"> ${base.count } &nbsp;&nbsp;</s:elseif>
//</ s:iterator>  

%>  
<div style="text-align:right; font-size:12px;">
    <c:if test="${result==null  }">1</c:if>
    <c:if test="${result!=null  }">
    当前第 <font color="#FF0000"><b>${result.currentlyPage }</b></font>页，每页<font color="#FF0000"><b>${result.pageSize }</b></font>条记录,总共<font color="#FF0000"><b>${result.totalRow}</b></font>条记录,共<font color="#FF0000"><b>${result.totalPage}</b></font>页&nbsp;
  
   
    
    <c:if test="${1==result.currentlyPage}">
         [首页]&nbsp;
    </c:if>  
    <c:if test="${1!=result.currentlyPage}">
     <A href="javascript:toPage(1);">[首页]</A>&nbsp;
     </c:if>  
    <c:forEach var="base" begin="${result.rowDisplay.start}"  end="${result.rowDisplay.stop}" >
       <c:if test="${base!=result.currentlyPage}">
       <A href="javascript:void(0);" class="fenye" >${base }</A>&nbsp; 
       </c:if> 
       <c:if test="${base==result.currentlyPage}">
          ${base }&nbsp;
       </c:if>    
   </c:forEach>
   
   
   <c:if test="${result.totalPage==result.currentlyPage}">
         [尾页]&nbsp;
    </c:if>  
    <c:if test="${result.totalPage!=result.currentlyPage}">
      <A href="javascript:toPage(${result.totalPage});">[尾页]</A>&nbsp;
     </c:if>  
 
   
   跳转到<input type="text" id="gotoPage"  size="3" value="${result.currentlyPage }" />页
   <input type="button" id="go"  size="3" value="GO" onClick="goPage(this)" />
   </c:if>
   <input type="hidden"  id="page" name="page"   /> 
</div>

<script>
$(document).ready(function(){

	$(".fenye").click(function(){
	  
	  toPage($(this).html());
	  
	  
	});
	});
   </script>