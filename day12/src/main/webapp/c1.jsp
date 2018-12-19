<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			user.setGender("f");
			request.setAttribute("user", user);
		%>
		用户名：${user.username }<br>
		性别：<c:if test="${user.gender=='m' }">
			男
		</c:if>
				<c:if test="${user.gender =='f' }">
				女
				</c:if>
		<br>
		性别：<c:if test="${user.gender=='f'}" var="rs" scope="page">男</c:if>
		
</body>
</html>