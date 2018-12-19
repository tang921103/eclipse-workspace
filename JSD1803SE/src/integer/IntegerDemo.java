package integer;
/**
 * 由于基本类型不能直接参与面向对象的开发，所以
 * java提供了8个基本类型所对应的包装类，从而可以将基本类型转换为“对象”，
 * 这样就可以参与面向对象的模式进行开发了。
 * 
 * 6个数字类型的包装类继承自java.lang.Number
 * Number是一个抽象类。定义了可以让数字类型之间进行互转的方法。
 */
public class IntegerDemo {
	public static void main(String [] args) {
		int d = 128;
		Integer i1 =  new Integer(d);
		Integer i2 =  new Integer(d);
		System.out.println(i1==i2);//对象地址不同
		System.out.println(i1);
		Integer i3 = Integer.valueOf(d);
		Integer i4 = Integer.valueOf(d);
		System.out.println(i3==i4);// true  重用同一个对象（仅限一个字节的数字）
		//包装类转换为基本类型
		int in = i1.intValue();
		double du = i1.doubleValue();
		System.out.println(du);
		byte by = i1.byteValue();
		System.out.println(by);
	}
}
