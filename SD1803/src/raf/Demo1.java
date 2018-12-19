package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("姓名");
		String name = scan.nextLine();
		System.out.println("密码");
		String password = scan.nextLine();
		System.out.println("昵称");
		String nickname = scan.nextLine();
		System.out.println("年龄");
		int age = scan.nextInt();
		RandomAccessFile raf = new RandomAccessFile("user.dat","rw");
		raf.seek(raf.length());
		byte[] data = name.getBytes("utf-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		data = password.getBytes("utf-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		data = nickname.getBytes("UTF-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		raf.writeInt(age);
		raf.close();
	}
}
