<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<head>
<title>listUsers</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<%@ include file="header.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<h1>用户列表</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>用户名</td>
						<td>密码</td>
						<td>邮箱</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${users }" var="user" varStatus="statu">
						<tr class="row${statu.index%2+1 }">
						<td>${user.id }</td>
						<td>${user.uname }</td>
						<td>${user.password }</td>
						<td>${user.email }</td>
						<td><a href="del?id=${user.id } " onclick="return confirm('确定删除吗？')">删除</a></td>
					</tr>
					</c:forEach>				
				</table>
				<p>
					<input type="button" class="button" value="Add User"
						onclick="location='addUser.jsp'" />
				</p>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
