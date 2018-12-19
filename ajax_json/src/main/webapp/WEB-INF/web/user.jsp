<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
		姓名：<input type="text" name="name" id="name"><br>
		地址：<input type="text" name="address" id="address"><br>
		邮箱：<input type="text" name="email" id="email"><br>
		<input type="button" value="显示用户信息" onclick="showMsg();"><br>
		<hr>
		省份：
		<select id="pro" onchange="getCity(this.value)">
		<option>请选择</option>
		<option value="1">湖北</option>
		<option value="2">河南</option>
		</select>
		城市：
		<select id="city">
		<option>请选择</option>
		</select>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function showMsg(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange= function(){
			if(xhr.readyState==4&&xhr.status==200){
				var obj = JSON.parse(xhr.responseText);
				document.getElementById("name").value = obj.data.name;
				document.getElementById("address").value = obj.data.address;
				document.getElementById("email").value = obj.data.email;
			}
		}
		xhr.open("get","${pageContext.request.contextPath}/showUser.do",true);
		xhr.send();
	}
	
/* function getCity(value){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4&&xhr.status==200){
			var obj = JSON.parse(xhr.responseText);
			var s = document.getElementById("city");
			s.innerHTML = "<option>请选择</option>";
			for(var i =0;i<obj.data.length;i++){
				var option = new Option(obj.data[i].name,obj.data[i].code);
				s.appendChild(option);
			}
		}
	}
	xhr.open("get","${pageContext.request.contextPath}/showCity.do?code="+value,true);
	xhr.send();
} */
	function getCity(code){
		$.ajax({
		url:"${pageContext.request.contextPath}/showCity.do",
		data:"code="+code,
		dataType:"json",
		type:"post",
		success:function(obj){
			$("#city").html("<option>请选择</option>");
			for(var i =0;i<obj.data.length;i++){
				var option = new Option(obj.data[i].name,obj.data[i].code);
				$("#city").append(option);
			}
		}		
		})
}
</script>
</html>