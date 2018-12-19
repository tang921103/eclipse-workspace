package io;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
/**
 * 使用PrintWriter，用流连接形式创建。
 * 完成记事本功能
 * 将控制台输入的每一行字符串写入文件note.txt中
 * @author soft01
 *
 */
import java.util.Scanner;
public class PrintWriterDemo3 {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner scan = new Scanner(System.in);
		/*
		 * PrintWriter的构造方法若第一个参数是一个流，那么就支持第二个参数，
		 * 该参数为boolean型，若值为true，那么pw就具有了自动行刷新的功能。
		 * 即：每当使用Println方法写出一行字符串后会自动flush().
		 * 注意：调用print()方法时不会自动行刷新的。
		 */
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("note.txt"))),true);
		System.out.println("请输入");	
		String str = null;
		while(true) {
			if("exit".equals(str)) {
				System.out.println("退出");
				break;
			}
			str = scan.nextLine();
			pw.println(str);
		}
		System.out.println("再见");
		pw.close();
	}
}
