<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ page import="dao.*,entity.*,java.util.*" %>
<html>
	<head>
		<title>listUsers</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<%@ include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						用户列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								用户名
							</td>
							<td>
								密码
							</td>
							<td>
								邮箱
							</td>
							<td>
								操作
							</td>
						</tr>
						<%
							UserDAO dao = new UserDAO();
						List<User> users = dao.findAll();
						for(int i =0;i<users.size();i++){
							User u = users.get(i);
							%>
							<tr class="row<%=i%2+1%>">
								<td><%=u.getId() %></td>
								<td><%=u.getUname() %></td>
								<td><%=u.getPassword() %></td>
								<td><%=u.getEmail() %></td>
								<td><a href="del?id=<%=u.getId()%>">删除</a>&nbsp;</td>
							</tr>
							<%
						}
						%>
						
					</table>
					<p>
						<input type="button" class="button" value="Add User" onclick="location='addUser.jsp'"/>
					</p>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>
