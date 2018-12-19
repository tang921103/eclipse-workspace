package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流：
 * 对象流时一对高级流，可以方便我们读写java中的任何对象。
 * 对象输出流：可以将指定的对象转换为一组字节后写出
 * 对象输入流：可以将一组字节还原为对应的对象，前提是这组字节应当是对象输出
 * 流将一个对象转换的字节。
 * 
 * @author soft01
 *
 */
public class ObjectOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		String name = "苍老师";
		int age = 18;
		String address = "japan";
		String gender = "女";
		String[] otherInfo = {"是一名演员","德艺双馨"};
		/*
		 * 将该person对象写入到文件person.obj中
		 * 
		 */
		
		Person p = new Person(name,age,address,gender,otherInfo);
		FileOutputStream fos = new FileOutputStream("person.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		/*
		 * 对象输出流提供的方法
		 * void writeObject(Object obj)可以将给定的对象转换为一组字节
		 * 
		 * 当一个类的实例要被对象流进行读写时，要求该类必须实现Serializable接口
		 * 
		 * 下面代码实际做了两件事：
		 * 1.p对象先经对象输出流，而对象输出流将该对象转换为了一组字节，这个过程称为
		 * 对象序列化；
		 * 2.转换这组字节再流经文件输出流，然后写入了文件保存（写入磁盘），
		 * 将数据写入磁盘做长久保存的过程称为数据持久化。
		 * 
		 */
		oos.writeObject(p);
		System.out.println(p);
		oos.close();
	}

}
