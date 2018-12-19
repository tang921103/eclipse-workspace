<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head></head>
	<body>	
	<form action="bmi" method="post">
	身高（米）：<input type="text" name="height">
		体重（kg）：<input type="text" name="weight">
		<input type="submit" value="提交" >
		<%
			String bmi = (String)request.getAttribute("bmi");
			if(bmi!=null){
				out.println("<p>"+bmi+"</p>");
			}
		%>
	</form>
		
	</body>
</html>