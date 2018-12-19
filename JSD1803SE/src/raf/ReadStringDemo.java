package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字符串
 * @author soft01
 *
 */
public class ReadStringDemo {

	public static void main(String[] args) throws IOException {
	RandomAccessFile raf= new RandomAccessFile("raf.txt","r");
	byte[] data = new byte[(int)raf.length()];
	raf.read(data);
	String str = new String(data,"gbk");
	System.out.println(str);
	raf.close();
	}

}
