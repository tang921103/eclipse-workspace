<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<form action="${pageContext.request.contextPath }/demo/test9.do" method="post">
				姓名：<input type="text" name="name" id="name"><span style="font-size:15px;color:red">${requestScope.tips }</span><br>			
				年龄：<input type="text" name="age" id="age"><br>
				密码：<input type="password" name="password" id="password"><br>
				<input type="submit" value="提交">
		</form>
</body>
</html>