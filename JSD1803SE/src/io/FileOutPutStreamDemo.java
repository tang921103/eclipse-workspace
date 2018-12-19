package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java标准的IO操作，Input,Output输入与输出
 * 流按照功能分为读写，按照方向分为输入和输出。
 * 而方向的参照物为我们写的程序。
 * 输入流用来读取数据
 * 输出流用来写出数据
 * 
 * java.io.InputStream是所有字节输入流的父类，
 * 规定了所有输入流有应当具备的读取字节数据的相关方法。
 * java.io.OutputStream是所有字节输出流的父类。
 * 
 * java将流分为两大类：节点流和处理流。
 * 节点流：又称为低级流，是实际连接程序与另一端的“管道”，
 * 负责实际搬运数据。读写一定是建立在低级流的基础之上进行的。
 * 处理流：又称为高级流，不能独立存在（没意义），高级流一定会连接在其他流上，
 * 使得数据“流经”该流时对其进行加工处理，简化我们对数据读写时的某些操作。
 * 
 * 文件流：
 * 文件流是一对低级流，用于读写文件数据。功能与RAF一样。但是底层的读写方式不同，
 * 流是顺序读写，而RAF是基于指针随机读写的。
 * 
 * @author soft01
 *
 */
public class FileOutPutStreamDemo {
	public static void main (String [] args) throws IOException {
	/*
	 * 向文件fos.txt中写出字符串
	 * 流有两种常见创建方式：
	 * FileOutputStream(String path)
	 * FileOutputStream(File file)
	 * 以上两种创建方式是覆盖写模式，即若要操作的文件已经存在，
	 * 会将该文件数据清除，然后通过该流写出的数据作为该文件数据。
	 * 
	 * FileOutputStream(String path,boolean append)
	 * FileOutputStream(File file,boolean append)
	 * 当第二个参数为true时，该流为追加模式，即该文件原有数据全部保留，
	 * 通过流写出的数据会被追加到文件后面继续写。
	 */
		FileOutputStream fos = new FileOutputStream("fos.txt",true);
		String str = "哈哈哈哈哈哈哈哈,像一颗海草,随风飘摇";
		fos.write(str.getBytes("UTF-8"));
		System.out.println("写出完毕");
		fos.close();
	}
}
