<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,bean.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.row1{
		background-color:#fff8dc;
	}
	.row2{
		background-color:#f1f1f1f1;
	}
</style>
</head>
<body style="font-size:20px;">
		<%
			List<User> users = new ArrayList<User>();
			for(int i = 0;i<8;i++){
				User user = new User();
				user.setUsername("user"+i);
				user.setGender("x");
				user.setAge(22+i);
				users.add(user);
			}
			request.setAttribute("users",users);
		%>
		<table width="700px" height="30px" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>序号</td>
				<td>下标</td>
				<td>用户名</td>
				<td>性别</td>
				<td>年龄</td>
			</tr>
			<c:forEach items="${users }" var="u" varStatus="s">
				<tr class="row${s.count%2+1 }">
				<td>${s.count }</td>
				<td>${s.index }</td>
				<td>${u.username }</td>
				<td><c:choose>
					<c:when test="${u.gender == 'm' }">男</c:when>
					<c:when test="${u.gender == 'f' }">女</c:when>
					<c:otherwise>保密</c:otherwise>
				</c:choose></td>
				<td>${u.age }
				</tr>
			</c:forEach>
		</table>
</body>
</html>