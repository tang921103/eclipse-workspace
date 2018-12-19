package com.tedu.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * 响应对象
 * 该类的每一个实例用于表示一个服务端发送给客户端的响应内容
 * @author soft01
 *
 */
public class HttpResponse {
	private Socket socket;
	private OutputStream out;
	/*
	 * 状态行相关信息定义
	 */
	//状态代码
	private int statusCode;
	/*
	 * 响应正文相关信息定义
	 */
	//要响应的实体文件
	private File entity;
	public HttpResponse(Socket socket) {
		this.socket = socket;
		try {
			this.out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将响应内容按照HTTP协议格式发送给客户端
	 */
		public void flush() {
			/*
			 * 响应客户端的三件事
			 * 1:发送状态行
			 * 2:发送响应头
			 * 3:发送响应正文
			 */
			sendStatusLine();
			sendheaders();
			sendcontent();
		}
		/**
		 * 发送状态行
		 */
		private void sendStatusLine() {
			String line = "HTTP/1.1"+" "+statusCode+" "+HttpContext.getStatusReason(statusCode);
			println(line);
		}
		/**
		 * 发送响应头
		 */
		private void sendheaders() {			
				String line = "Content-Type: text/html";
				println(line);
				line = "Content-Length: "+entity.length();
				println(line);
				println("");					
		}
		/**
		 * 发送响应正文
		 */
		private void sendcontent() {
			try(FileInputStream fis = new FileInputStream(entity);) {				
				byte[] data = new byte[1024*10];
				int len = -1;
				try {
					while((len = fis.read(data))!=-1) {
						out.write(data,0,len);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		/**
		 * 将给定字符串按行发送给客户端（以CRLF结尾）
		 * @param line
		 */
		private void println(String line) {
			try {
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);
				out.write(10);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public int getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}
		public File getEntity() {
			return entity;
		}
		public void setEntity(File entity) {
			this.entity = entity;
		}
		
}
