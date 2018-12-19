<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*,utils.*" %>
<html>
	<head></head>
	<body>
			缓存数据：
			<%
				List<User> users = (List<User>)application.getAttribute("users");
			for(int i =0;i<users.size();i++){
				User u = users.get(i);
				%>
				<table>
					<tr>
						<td><%=u.getId() %></td>
						<td><%=u.getUsername() %></td>
						<td><%=u.getPassword() %>
						<td><%=u.getEmail() %>
					</tr>
				</table>
				<% 
			}
			%>
	</body>
</html>