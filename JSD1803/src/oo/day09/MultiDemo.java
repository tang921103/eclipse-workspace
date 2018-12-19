package oo.day09;
public class MultiDemo {
	public static void main(String[] args) {
	Moo o = new Noo();
	Noo o1 = (Noo)o;
	Inter8 o2 = (Inter8)o;
	if(o instanceof Poo) {
		Poo o3 = (Poo)o;
	}
	
	}
}
interface Inter8 {
	
}
class Moo{
	
}
class Noo extends Moo implements Inter8{
	
}
class Poo extends Moo{
	
}
