<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head></head>
	<body>
	当前系统在线人数是：
		<%=application.getAttribute("count") %>
		<br>
		sessionId:<%=session.getId() %>
	</body>
</html>