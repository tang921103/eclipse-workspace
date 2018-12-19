package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java 将流按照读写单位划分为字节流和字符流
 * 
 * 字符流：读写单位是以字符为单位，所以字符流读写数据有一定的局限性，只能读写文本数据。
 * 非文本数据不能使用字符流读取（如图片、基本数据类型、mp3等）
 * 
 *
 * java.io.Reader
 * java.io.Writer
 * Reader 是所有字符输入流的父类
 * Writer 是所有字符输出流的父类
 * 
 * 
 * 转换流：
 * java.io.InputStreamReader
 * java.io.OutputStreamWriter
 * 他们是一对高级流，同时也是常用的字符流实现类。
 * 在读写文本数据时，使用高级流进行连接时非常重要的一环，起到承上启下的作用。
 * 因为几乎所有的字符流都只能连接在其他字符流上，而基本上低级流都是字节流，
 * 由于转换可以连接字节流，而本身其自身又是字符流，所以起到将字读流与字节流“对接”的作用。
 * 
 * @author soft01
 *
 */
public class OutPutStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new  FileOutputStream("osw.txt",true);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		osw.write("让我再看你一眼 ，从南到北。");
		osw.write("就像北五环路");
		System.out.println("写出完毕");
		osw.close();
	}
	
}
