<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="dao.*,java.util.*,entity.*" %>
<html>
	<head>
		<style type="text/css" >
			.row1{
				background-color:#f0f0f0;
			}
			.row2{
				background-color:#666;
			}
		
		</style>
		
	</head>
	<body style="font-size:30px;">
		<table style="text-align:center" border="1" width="20%" cellspacing="0" cellpadding="0">
			<tr><td>ID</td><td>用户名</td><td>密码</td><td>邮箱</td></tr>
			<%
				UserDAO user = new UserDAO();
				List<User> users = user.findAll();
						for(int i = 0;i<users.size();i++){
							User u = users.get(i);
				%>
				<tr class="row<%=i%2+1%>">
					<td><%=u.getId() %></td>
					<td><%=u.getUname() %></td>
					<td><%=u.getPassword() %></td>
					<td><%=u.getEmail() %></td>
				</tr>			
				<% 			
						}
			%>
		</table>
	</body>
</html>