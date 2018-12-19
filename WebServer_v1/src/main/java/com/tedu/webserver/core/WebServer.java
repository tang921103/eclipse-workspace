package com.tedu.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * WebServer主类
 * @author soft01
 *
 */            
public class WebServer {
		private ServerSocket server;
		public WebServer() {
			try {
				//Tomcat默认开启的端口就是8080
				server = new ServerSocket(8080);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void start() {
			try {
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				InputStream in = socket.getInputStream();
				int d = -1;
				while((d = in.read())!=-1) {
					System.out.print((char)d);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			WebServer server = new WebServer();
			server.start();
		}
}
