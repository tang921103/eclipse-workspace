package object;

public class Test {
	public static void main(String[] args) {
		Point p1 = new Point(1,2);
		System.out.println(p1);
		Point p2 = new Point(1,2);
		System.out.println(p2);
		boolean flag = p1.equals(p2);
		System.out.println(flag);
	}
}
