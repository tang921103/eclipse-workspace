<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		<form action="comment" method="post">
		评论：<input name="content">
		<%
			String num = (String)request.getAttribute("long");
		%>		
		<input type="submit" value="确定">
		<%=num==null?"":num %>
		</form>
	</body>
</html>