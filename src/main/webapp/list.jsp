<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入jstl核心标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>易班通讯录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
  		<tr>
  			<td>序号</td>
  			<td>部门</td>
  			<td>职位</td>
  			<td>姓名</td>
  			<td>性别</td>
  			<td>专业班级</td>
  			<td>联系方式</td>
  		</tr>
  		<!-- 迭代数据 -->
  		<c:choose>
  			<c:when test="${not empty requestScope.pageBean.pageData}">
  				<c:forEach var="emp" items="${requestScope.pageBean.pageData}" varStatus="vs">
  					<tr>
  						<td>${vs.count }</td>
  						<td>${emp.部门 }</td>
  						<td>${emp.职位 }</td>
  						<td>${emp.姓名 }</td>
  						<td>${emp.性别 }</td>
  						<td>${emp.专业班级 }</td>
  						<td>${emp.联系方式 }  &nbsp;&nbsp;<a href="${pageContext.request.contextPath }/change?id=${emp.序号}">修改</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/delete?id=${emp.序号}">删除</a></td>
  					</tr>
  				</c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="3">对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  		
  		<tr>
  			<td colspan="7" align="center">
				<a href="${pageContext.request.contextPath }/add">新增</a>&nbsp;&nbsp;
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="${pageContext.request.contextPath }/?currentPage=1">首页</a>&nbsp;&nbsp;
  				<a href="${pageContext.request.contextPath }/?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>&nbsp;&nbsp;
  				<a href="${pageContext.request.contextPath }/?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>&nbsp;&nbsp;
  				<a href="${pageContext.request.contextPath }/?currentPage=${requestScope.pageBean.totalPage}">末页</a>&nbsp;&nbsp;
				<form action="/search"> 按名字查找:<input type="text" name="name"><input type="submit" value="查找"></form>
  			</td>
  		</tr>
  		
  	</table>
  </body>
</html>









