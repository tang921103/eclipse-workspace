package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		RandomAccessFile raf = new RandomAccessFile("user.dat","r");
		System.out.println("姓名");
		String name = scan.nextLine();
		System.out.println("密码");
		String password = scan.nextLine();
		boolean flag = true;
		for(int i =0;i<raf.length()/100;i++) {
			raf.seek(i*100);
			byte[] data = new byte[32];
			raf.read(data);
			String username = new String(data,"utf-8").trim();
			if(name.equals(username)) {
				raf.read(data);
				String pwd = new String(data,"utf-8").trim();
				if(password.equals(pwd)) {
					System.out.println("登录成功");
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			System.out.println("用户名或密码错误");
		}
	}
}
