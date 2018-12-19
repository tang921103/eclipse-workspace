package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class Client {
	private Socket socket;
	public Client() {
		try {
			socket = new Socket("localhost",8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			Handler h = new Handler();
			Thread t = new Thread(h);
			t.start();
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in,"utf-8"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8")),true);
			String message = null;
		while((message = br.readLine())!=null) {
				pw.println(message);
		}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		Client c = new Client();
		c.run();
	}
	private class Handler implements Runnable{
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				String message = null;
				while((message = br.readLine())!=null) {
					System.out.println("服务端消息："+message);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
