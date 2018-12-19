package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成用户注册操作
 * 用户信息包含：用户名 密码 昵称 年龄
 * 其中年龄是int值  其他三项是字符串
 * 
 * 每个用户的信息都要写入文件user.dat中保存
 * 每条记录的长度固定为100字节，其中用户名、密码、昵称三项各占32字节，年龄int 值固定为4字节。
 * 
 * 字符串“留白”操作便于修改内容。不会影响整个文件的格式。
 * @author soft01
 *
 */
public class Demo1 {
	public static void main(String[] args) throws IOException {
		System.out.println("欢迎注册");
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入用户名");
		String name = scan.nextLine();
		System.out.println("请输入密码");
		String password = scan.nextLine();
		System.out.println("请输入昵称");
		String nickname = scan.nextLine();
		System.out.println("请输入年龄");
		int age = Integer.parseInt(scan.nextLine());
		
		System.out.println("用户名："+name);
		System.out.println("密码："+password);
		System.out.println("昵称："+nickname);
		System.out.println("年龄："+age);
		
		RandomAccessFile raf = new RandomAccessFile("user.dat","rw");
		raf.seek(raf.length());
		byte[] data = name.getBytes("UTF-8");
		data = Arrays.copyOf(data, 32);
		raf.write(data);
		data = password.getBytes("UTF-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		data = nickname.getBytes("UTF-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		raf.writeInt(age);
		System.out.println("注册完成");
		raf.close();
	}
}
