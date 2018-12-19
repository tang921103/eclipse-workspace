package oo.day04;

public class OverrideDemo {

	public static void main(String[] args) {	
		
	}
}
class Coo{
	void study() {} 
	int show() {return 1;}
	Coo test() {return null;}
	
}
class Doo extends Coo{
	void study(){}//无返回值时必须相等
		int show() {return 2;}//返回值为基本类型时也必须
      //	Aoo test() {return null;}// 编译错误，派生类的返回值类型必须小于或等于超类的返回值类型（超类>派生类)
}