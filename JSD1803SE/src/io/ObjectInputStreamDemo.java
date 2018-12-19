package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流，用于进行对象反序列化操作
 * 需要注意，对象流读取的字节必须是由对象输出流将一个对象序列化后的字节，
 * 否则进行反序列化时会抛出异常
 * @author soft01
 *
 */
public class ObjectInputStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	FileInputStream  fis = new  FileInputStream("person.obj");
	ObjectInputStream ois = new ObjectInputStream(fis);
	Person p = (Person)ois.readObject();
	System.out.println(p);
	ois.close();
	}

}
