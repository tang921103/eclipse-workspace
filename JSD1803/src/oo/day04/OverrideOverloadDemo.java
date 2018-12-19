package oo.day04;

public class OverrideOverloadDemo {

	public static void main(String[] args) {	
		Goo goo = new Goo();
		Eoo o = new Foo();
		goo.test(o);
	}
}
class Goo{
	void test(Eoo o) {
		System.out.println("超类型参数");
		o.show();
	}
	void test(Foo o) {
		System.out.println("派生类型参数");
		o.show();
	}
}
class Eoo{
	void show() {
		System.out.println("超类show");
	}
}
class Foo extends Eoo{
	void show() {
		System.out.println("派生类show");
	}
}