<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<%
			pageContext.setAttribute("username","tom");
		%>
		username:<%=pageContext.getAttribute("username") %>
		<%
			request.setAttribute("city","重庆");
		%>
		城市：<%=request.getAttribute("city") %>
		<%
			session.setAttribute("interest","cooking");
		%>
		interest:<%=session.getAttribute("interest") %>
</body>
</html>