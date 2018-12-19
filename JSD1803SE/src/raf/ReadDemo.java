package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取一个字节
 * @author soft01
 *
 */
public class ReadDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * int read()
		 * 读取一个字节，并以int形式返回
		 * 若返回值为-1，则表示读取到了文件末尾
		 * 
		 */
		RandomAccessFile raf = new RandomAccessFile("./raf.dat","r");
		int d = raf.read();
		System.out.println(d);
	}

}
