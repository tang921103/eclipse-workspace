<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
登陆成功！
	pageContext:${page.username }<br>
	session:${sessionScope.username } <br>
	request:${requestScope.username }<br>
	application:${applicationScope.username }<br>
</body>
</html>