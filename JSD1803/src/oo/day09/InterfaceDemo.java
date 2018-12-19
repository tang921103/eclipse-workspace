package oo.day09;
public class InterfaceDemo {
	public static void main(String[] args) {
		//Inter4 o1 = new Inter4();
		Inter4 o2 = new Eoo();
		Inter3 o3 =  new Eoo();
	}
}
interface Inter1 {
	public static final double  PI = 3.14;
	public abstract void show();
}
interface Inter2{
	public abstract void a();
	public abstract void b();
}
class Aoo implements Inter2{
	public void a() {}
	public void b() {}
}
interface Inter3{
	public abstract void c();
}
class Boo implements Inter2,Inter3{
	public void b() {}
	public void a() {}
	public void c() {}
}
abstract class Coo{
	public abstract void d();
}
class Doo extends Coo implements Inter2,Inter3{
	public void d() {}
	public void a() {}
	public void b() {}
	public void c() {}
}
interface Inter4 extends Inter3{
	public void e();
}
class Eoo implements Inter4{
	public void c() {}
	public void e() {}
}
interface Inter5 extends Inter1,Inter2,Inter3{
	
}





