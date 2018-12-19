<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello struts2!
	<hr>
	${requestScope.username }登陆成功！
	<hr>
	${username }注册成功！
	<hr>
	Servlet范围对象<br>
	application:${applicationScope.context }<br>
	request:${requestScope.request }<br>
	session:${sessionScope.session }<br>
	<hr>
	Servlet范围对象<br>
	application:${applicationScope.context2 }<br>
	request:${requestScope.request2 }<br>
	session:${sessionScope.session2}<br>
</body>
</html>