<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<%
			User user = new User();
			user.setUsername("king");
			user.setAge(22);
			request.setAttribute("user",user);
			User user2 = new User();
			user2.setUsername("sally");
			user2.setAge(33);
			session.setAttribute("user",user2);
			user.setInterest(new String[]{"basketball","football"});
			session.setAttribute("interest",user);
		%>
		<br>
		username:${user.username}
		<br>
		指定查询的范围：<br>
		username:${sessionScope.user.username }<br>
		方式二：<br>
		username:${user['username'] }<br>
		username:${sessionScope.user['username'] }<br>
		<%
			request.setAttribute("prop","username");
		%>
		允许[]里面出现绑定名：<br>
		${user[prop]}<br>
		允许[]里面出现从零开始的下标：<br>
		${user.interest[0]}
</body>
</html>