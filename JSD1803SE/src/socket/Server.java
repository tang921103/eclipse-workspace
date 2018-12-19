package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 聊天室服务端
 * @author soft01
 *
 */
public class Server {
/*
 * 运行在服务端的java.net.ServerSocket
 * 主要有两个作用：
 * 1.向系统申请服务端口，客户端就是通过这个端口与服务端建立连接的。
 * 2.监听服务端口，等待客户端连接。一旦一个客户端通过服务端口与服务端建立连接，
 * 那么ServerSocket会主动创建一个Socket与客户端进行通讯。
 */
	private ServerSocket  server;
	/*
	 * 由于ClientHandler是Server的内部类，那么在Server上定义的属性可以被ClientHandler
	 * 的实例访问，从而可以用于让所有ClientHandler共享的数据使用。
	 */
//	private PrintWriter[] allout = {};
	private List<PrintWriter> allout = new ArrayList<PrintWriter>();
	/*
	 * 用来初始化服务端
	 */
	public Server() {
		try {
			System.out.println("启动服务端");
			server = new ServerSocket(8088);
			System.out.println("服务端启动完毕");
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	/*
	 * 服务端开始工作的方法
	 */
	public void start() {
		/*
		 * ServerSocket提供的方法：
		 * Socket accept()
		 * 该方法是一个阻塞方法，调用后进入阻塞，直到一个客户端连接为止，
		 * 这时该方法会返回一个Socket，通过这个Socket可以与刚建立连接的
		 * 客户端进行通讯。
		 */
		try {		 
			while(true) {
				System.out.println("等待客户端连接");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了");
				//启动一个线程，处理该客户端交互工作
				Runnable handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String [] args) {
		Server server = new Server();
		server.start();
		
	}
	private class ClientHandler implements Runnable{
		//当前线程通过这个socket与客户端交互
		private Socket socket;
		public ClientHandler(Socket socket) {
			this.socket = socket;
		}
			public void run() {	
				PrintWriter pw = null;
				System.out.println("启动了一个线程处理客户端交互");
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
					/*
					 * 通过Socket获取输出流，用于给客户端发送消息
					 */
				 pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")),true);
					/* 
					 * 将该输出流存入allout中，以便其他的ClientHandler可以将消息发送给当前客户端
					 * 
					 */
				 //多个线程操作同一资源，形成“抢”的局面，应该考虑并发安全问题。
				 synchronized(allout) {
					 // 1.先扩容allout
//					 allout = Arrays.copyOf(allout,allout.length+1);
//					//2.将当前客户端的输入流存入新的数组最后
//					 allout[allout.length-1] = pw;
					 allout.add(pw);
				 	}
					System.out.println("当前在线人数："+allout.size());
					/*
					 * 当客户端与服务端断开连接时，不同系统的客户端在服务端这边的体现不太一样
					 * windows的客户端断开时，服务端这里br.readLine()方法通常会直接抛出异常
					 * linux的客户端断开时，服务端br.readLine()方法会返回null
					 */
					String message = null;
					while((message = br.readLine())!=null) {
						System.out.println(message);
						// 将消息发送给客户端
						//遍历allout数组，转发消息
						synchronized(allout) {
//							for(int i = 0;i<allout.length;i++) {
//								allout[i].println(message);
//							}	
							for(PrintWriter o:allout) {
								o.println(message);
							}
						}
					}
				} catch (UnsupportedEncodingException e) {					
					e.printStackTrace();
				} catch (IOException e) {				
					e.printStackTrace();
				}finally {
					//处理客户端断开连接的操作
					//将该客户端的输出流从共享数组中删除
					synchronized(allout) {
//						for(int i = 0;i<allout.length;i++) {
//							if(allout[i]==pw) {
//								allout[i] = allout[allout.length-1];
//								allout = Arrays.copyOf(allout,allout.length-1);
//								break;
//							}
//						}
						allout.remove(pw);
					}
					System.out.println("当前在线人数："+allout.size());
					//关闭socket，释放资源
					if(socket!=null) {
						try {
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
	}
}
