package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用当前类的实例测试对象流读写对象的操作
 * 
 * 当一个类的实例要被对象流进行读写时，要求该类必须实现Serializable接口
 * @author soft01
 *
 */
public class Person implements Serializable{
	/*
	 * 当一个类实现了Serializable接口后，应当定义一个常量：serialVersionUID
	 * 这个常量是系列化版本号。若不指定，编译器会在编译时按照当前类的结构生成一个序列号。
	 * 但是类的结构发生变化，版本号会跟着改变。
	 * 序列化版本号直接影响对象输入流进行反序列化是否能够成功。
	 * 当反序列化的对象对当前版本号一致，那么反序列化成功，否则反序列化时会抛出异常。
	 * 若当前类的结构发生了变化，只要版本号没有改变，那么反序列化时会将仍然有的属性进行还原。
	 */
	private static final long serialVersionUID = 1L;
	private String name ;
	private int age ;
	private String address;
	private String gender;
	/*
	 * 当一个属性使用transient修饰后，那么在进行序列化时，该属性的值会被忽略。
	 * 忽略不必要的属性可以达到对象序列化的“瘦身”操作。
	 */
	private transient String[] otherInfo;
	public Person(String name,int age,String address,String gender,String[] otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}
	public String toString() {
		return name+","+age+","+gender+","+Arrays.toString(otherInfo);
	}
}
