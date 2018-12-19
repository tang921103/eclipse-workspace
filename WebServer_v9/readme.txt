本版本改动：
 
 使服务端支持处理业务操作：完成登陆业务。
 1：在webapps/myweb中准备三个页面：
   login.html登陆页面：
    页面中应当包含两个输入框：username , password
    然后该页面中的form表单action指定为login
    
   login_success.html 提示用户登陆成功页面
   login_fail.html提示用户登陆失败页面
        
 2：在ClientHandler的判断注册业务下面再添加一个分支，判断请求路径是否为“myweb/login"
 	若是，则开始处理登陆业务。
 	
 3：首先通过request获取用户在登陆页面中输入的用户名及密码，然后使用RAF读取user.dat文件，
 顺序匹配每个注册用户，若其中一个用户信息与该登陆信息匹配则设置response跳转登陆成功页面，
 若最终没有任何记录匹配，则跳转登陆失败页面。
 登陆操作参考SE项目中raf包中的demo3案例。
        
        
 		

 
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	