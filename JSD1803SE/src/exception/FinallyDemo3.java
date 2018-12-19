package exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * JDK1.7之后退出了一个新特性：自动关闭
 * 
 * @author soft01
 *
 */
public class FinallyDemo3 {
	public static void main(String [] args) {
		/*
		 * 实现了AutoCloseable接口的可以定义在这里
		 * 该特性是编译器认可，最终编译器还是会将代码在finally中关闭的。
		 */
		try(FileInputStream fis = new FileInputStream("bos.txt")){
			byte[] data = new byte[5];
			 fis.read(data);
			System.out.println(new String(data,"utf-8"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}	
}
