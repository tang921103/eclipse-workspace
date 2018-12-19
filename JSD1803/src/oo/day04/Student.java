package oo.day04;

public class Student extends Person{
	int studId;
	Student(String name,int age,String address,int studId){
		super(name,age,address);
		this.studId = studId;
	}
	void sayHi() {
		System.out.println("姓名"+name+"年龄"+age+"地址"+address+"学号"+studId);		
	}
}

