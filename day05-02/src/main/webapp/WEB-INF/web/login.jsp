<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		${requestScope.error }<br>
		<form action="${pageContext.request.contextPath }/user/login.do" method="post">
			账号：<input type="text" name="username"><br>
			密码：<input type="texy" name="password"><br>
			<input type="submit" vaule="登陆">
		</form>
</body>
</html>