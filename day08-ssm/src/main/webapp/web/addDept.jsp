<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<form action="${pageContext.request.contextPath}/dept/addDept.do" method="post" align="center">
		部门名称：<input type="text" name="deptName" id="deptName"><br>
		部门地址：<input type="text" name="deptLoc" id="deptLoc"><br>
		<input type="submit" value="添加">
		</form>
</body>
</html>