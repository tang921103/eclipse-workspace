package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲字符流
 * java.io.BufferedWriter
 * java.io.BufferedReader
 * 内部有缓冲区，可以块读写字符。并且可以按照行读写字符串。
 * 
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流，内部总是会连接BufferedWriter作为缓冲操作。
 * 
 * @author soft01
 *
 */
public class PrintWriterDemo1 {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		/*
		 * PrintWriter提供了直接对文件写操作的构造方法
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 */
		PrintWriter pw = new PrintWriter("pw.dat","UTF-8");
		pw.println("你在南方的艳阳里大雪纷飞");
		pw.println("我在北方的寒夜里四季如春");
		System.out.println("写出完毕");
		pw.close();
	}
}
