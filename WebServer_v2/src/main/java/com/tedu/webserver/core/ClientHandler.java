package com.tedu.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

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
		//测试读取客户端发送过来的请求行中第一行的内容（请求行内容）
		/*
		 * 通过给定的输入流读取一行字符串（以CRLF结尾）
		 */	
		try {
			/*
			 * 测试读取客户端发送过来的请求中第一行内容（请求行内容）
			 */
			String line = readLine(socket.getInputStream());
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String readLine(InputStream in) {
		StringBuilder builder = new StringBuilder();
		int d = -1;
		char c1 = 'a',c2= 'a';
		try {
			while((d = in.read())!=-1) {
				c2  = (char)d;
				if(c1==13&&c2==10) {
					break;
				}
				builder.append(c2);
				c1 = c2;
			}
			return builder.toString().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
