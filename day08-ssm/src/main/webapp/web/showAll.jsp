<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:20px;">
	<table border="1" cellpadding="0" cellspacing="0" width="700px">
		<tr>
		<td>ID</td>
		<td>部门名称</td> 
		<td>部门地址</td>
		<td>修改信息</td>
		</tr>
		<c:forEach items="${all}" var="dept" varStatus="stat">
		<tr>
		<td>${dept.id }</td>
		<td>${dept.deptName }</td>
		<td>${dept.deptLoc }</td>
		<td><a href="${pageContext.request.contextPath }/dept/delete.do?id=${dept.id }">删除</a></td>
		</tr>
		</c:forEach>
		</table>
</body>
</html>