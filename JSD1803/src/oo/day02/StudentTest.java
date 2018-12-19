package oo.day02;

public class StudentTest {

	public static void main(String[] args) {			
		Student zs = new Student("张三");
		Student ls = new Student("李四",25);
		Student ww = new Student("王五",26,"重庆");
		zs.sayHi();
		ls.sayHi();
		ww.sayHi();
	}
}
