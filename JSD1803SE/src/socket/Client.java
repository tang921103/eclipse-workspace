package socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 聊天室客户端
 * @author soft01
 *java.net.Socket 套接字
 *封装了TCP协议通讯。使用它可以很方便的以TCP协议为通讯方式进行数据传输。
 */
public class Client {
	private Socket socket;
	/*
	 * 构造方法，用来初始化客户端
	 */
	public Client() {
		/*
		 * 实例化Socket时需要传入两个参数，
		 * 1.服务端ip地址
		 * 2.服务端端口号
		 * 通过ip地址可以找到服务端计算机，通过端口可以找到运行在
		 * 服务端计算机的服务端应用程序。
		 * 实例化的过程就是连接的过程。若连接失败，那么这里会抛出异常。
		 */
		try {
			System.out.println("正在连接服务端");
			socket = new Socket("localhost",8088);
			System.out.println("已连接");
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 客户端开始工作的方法
	 */
	public void start() {
		try {		
			//先启动读取服务端消息的线程
			ServerHandler handler = new ServerHandler();
			Thread  t = new Thread(handler);
			t.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")),true);
			//创建输入流读取服务端消息
			System.out.println("请输入");			
			String message = null;		
			while(true) {
				message = br.readLine();
				pw.println(message);				 
			}		
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	public static void main(String [] args) {
		Client client = new Client();
		client.start();
	}
	private class ServerHandler implements Runnable{
		public void run() {
			//创建输入流读取服务端消息
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
				String message = null;
				while((message = in.readLine())!=null) {
					System.out.println(message);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
