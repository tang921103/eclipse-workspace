package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 转换流
 * InputStreamReader,可以读取字符
 * 
 * @author soft01
 *
 */
public class InputStreamReaderDemo {
	public static void main(String [] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr  = new InputStreamReader(fis,"UTF-8");
		int d = -1;
		while((d = isr.read())!=-1) {
			System.out.print((char)d);
		}
		System.out.println("读取完毕");
		isr.close();
	}
}
