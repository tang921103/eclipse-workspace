<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bean.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<%
			User user = new User();
			user.setUsername("李白");
			user.setGender("m");
			user.setAge(12);
			request.setAttribute("user", user);
		%>
		用户名：${user.username }<br>
		性别：<c:choose>
				<c:when test="${user.gender=='m' }">男</c:when>
				<c:when test="${user.gender=='f' }">女</c:when>
				<c:otherwise>保密</c:otherwise>
		</c:choose>
		<br>
		年龄：<c:choose>
			<c:when test="${user.age<18 }">未成年</c:when>
			<c:when test="${user.age>60 }">老年</c:when>
			<c:otherwise>青年</c:otherwise>
		</c:choose>
</body>
</html>