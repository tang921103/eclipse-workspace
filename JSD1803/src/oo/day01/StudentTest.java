package oo.day01;

public class StudentTest {

	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.name = "唐秋";
		stu1.age = 25;
		stu1.address = "恩施";
	    stu1.study();
	    stu1.sayHi();
		Student stu2 = new Student();
		
		stu2.study();
		stu2.sayHi();
	
		
	}
	void eat() {		
	}

}
