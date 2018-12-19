package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
	private ServerSocket server;
	private PrintWriter[] allout = {};
	public Server() {
		try {
			server = new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start() {
		while(true) {
			try {
				Socket socket = server.accept();
				ClientHandler ch = new ClientHandler(socket);
				Thread t = new Thread(ch);
				t.start();
				System.out.println("一个客户端连接上了");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	private class ClientHandler implements Runnable {
		private Socket socket;
		public ClientHandler(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			PrintWriter pw = null;
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8")),true);
				synchronized(allout) {
					allout = Arrays.copyOf(allout,allout.length+1);
					allout[allout.length-1] = pw;			
				}
				String message = null;
				while((message = br.readLine())!=null) {
					System.out.println("客户端消息："+message);
					for(int i =0;i<allout.length;i++) {
						allout[i].println(message);
					}
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				synchronized(allout) {
					for(int i =0;i<allout.length;i++) {
						if(pw == allout[i]) {
							allout[i] = allout[allout.length-1];
							allout = Arrays.copyOf(allout, allout.length-1);
						}
					}			
				}
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
