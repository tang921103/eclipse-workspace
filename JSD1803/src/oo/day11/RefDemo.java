package oo.day11;
public class RefDemo {
	public static void main(String[] args) {
		Student stu1 = new Student();
		Student stu2 = stu1;
		stu1.age =22;
		stu2.age = 23;
		int a = 1;
		int b = a;
		a = 2;b= 4;
	}
}
class Student{
	String name;
	int age ;
}