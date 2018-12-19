package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流：缓冲流是一对高级流。
 * java.io.BufferedOutputStream
 * java.io.BufferedInputStream
 * 缓冲字节输入输出流是用来加快读写效率的。
 * 
 * 使用缓冲流完成复制操作
 * 
 * @author soft01
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 使用了缓冲流读写时，我们就不用关注必须用块读写加快效率了。
		 * 因为缓冲流内部维护了一个字节数组，最终会将我们的读写操作转换为块读写加快读写效率的。
		 */
		FileInputStream fos = new FileInputStream("fos.txt");
		BufferedInputStream bos = new BufferedInputStream(fos);
		FileOutputStream fis = new FileOutputStream("fos_cp.txt");
		BufferedOutputStream bis = new BufferedOutputStream(fis);
		int d =-1;
		while((d= bos.read())!=-1) {
			bis.write(d);
		}
		System.out.println("复制完毕");
		bis.close();
		bos.close();
	}
	

}
