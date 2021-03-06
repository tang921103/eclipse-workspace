package com.tedu.webserver.servlet;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.tedu.webserver.http.HttpRequest;
import com.tedu.webserver.http.HttpResponse;

/**
 * 处理注册业务
 * @author soft01
 *
 */
public class RegServlet extends HttpServlet{
		public void service(HttpRequest request,HttpResponse response) {
			try(RandomAccessFile raf = new RandomAccessFile("user.dat","rw")) {
				System.out.println("开始处理注册业务");
				/*
				 * 注册业务流程 
				 * 1：通过request获取用户注册信息 
				 * 2：使用RandomAccessFile打开user.dat文件 
				 * 3：将该用户信息写入文件
				 * 4：设置responde,响应注册成功页面。
				 */
				// 1 获取用户信息
				String username = request.getParameters("username");
				String password = request.getParameters("password");
				String nickname = request.getParameters("nickname");
				// 还要对用户数据进行验证
				// 2
				raf.seek(raf.length());
				int age = Integer.parseInt(request.getParameters("age"));
				byte[] data = username.getBytes("UTF-8");
				data = Arrays.copyOf(data, 32);
				raf.write(data);
				data = password.getBytes("UTF-8");
				data = Arrays.copyOf(data, 32);
				raf.write(data);
				data = nickname.getBytes("UTF-8");
				data = Arrays.copyOf(data, 32);
				raf.write(data);
				raf.writeInt(age);
				// 3 响应客户端注册成功页面
			//	forward("/myweb/reg_success.html",request,response);
				/*
				 * 设置重定向路径时注意，若使用相对路径，相对的应当是请求当前Servlet
				 * 时的路径，例如：请求RegServlet时，客户端的路径为http://localhost:8080/myweb/reg
				 * 那么当前目录就是：http://localhost:8080/myweb/
				 * 所以，在设置重定向目录时只需要设置为 reg_success.html即可。
				 * 那么浏览器得到这个路径后会拼在当前目录中：http://localhost:8080/myweb/reg_success.html
				 */
				response.sendRedirect("reg_success.html");
				System.out.println("注册成功");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
}
