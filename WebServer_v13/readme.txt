本版本改动：
 
 
 使得服务端支持客户端以POST形式提交form表单数据。
 当一个form表单中含有用户隐私数据或者附件时，都应当使用POST形式提交数据。
 而POST请求会将用户提交的数据放在请求的消息正文部分进行传递给服务端。
 	
 1：将这册页面中form表单的提交形式改为post。
 2：在HttpRequest中完成parseContent解析消息正文的方法。
       根据消息头判断是否含有Content-Length来决定此请求是否包含消息正文。
       然后根据Content-Type来判断消息内容，这里指判定form表单。
 3：将原来的parseURL方法中解析参数的功能代码提出来，定义为ie此方法parseParameters,
 并让parseURL对应的功能改为调用此方法。这样在解析消息正文时读取道的post提交过来的表单数据时
 也可以利用该方法解析。
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	