package object;
/**
 * 测试Point重写的 Object方法
 * @author soft01
 *
 */
public class TestPoint {
	public static void main(String[] args) {
		Point p = new Point(1,2);
		/*
		 * Object定义的toString方法返回的是该对象的地址信息，实际开发中意义不大。
		 * 所以若我们要使用，通常会重写该方法。
		 * 注意：java提供给我们的类妥善重写过该方法，
		 * 只有我们自己定义的类通常需要重写。
		 */
		String str = p.toString();
		System.out.println(str);//输出的是地址
		/*
		 * System.out.println(Object o)
		 * 该方法会将给定的对象toString方法返回的字符串输出到控制台。
		 */
		System.out.println(p);
		Point p2 = new Point(1,2);
		System.out.println(p==p2);
		System.out.println(p.equals(p2));
	}
}
