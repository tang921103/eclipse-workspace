<%@ page import="java.util.*" contentType="text/html;charset=utf-8"%>
<html>
	<head>
			<meta charset="utf-8">
			<title>Hello Kitty</title>
	</head>
	<body style="font-size:30px;">
	待你长发及腰，用来拖地可好。
	<br>
		time:<%=new Date() %>
		<br>
		time:
		<%
			Date date =new Date();
			out.println(date);
		%>
		<br/>
		<%
			for(int i = 0;i<100;i++){
				out.println("Hello Kitty<br/>");
			}
		%>
	</body>
</html>


