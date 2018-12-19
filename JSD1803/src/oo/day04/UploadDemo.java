package oo.day04;
public class UploadDemo {
	public static void main(String[] args) {		
		Aoo a1 = new Aoo();
		a1.a = 1;
		a1.show();
	//	a1.b = 2; 编译错误
		Boo b1 = new Boo();
		b1.b = 2;
		b1.test();
		b1.a = 3;
		b1.show();
	//	Boo b2 = new Aoo();编译错误，派生类不能访问超类的
		Aoo a2 = new Boo(); //超类可以访问派生类的
		a2.a= 1;
		a2.show();
		//a2.b =  1;编译错误。能点出来什么，看引用的类型
	}
}
class Aoo{
	int a ;
	void show() {
		
	}
}
class Boo extends Aoo{
	int b ;
	void test() {
		
	}
}