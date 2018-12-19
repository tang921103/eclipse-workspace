<%@ page import="java.net.*" %>
<html>
	<head></head>
	<body>
	<% 
		Cookie c = new Cookie("interest",URLEncoder.encode("cooking,fishing","utf-8"));
		response.addCookie(c);
	%>
	</body>
</html>