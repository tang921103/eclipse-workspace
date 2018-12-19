<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*,dao.*,entity.*" %>
<html>
	<head>
		<style type="text/css">
		table{
			font-size:20px;
			text-align:center;
			width:30%;
			border:1px solid blue;
		}
		td{
			height:30px;
			border:1px solid red;
		}
		.row0{
			background-color:orange;
		}
		.row1{
		background-color:green;
		}
		</style>
	</head>
	<body>
		<table cellspacing="0" cellpadding="0">
			<caption>用户信息表</caption>
			<tr>
				<td>ID</td>
				<td>用户名</td>
				<td>密码</td>
				<td>邮箱</td>
			</tr>
			<% 
				UserDAO dao = new UserDAO();
				List<User> users = dao.findAll(); 
				for(int i =0;i<users.size();i++){
					User u = users.get(i);
					%>
					<tr class="row<%=i%2%>">
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