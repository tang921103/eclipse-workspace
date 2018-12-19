package oo.day03;

public class SuperDemo {
	
	public static void main(String[] args) {	
		Aoo a = new Aoo();
	}
}
class 	Boo{
	Boo(){
		System.out.println("超类构造方法");
	}
}
class Aoo extends Boo{
	Aoo(){
		System.out.println("派生类的构造方法");
	}
}
class Coo{
	Coo(int a ){
		
	}
}
class Doo extends Coo{
	Doo(){
		super(4);
	}
}






