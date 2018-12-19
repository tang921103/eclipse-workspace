package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 写出字符串操作
 * @author soft01
 *
 */
public class WriteStringDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 在相对路径中"./"可以不写，不写默认也是在当前目录中。
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.txt","rw");
		/*
		 * String 提供的方法
		 * byte[] getBytes()
		 * 将当前字符串按照系统默认字符集转换为一组字节
		 * 
		 * byte[] getBytes(String csn)
		 * 将当前字符串按照指定字符集转换为一组字节。推荐使用这种方式转换字符串
		 * 因为按照系统默认字符集转换会导致跨平台出现乱码问题。
		 * 
		 * 
		 * GBK：国标编码 ，中文占2字节
		 * UTF-8：万国码，对unicode进行编码，变长编码集，英文1字节，中文3字节
		 * ISO8859-1：欧洲编码集，不支持中文。
		 */
		String str = "让我再看你一眼，从南到北。";
		byte[] data = str.getBytes("gbk");
		raf.write(data);
		raf.write("像是北五环路，蒙住双眼".getBytes("gbk"));
		System.out.println("复制完毕");
		raf.close();
	}

}
