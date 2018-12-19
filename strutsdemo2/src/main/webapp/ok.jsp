<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${user.username }登陆成功！<br>
<s:property value="user.username"/>
..............................................................<br>
context:${applicationScope.skey }<br>
request:${requestScope.rkey }<br>
session:${sessionScope.session }<br>
..............................................................<br>
context:${applicationScope.skey1 }<br>
request:${requestScope.rkey1 }<br>

</body>
</html>