<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		${sessionScope.user.username }登录成功！||<a href="${pageContext.request.contextPath }/user/exit.do">退出</a><br>
		<a href="${pageContext.request.contextPath }/user/showInfo.do">显示个人信息</a>
</body>
</html>