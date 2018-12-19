<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="bean.*" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>EL表达式</title>
	</head>
	<body>
		<%
			User user = new User();
			user.setUsername("张三");
			user.setAge(22);
			user.setInterest(new String[]{"打球","游戏","妹子"});
			session.setAttribute("u",user);
			User user2 = new User();
			user2.setUsername("李四娃");
			user2.setAge(68);
			user2.setInterest(new String[]{"下棋","喝酒","打麻将"});
			pageContext.setAttribute("u",user2);
			int [] arr = new int[]{};
		%>
		${u.username }<br>
		${u.age }<br>
		${pageScope.u.interest[1] }<br>
		<hr>
		${sessionScope.u["username"] }<br>
		${sessionScope.u["age"] }<br>
		${sessionScope.u.interest[2] }<br>
		<hr>
		${u.age>60 }<br>
		${sessionScope.u.username=="张三" }<br>
		${sessionScope.u.age + pageScope.u.age }<br>
		${sessionScope.u['age'] + pageScope.u['age'] }<br>
		${"2" + "3" }<br>
		${u["age"]%sessionScope.u.age }<br>
		<hr>
		${ sessionScope.u.username.length() < u.username.length()}<br>
		${sessionScope.u.age > 20 }<br>
		${!(u.age > 20) }<br>
		<hr>
		${empty arr }<br>
		${empty "" }<br>
		${empty null }<br>
		${empty us }<br>
		${empty u }<br>
		<hr>
		${param.name }<br>
		${paramValues.age[0] }<br>
	</body>
</html>