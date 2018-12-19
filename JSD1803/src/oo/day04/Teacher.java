package oo.day04;

public class Teacher extends Person{
	 double salary;
	 Teacher(String name,int age,String address,double salary){
		 super(name,age,address);
		 this.salary =salary;
	 }
	 void sayHi() {
			System.out.println("姓名"+name+"年龄"+age+"地址"+address+"工资"+salary);		
		}
}
