package integer;

public class Demo1 {
	public static void main(String[] args) {
		int d = 128;
		Integer i1 = new Integer(d);
		Integer i2 = new Integer(d);
		System.out.println(i1==i2);
		
		Integer i3 = Integer.valueOf(d);
		Integer i4 = Integer.valueOf(d);
		System.out.println(i3==i4);
		
		int a = i1.intValue();
		System.out.println(a);
		
	}
}
