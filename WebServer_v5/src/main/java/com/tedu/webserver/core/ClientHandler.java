package com.tedu.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.tedu.webserver.http.HttpRequest;
import com.tedu.webserver.http.HttpResponse;

/**
 * 处理客户端请求的线程任务
 * @author soft01
 *
 */
public class ClientHandler implements Runnable{
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		System.out.println("启动了一个线程处理该客户");
		/*
		 * 处理该客户的请求的大致步骤：
		 * 1.解析请求,创建HttpRequest
		 *    创建响应对象HttpResponse
		 * 2.处理请求
		 * 3.给予响应
		 */		
		try {
			//1.解析请求，生成HttpRequest对象
			HttpRequest request = new HttpRequest(socket);
			HttpResponse response = new HttpResponse(socket);
			//2.处理请求
			/*
			 * 通过request获取请求的资源路径，从webapps中寻找对应资源。
			 */
			String url = request.getUrl();
			File file = new File("webapps"+url);
			if(file.exists()) {
				System.out.println("资源已找到");
				/*
				 * 以一个标准的HTTP响应格式，回复客户端该资源
				 */			 				
				response.setStatusCode(200);
				response.setEntity(file);
			}else {
				System.out.println("资源未找到");
				File notFound = new File("webapps/myweb/404.html");
				response.setStatusCode(404);
				response.setEntity(notFound);
			}
			//响应客户端
			response.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//响应后断开与客户端的连接
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
