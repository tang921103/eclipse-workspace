<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<form action="" method="">
		姓名：<input type="text" name="username" id="name" onblur="checkName();"><br>
		密码：<input type="password" name="password" id="pwd"><br>
		<input type="submit" value="提交"><br>
		</form>
</body>
<script type="text/javascript">
//用户名异步验证
function checkName(){
	//1.创建xhr对象
	var xhr = getXhr();
	//2.监听状态变化
	xhr.onreadystatechange= function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//接收服务端的数据
			var msg = xhr.responseText();
			alert(msg);
		}
	}
	//3.xhr.open()
	//获取文本框的值
	var nameValue = document.getElementById("name").value;
	xhr.open("get","${pageContext.request.contextPath}/user/checkName.do?name="+nameValue,true);
	//4.xhr.send()
	xhr.send();
}
function getXhr(){
	var xhr = null;
	//判断浏览器是否支持xhr对象
	if(window.XMLHttpRequest){
		//如果支持，直接创建对象
		xhr = new XMLHttpRequest();
	}else{
		//兼容IE5 IE6
		xhr = new ActiveObject("Microsoft.XMLHttp");
	}
	return xhr;
}
</script>
</html>