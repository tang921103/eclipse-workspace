package com.tedu.webserver.core;

import java.io.IOException;
import java.io.InputStream;
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
