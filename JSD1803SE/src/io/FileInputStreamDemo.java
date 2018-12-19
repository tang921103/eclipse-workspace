package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 文件输入流，用于读取数据
 * 
 */
public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		byte[] data = new byte[200];
		int len = fis.read(data);
		String str = new String(data,0,len,"UTF-8");
		System.out.println(str);
		System.out.println("读取完毕");
		fis.close();
	}

}
