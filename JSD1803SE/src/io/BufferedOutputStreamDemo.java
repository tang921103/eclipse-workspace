package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲输出流写数据时的缓冲区问题
 * @author soft01
 *flush() 强制将缓冲区数据一次性写出
 */
public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fis = new FileOutputStream("bos.txt");
		BufferedOutputStream bis = new BufferedOutputStream(fis);
		String str = "夜空中最亮的星，能否听清，那仰望的人心底的孤独和叹息";
		byte[] data = str.getBytes("UTF-8");
		bis.write(data);
		bis.flush();
		System.out.println("写出完毕");
	}

}
