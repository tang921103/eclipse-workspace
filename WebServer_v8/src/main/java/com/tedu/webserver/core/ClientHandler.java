package com.tedu.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.Arrays;

import com.tedu.webserver.http.HttpRequest;
import com.tedu.webserver.http.HttpResponse;

/**
 * 处理客户端请求的线程任务
 * 
 * @author soft01
 *
 */
public class ClientHandler implements Runnable {
	private Socket socket;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("启动了一个线程处理该客户");
		/*
		 * 处理该客户的请求的大致步骤： 1.解析请求,创建HttpRequest 创建响应对象HttpResponse 2.处理请求 3.给予响应
		 */
		try {
			// 1.解析请求，生成HttpRequest对象
			HttpRequest request = new HttpRequest(socket);
			HttpResponse response = new HttpResponse(socket);
			// 2.处理请求
			/*
			 * 通过request获取请求的资源路径，从webapps中寻找对应资源。
			 */
			String url = request.getRequestURI();
			if ("/myweb/reg".equals(url)) {
				System.out.println("开始处理注册业务");
				/*
				 * 注册业务流程 1：通过request获取用户注册信息 2：使用RandomAccessFile打开user.dat文件 3：将该用户信息写入文件
				 * 4：设置responde,响应注册成功页面。
				 */
				// 1 获取用户信息
				String username = request.getParameters("username");
				String password = request.getParameters("password");
				String nickname = request.getParameters("nickname");
				int age = Integer.parseInt(request.getParameters("age"));
				System.out.println("username:" + username);
				// 还要对用户数据进行验证
				// 2
				try (RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");) {
					raf.seek(raf.length());
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
					System.out.println("写入成功");
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 3 响应客户端注册成功页面
				response.setStatusCode(200);
				File file = new File("webapps/myweb/reg_success.html");
				response.setEntity(file);
			} else {
				File file = new File("webapps" + url);
				if (file.exists()) {
					System.out.println("资源已找到");
					/*
					 * 以一个标准的HTTP响应格式，回复客户端该资源
					 */
					response.setStatusCode(200);
					response.setEntity(file);
				} else {
					System.out.println("资源未找到");
					File notFound = new File("webapps/myweb/404.html");
					response.setStatusCode(404);
					response.setEntity(notFound);
				}
			}
			// 响应客户端
			response.flush();
		} catch (EmptyRequestException e) {
			System.out.println("空请求");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 响应后断开与客户端的连接
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
