<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
			ok	<br>
			姓名：${requestScope.name }<br>
			年龄：${sessionScope.age }<br>
			message:${requestScope.message }<br>
			error:${requestScope.error }<br>
</body>
</html>