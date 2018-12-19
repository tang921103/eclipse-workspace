<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
</head>
<body style="font-size:30px;">
		姓名：<input type="text" name="name" id="name"><br>
		电话：<input type="text" name="phone" id="phone"><br>
		地址：<input type="text" name="address" id="address"><br>
		<input type="button" value="显示数据" onclick="showData();">
		<hr>
		省份：<select onchange="getCity(this.value);" id="pro">
			<option>请选择</option>
			<option value="1">湖北省</option>
			<option value="2">河南省</option>
		</select>
		城市：<select id="city">
		<option>请选择</option>
		</select>
</body>
<script type="text/javascript">


function showData(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			//获得的是json字符串
			var values = xhr.responseText;
			//把json字符串转换为json对象
			var obj = JSON.parse(values);
			document.getElementById("name").value=obj.data.name;
			document.getElementById("phone").value=obj.data.phone;
			document.getElementById("address").value=obj.data.address;
		}
	}
	xhr.open("get","${pageContext.request.contextPath}/showData.do",true);
	xhr.send();
}
function getCity1(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange= function(){
		if(xhr.readyState==4&&xhr.status==200){
			var obj = JSON.parse(xhr.responseText);
			var select = document.getElementById("city");
			select.innerHTML = "<option>请选择</option>"
			for(var i =0;i<obj.data.length;i++){
				
				var option = new Option(obj.data[i].name,obj.data[i].code);
				select.appendChild(option);
			}
		}
	}
	xhr.open("post","${pageContext.request.contextPath}/cityData.do");
	var provinceValue = document.getElementById("pro").value;
	xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xhr.send("provinceValue="+provinceValue);
}
//用jQuery实现获取城市信息
	function getCity(provinceCode){
		//使用ajax发送异步请求
		$.ajax({
			//请求的url
			url:"${pageContext.request.contextPath}/cityData.do",
			//不管是get还是post，提交的数据都由data提供
			data:"provinceValue="+provinceCode,
			//表示提交数据的方式
			type:"post",
			//表示响应数据的类型
			dataType:"json",//必须是json格式的字符串
			//obj就是服务器响应的json对象
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