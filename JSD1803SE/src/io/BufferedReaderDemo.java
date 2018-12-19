package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流，可以按行读取字符串
 * @author filter
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {	
		/*
		 * 将当前代码读取出来并输出到控制台
		 */
		FileInputStream fis = new FileInputStream("src/io/BufferedReaderDemo.java");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		/*
		 * BufferedReader提供了直接读取一行字符串的方法
		 * String readLine()
		 * 该方法会连续读取若干字符，当读取到换行符时，将之前读取的字符一字符串的形式返回，
		 * 若返回值为null，表示流的末尾。
		 */
		String line = null;
		while((line = br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();	
	}
}
