<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<form action="bmi.do" method="post">
		<table>
			<tr>
				<td>身高</td>
				<td><input type="text" name="height"></td>
			</tr>
			<tr>
				<td>体重</td>
				<td><input type="text" name="weight"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
		</form>
</body>
</html>