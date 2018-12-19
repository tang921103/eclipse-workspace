本版本改动：
解决客户端发送空请求的问题；
HTTP协议允许客户端发送一个空请求（不是按照标准的request格式发，而是没有内容）
由于ClientHandler上来在解析时我们读取请求行内容后会拆分三部分，如果此时发送的是空请求，
则会出现数组下标越界的情况，导致后续操作无法进行。
对于空请求，服务端的实际操作可以忽略，为此我们可以做如下改动：
1：在core包中定义一个异常：EmptyRequestException
2：当解析到空请求时，HttpReuqest抛出该异常给ClientHandler
3：ClientHandler捕获空请求后，直接与客户端断开连接。


在页面上支持对图片的显示工作，最终通过此版本更新使服务端支持对客户端请求的任意资源进行正确的响应。
1:在webapps/myweb下添加一张图片
2：在index.html中添加显示该图片的标签<img arc="logo.png">
3:将WebServer的start方法中循环接收客户端连接的while循环解除注释。

测试后发现，客户端在显示index页面时，实际对服务端请求了两次，第一次请求我们在地址栏输入的index页面内容，
当浏览器解释该页面内容时发现<img>标签后，会根据该标签中指定的路径再次发起连接请求获取该图片，虽然图片
可以正常被显示，但是服务端在响应该图片时在响应头中描述该图片类型时，依然告知客户端为html代码。（因为
HttpResponse中发送响应头中的Content-Type是写死的发送“text/html”），这会导致将来客户端在请求其他资源时
不能正常理解该资源导致显示出现异常。

解决方式：
1：在HttpContext类中定义一个方法，可以根据资源名的后缀获取其对应的Content-Type的值
   1.1  在HttpContent中定义一个Map类型的静态属性，MIME_MAPPING,其中key为资源后缀名，value为其对应的
   Content-Type的值。
   1.2  添加一个初始化该Map的方法： initMimeMapping
   1.3 在HttpContext的静态块中调用初始化方法
   1.4 定义静态方法：getMimeType(String ext)用来根据指定的资源后缀获取对应的Content-Type的值。
   
  2:重构HttpRequest
  在sendHeaders方法中，现在的做法是发送了两个头：Content-Type和Content-Length,但是实际上不是每个响应头都包含这两个头，
  并且也可能会包含其他头。为此发送的响应头应当是也是可以进行设置的。
    2.1 在HttpResponse中添加一个Map类型的属性：headers,用于保存本次响应要发送给客户端的响应头内容，
    其中key为响应头的名字，value为响应头的值。
    2.2 提供一个putHeaders方法，允许外界向当前响应中设置要发送的响应头内容
  2.3 sendHeaders方法改为遍历headers这个Map，将每个响应头发送至客户端。


 
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	