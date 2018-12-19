package com.tedu.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.tedu.webserver.http.HttpRequest;

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
		 * 1.解析请求
		 * 2.处理请求
		 * 3.给予响应
		 */		
		try {
			//1.解析请求，生成HttpRequest对象
			HttpRequest request = new HttpRequest(socket);
			//2.处理请求
			/*
			 * 通过request获取请求的资源路径，从webapps中寻找对应资源。
			 */
			String url = request.getUrl();
			File file = new File("webapps"+url);
			OutputStream out = socket.getOutputStream();
			if(file.exists()) {
				System.out.println("资源已找到");
				/*
				 * 以一个标准的HTTP响应格式，回复客户端该资源
				 */			 
				//发送状态行
				out.write("HTTP/1.1 200 OK".getBytes("ISO8859-1"));
				out.write(13);
				out.write(10);
				//发送响应头
				String line = "Content-Type: text/html";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);
				out.write(10);
				line = "Content-Length: "+file.length();
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);
				out.write(10);
				//表示响应头部分发送完毕
				out.write(13);
				out.write(10);
				//发送响应正文
				FileInputStream fis = new FileInputStream(file);
				byte[] data = new  byte[1024*10];
				int len = -1;
				while((len = fis.read(data))!=-1) {
					out.write(data, 0, len);
				}
				System.out.println("资源发送成功");
			}else {
				System.out.println("资源未找到");
				File notFound = new File("webapps/myweb/404.html");
				out.write("HTTP/1.1 404 Not Found".getBytes("ISO8859-1"));
				out.write(13);
				out.write(10);
				out.write("Content: text/html".getBytes("ISO8859-1"));
				out.write(13);
				out.write(10);
				out.write(("Content: "+notFound.length()).getBytes("ISO8859-1"));
				out.write(13);
				out.write(10);
				out.write(13);
				out.write(10);
				FileInputStream fis = new FileInputStream(notFound);
				byte[] data = new byte[1024*10];
				int len = -1;
				while((len = fis.read(data) )!=-1) {
					out.write(data,0,len);
				}
			}
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
