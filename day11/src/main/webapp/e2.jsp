<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<%
			Employee emp = new Employee();
			emp.setEname(1103030129);
			emp.setSalary(5000.23);
			emp.setAge(25);
			session.setAttribute("employee",emp);
			Employee emp2 = new Employee();
			emp2.setEname(22);
			emp2.setSalary(1002.23);
			emp2.setAge(33);
			emp2.setMsg(new String[]{"hello","sword","money"});
			request.setAttribute("employee",emp2);
		%>
		ename:${sessionScope.employee.ename }<br>
		salary:${sessionScope.employee.salary }<br>
		age: ${sessionScope.employee.age }<br>
		msg:${sessionScope.employee.msg }<br>
		第二种方式：<br>
		ename:${employee["ename"] }<br>
		salary:${employee["salary"] }<br>
		age:${employee["age"] }<br>
		msg:${employee.msg[2] }
		算术运算：<br>
		${1+1 }<br>
		"+"只能起加号作用，不能用于连接，<br>${'2'+'2' }<br>
		关系运算：<br>
		${1<2 }<br>
		<%
			request.setAttribute("s1","abc");
		%>
		${s1=="abc" }<br>  
		逻辑运算：<br>
		${1<2 && 2>8 }<br>
		empty运算：<br>
		<%
			request.setAttribute("s2","");
			List list1 = new ArrayList();
			request.setAttribute("list1",list1);
		%>
		空字符串：${empty s2 }<br>
		空的集合：${empty list1 }<br>
		找不到对应的值：${empty abc }<br>
		null：${empty null }<br>
</body>
</html>