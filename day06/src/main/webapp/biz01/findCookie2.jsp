<%@ page import="java.net.*" %>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie c : cookies){
			out.println(c.getName()+","+URLDecoder.decode(c.getValue(),"utf-8")+"<br>");
		}
	}
%>