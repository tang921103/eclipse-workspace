package com.tedu.webserver.servlet;

import java.io.File;
import java.io.RandomAccessFile;

import com.tedu.webserver.http.HttpRequest;
import com.tedu.webserver.http.HttpResponse;

/**
 * 处理登陆业务
 * @author soft01
 *
 */
public class LoginServlet extends HttpServlet{
		public void service(HttpRequest request,HttpResponse response) {
			try(RandomAccessFile raf = new RandomAccessFile("user.dat","r")){
				//获取用户输入的登录信息
				String username = request.getParameters("username");
				String password = request.getParameters("password");
				//判断是否匹配已注册用户信息
				boolean check = true;
				for(int i = 0;i<raf.length();i++) {
					raf.seek(i*100);
					byte[] data  = new byte[32];
					raf.read(data);
					String name = new String(data,"UTF-8").trim();
					if(name.equals(username)) {
						raf.read(data);
						String pwd = new String(data,"UTF-8").trim();
						if(pwd.equals(password)) {
							System.out.println("登录成功");
							//响应登录成功页面
							forward("/myweb/login_success.html",request,response);
							check = false;						
						}
						break;
					}
				}
				if(check) {
					System.out.println("登录失败");
					//响应登录失败页面
					forward("/myweb/login_fail.html",request,response);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
