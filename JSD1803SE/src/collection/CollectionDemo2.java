package collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 集合存放的是引用的地址。
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Point p = new Point(1,2);
		c.add(p);//传参数都是值传递。引用传的都是地址。
		System.out.println(c);
		System.out.println(p);
		p.setX(2);
		System.out.println(c);
		System.out.println(p);
	}
}
