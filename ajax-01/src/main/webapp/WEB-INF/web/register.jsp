<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		<form action="" method="" enctype="application/x-www-form-urlencoded">
		姓名：<input type="text" name="username" id="name" onblur="checkName();"><span id="namespan"></span><br>
		密码：<input type="password" name="password" id="pwd"><br>
		<input type="submit" value="提交"><br>		
		</form><br>
		<hr>
		省份：
		<select id="province" onchange="getCity(this.value);">
		<option>请选择</option>
		<option value="1">河北省</option>
		<option value="2">辽宁省</option>
		</select>
		城市：
		<select id="city">
		<option >请选择</option>
		</select>
</body>
<script type="text/javascript">
//二级联动菜单
//provinceCode表示省份的表编号

function getCity(provinceCode){
	//1.获取xhr对象
	var xhr = getXhr();
	//2.监听状态变化
	xhr.onreadystatechange= function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var msg = xhr.responseText;
			var cityNode = document.getElementById("city");
			cityNode.innerHTML = "<option>请选择</option>";
			var cities = msg.split(";");
			for(var i =0;i<cities.length;i++){
				var city = cities[i].split(",");
				var option = new Option(city[1],city[1]);
				cityNode.appendChild(option);
			}
		}
	}
	//3.open
	xhr.open("post","${pageContext.request.contextPath}/user/getCity.do",true);
	//当发送post请求的时候，必须要设置content-type,必须在send前设置
	xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
	//4.send
	xhr.send("provinceCode="+provinceCode);
}
//用户名异步验证
function checkName(){
	//1.创建xhr对象
	var xhr = getXhr();
	//2.监听状态变化
	xhr.onreadystatechange= function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//接收服务端的数据
			var msg = xhr.responseText;
			//在namespan节点添加姓名是否可用的信息。
			if(msg=="1"){
				msg = "姓名可以使用";
			}else{
				msg = "姓名不可用";
			}
			document.getElementById("namespan").innerHTML=msg;
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