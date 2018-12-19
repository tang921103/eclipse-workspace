package com.tedu.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.tedu.webserver.core.EmptyRequestException;

/**
 * HttpRequest表示一个Http协议要求的请求信息
 * 一个请求包含三个部分：
 * 请求行、消息头、消息正文
 * @author soft01
 *
 */
public class HttpRequest {
	//对应客户端的socket
	private Socket socket;
	//通过Socket获取输入流，用于读取客户端发送的请求
	private InputStream in;
	/*
	 * 请求行相关定义
	 */
	//请求方式
	private String method;
	//请求的资源路径
	private String url;
	//请求时用的资源版本
	private String protocol;
	//url中的请求部分
	private String requestURI;
	//url中的参数部分
	private String queryString;
	//url中所有参数
	// key ：参数名   value ： 参数值
	private Map<String,String> parameters = new HashMap<String,String>();
	/*
	 * 消息头定义
	 */
	private Map<String,String> headers = new HashMap<String,String>();
	/**
	 * 实例化HttpRequest使用的构造方法，需要将对应的客户端的Socket传入，
	 * 以便读取该客户端传来的请求内容。
	 * @param socket
	 * @throws EmptyRequestException 
	 */
	public HttpRequest(Socket socket) throws EmptyRequestException {
		System.out.println("HttpRequest:开始解析请求");
		try {
			this.socket = socket;
			this.in = socket.getInputStream();
		/*
		 * 1.解析请求行
		 * 2.解析消息头
		 * 3.解析消息正文
		 */
		//1.解析请求行
		parseRequestLine();
		//2.解析消息头
		parseHeaders();
		//解析消息正文
		parseContent();
		}catch(EmptyRequestException e) {
			//将空请求抛出给ClientHandler
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 解析请求行
	 * @throws EmptyRequestException 
	 */
	private void parseRequestLine() throws EmptyRequestException {
		System.out.println("解析请求行");
		/*大致流程：
		 * 1：通过输入流读取第一行字符串
		 * 2：将请求行按照空格拆分
		 * 3：将拆分的三项分别设置到method，url,protocol三个属性上
		 * 
		 * 解析请求行时，在获取拆分后的数组元素时，可能会引发数组下标越界异常，
		 * 这是由HTTP协议允许客户发送一个空请求过来导致的。
		 * 我们后面解决。
		 */
		String requestLine = readLine();
		String[] request = requestLine.split("\\s");
		//拆分请求行内容是否能达到3项
		if(request.length<3) {
			//这是一个空请求
			throw new EmptyRequestException();
		}
		this.method = request[0];
		this.url = request[1];
		//进一步解析url
		parseURL();
		this.protocol = request[2];
		System.out.println("method:"+this.method);
		System.out.println("url:"+this.url);
		System.out.println("protocol:"+this.protocol);
	}
	/**
	 * 进一步解析url:
	 * 将url中的请求部分设置到属性requestURI上
	 * 将url中的参数部分设置到属性queryString上
	 * 再对参数部分进一步解析，将每个参数都存入到属性parameters中。
	 * 
	 * 若该url不含有参数，则直接将url的值赋给requestURI,参数部分不做任何处理。
	 */
	private void parseURL() {
		System.out.println("开始进一步解析url:"+url);
		/*
		 * 思路：
		 * url是否含有参数，可以根据该url中是否含有？来判断。若有则按照？拆分为两部分，
		 * 第一部分为请求部分，第二部分为参数部分，设置到对应属性即可。然后在对参数进行拆分，
		 * 最终将每个参数的名字作为key，值作为value存入到parameters中。
		 * 若不含参数，则直接将url赋值给requestURI即可。
		 */
		int index = url.indexOf("?");
		if(index!=-1) {			
			String[] data = url.split("\\?");
			this.requestURI = data[0];
			if(data.length>1) {
				this.queryString = data[1];
				/*
				 * 对参数部分进行转马操作，将所有%xx的内容按照对应字符集还原为字符串
				 */
				System.out.println("开始对queryString转码");
				System.out.println("转码前："+queryString);
				try {
					queryString = URLDecoder.decode(queryString,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				System.out.println("转码后："+queryString);
			//进一步解析queryString
				parseParameters(queryString);
			}
		}else {
			this.requestURI = url;
		}
		System.out.println("requestURI:"+requestURI);
		System.out.println("queryString:"+queryString);
		System.out.println("parameters:"+parameters);
	}
	/**
	 * 将客户端发送过来的参数进行解析
	 * 格式：name1=value1&name2=value2&name3=value3...
	 */
	private void parseParameters(String line) {		
		String[] query = line.split("&");			
		for(int i = 0;i<query.length;i++) {				
			String[] para = query[i].split("=");
			if(para.length>1) {
				parameters.put(para[0],para[1]);
			}else {
				parameters.put(para[0], "");
			}
		}
	}
	/**
	 * 解析消息头
	 */
	private void parseHeaders() {
		System.out.println("解析消息头");
		/*
		 * 大致步骤：
		 * 1：继续使用readLine方法读若干行内容，每一行应该都是一个消息头
		 * 2：当readLine方法返回值为空字符串时则停止循环读取工作（单独读取到了CRLF时
		 * readLine返回值应当为空字符串）
		 * 3：每当读取一个消息头信息时应当按照“：”拆分为两项，第一项为消息头名字，
		 * 第二项为消息头对应的值，将名字作为key，将值作为value存入到属性headers这个Map中。
		 */
		
		while(true) {				
			String line = readLine();
			if("".equals(line)) {
				break;
			}
			String[] data = line.split(":\\s");		
			headers.put(data[0], data[1]);			
		}
	}
	/**
	 * 解析消息正文
	 */
	private void parseContent() {
		System.out.println("解析消息正文");
		/*
		 * 当一个form表单以post形式提交时，那么表单中的内容会被包含在消息正文中。通过消息头中是否含有Content-Type
		 * 与Content-Length就可以得知是否含有消息正文其消息正文的内容时什么，以便开始解析消息正文。
		 */
		//是否含有消息正文？
		if(headers.containsKey("Content-Length")) {
			int length = Integer.parseInt(headers.get("Content-Length"));
			String type = headers.get("Content-Type");
			System.out.println("消息正文长度："+length);
			System.out.println("消息类型类："+type);
			/*
			 * 根据类型判断正文内容
			 */
			//判断是否为form表单提交的数据
			if("application/x-www-form-urlencoded".equals(headers.get("Content-Type"))) {
				/*
				 * 通过输入流读取指定字节数还原为字符串
				 */
				byte[] data = new byte[length];
				try {
					in.read(data);
					String line  = new String(data,"ISO8859-1");
					System.out.println("正文内容："+line);
					//转码
					line = URLDecoder.decode(line,"UTF-8");
					//解析参数
					parseParameters(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * 通过给定的输入流读取一行字符串（以CRLF结尾）
	 */
	private String readLine() {
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
	public String getMethod() {
		return method;
	}
	public String getUrl() {
		return url;
	}
	public String getProtocol() {
		return protocol;
	}
	public String getHeader(String name) {
		return headers.get(name);
	}
	public String getRequestURI() {
		return requestURI;
	}
	public String getQueryString() {
		return queryString;
	}
	/**
	 * 根据给定的参数名获取对应的参数值
	 * @param name
	 * @return
	 */
	public String getParameters(String name) {
		return this.parameters.get(name);
	}
	
}
