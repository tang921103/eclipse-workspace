package day06;

public class MethodDemo {

	public static void main(String[] args) {
		
			say();
			sayHi("唐秋");
			int m = sum(1,100);
			System.out.println(m);
			double a = getNum();
			System.out.println(a);
			int count = plus(1,99);
			System.out.println(count);
			int  a1 = 11, a2 = 9;
			int c = plus(a1,a2);
			System.out.println(c);
			a();
			
	}
	
	public static double getNum() {
		return 9.36;
	}
	public static int plus(int num1, int num2) {
		int num = num1+ num2;
		return num;
	}
	public static void say() {
		System.out.println("大家好，我是唐秋");
	}
	public static void sayHi(String name) {
		System.out.println("大家好，我叫"+name);
	}
	public static int sum(int a,int b) {

		int  sign  = 0 ;
		for(int i = a;i<=b-a+1;i++) {
			sign = sign + i;
		}
		return sign;
	}
	
	public static void a() {
		b();
		System.out.println("111");
	}
	public static void b() {
		c();
		System.out.println("222");
	}
	public static void c() {
		System.out.println("333");
	}
}


