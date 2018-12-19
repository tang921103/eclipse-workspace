<%@ page import="java.util.*,java.text.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>日期</title>
	</head>
	<body style="font-size:30px">
	<p>好想把马俊伟打一顿</p>
		<%
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			String d = sdf.format(date);
			out.println(d);
		%>
	</body>
</html>