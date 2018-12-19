package io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 在流连接中使用PrintWriter
 * @author soft01
 *
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		FileOutputStream fos = new FileOutputStream("pw2.txt",true);
		OutputStreamWriter  osw = new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw2 = new PrintWriter(bw);
		pw2.println("窗前明月光");
		pw2.println("呵呵呵");
		System.out.println("写出完毕");
		pw2.close();
		
	}

}
