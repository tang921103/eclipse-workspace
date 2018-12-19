<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
</head>
<body sytle="font-size:25px;">
<a onclick="fun1();">一个key-vlaue的json对象的定义及访问</a><br>
<a onclick="fun2();">多个key-vlaue的json对象的定义及访问</a><br>
<a onclick="fun3();">多个key-vlaue的json对象的定义及访问,value表示对象</a><br>
<a onclick="fun4();">多个key-vlaue的json对象的定义及访问,value表示数组（服务端的集合）</a><br>
</body>
<script type="text/javascript">
//一个key-value的json对象的定义
	function fun1(){
		var obj = {"state":1};
		alert(obj.state);
}
	//多个key-vlaue的json对象
	function fun2(){
		var obj = {"state":1,"message":"成功"};
		alert(obj.state+"  "+obj.message);
	}
	//value为对象的json对象
	function fun3(){
		var obj = {
				"state":1,
				"message":"成功",
				"data":{"name":"admin","age":18}
		};
		alert(obj.data.name);
	}
	//value为对象的json数组
	function fun4(){
		var obj = {
				"state":1,
				"message":"成功",
				"data":[
					{"cityCode":21,"cityName":"武汉"},
					{"cityCode":22,"cityName":"襄阳"},
					{"cityCode":23,"cityName":"恩施"}
				]
		}
		for(var i =0;i<obj.data.length;i++){
			alert(obj.data[i].cityCode+"  "+obj.data[i].cityName);
		}
	}
	
</script>
</html>