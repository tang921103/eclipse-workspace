package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成文件的复制操作
 * 
 * @author soft01
 *
 */
public class CopyDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * 使用文件输入流读取原文件，使用文件输出流往新文件里写。
		 * 使用块读写将原文件数据写入到新的文件完成复制。
		 */
		FileInputStream fos = new FileInputStream("fos.txt");
		FileOutputStream fis = new FileOutputStream("fis.txt");
		byte[] data = new byte[1024];
		int len = -1;
		while((len = fos.read(data))!=-1) {
			fis.write(data,0,len);
		}
		System.out.println("复制完成");
		fos.close();
		fis.close();
	}

}
