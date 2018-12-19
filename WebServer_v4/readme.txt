本版本改动：
将客户端请求的页面响应给客户端
本次版本要了解HTTP协议中的响应（response）规则，要严格按照HTTP协议的
响应(response)格式给客户端响应，这样浏览器才能得到正确的结果。

http://localhost:8080/index.html

1:在项目目录中添加一个新目录webapps
   使用该目录保存不同网站所需要的素材等内容
   
 2：在webapps目录下新建子目录myweb
 	myweb作为我们测试的网站资源的目录。
 	
 注：在TOMCAT中webapps目录是存放所有web应用的。其中每一个子目录都是
 	一个具体的web应用（一个网站内容，涵盖页面，图片等素材以及处理业务逻辑的java代码等）
 	
 3：在web中添加页面index.html
 
 4：浏览器的地址栏中请求某个服务器资源时，是无法写在服务端该资源的绝对路径的，只能写相对路径
 	（这样写的好处也很多，比如没有平台差异性)
 	例如：浏览器地址栏输入的地址为：
 	http://localhost:8080/index.html
 	协议部分 服务器地址信息  资源路径部分 （请求行url内容）
 	
 	我们可以规定在资源路径部分中的根为我们定义的保存所有资源的目录webapps
 	那么，若想找到webapps/myweb/index/.html页面的话，浏览器的地址栏要输入：
 	http://localhost:8080/myweb/index.html
 	当该请求发送到服务端时，我们解析请求中请求行里的url部分会得到/myweb/index.html.
 	那么我们就对应的从webapps目录中找到该对应资源：webapps/myweb/index.html并将该资源响应给客户端。
 	
 	
 	根据请求行中的url，对应找到webapps目录中相应资源。若找到则准备响应给客户端。
 	在ClientHandler中添加分支判断，查找客户端请求的资源是否存在。
 	
 	5：以一个HTTP标准响应格式，将用户请求的资源回复给客户端
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	