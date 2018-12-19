package exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 异常处理机制在io中的使用
 * @author soft01
 *
 */
public class FinallyDemo2 {
	public static void main(String []args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("bos.txt");
			int d = fis.read();
			System.out.println(d);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) {
					fis.close();
				}				
			}catch(IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
