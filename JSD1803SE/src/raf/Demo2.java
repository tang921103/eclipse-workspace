package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 列出所有注册用户的信息
 * @author soft01
 *
 */
public class Demo2 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("user.dat","r");
		for(int i = 0;i<raf.length()/100;i++) {
			raf.seek(i*100);
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"UTF-8").trim();
			raf.read(data);
			String password = new String(data,"UTF-8").trim();
			raf.read(data);
			String nickname = new String(data,"UTF-8").trim();
			int age = raf.readInt();
			System.out.println(name+","+password+","+nickname+","+age);
		}
	}

}
