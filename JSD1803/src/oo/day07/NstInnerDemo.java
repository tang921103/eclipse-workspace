package oo.day07;
public class NstInnerDemo {
	public static void main(String[] args) {
		Coo o1 = new Coo() {
			
		};
		Doo o3 = new Doo() {
			void show() {
				System.out.println("showshow");
			}
		};
		o3.show();
	}
}
abstract class Doo{
	abstract void show();
}

abstract class Coo{
	
}
