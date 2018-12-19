package collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 删除集合元素
 * 
 */
public class RemoveDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,5));
		c.add(new Point(4,5));
		c.add(new Point(5,6));
		c.add(new Point(1,2));
		System.out.println(c);
		Point p = new Point(1,2);
		/*
		 * 删除也是依靠元素equals比较的结果
		 * 若集合中有相同元素，则只会删除前面的一个。不会全部都删。
		 * removeALL会删除所有交集中的元素。如有重复，则全删除。
		 */
		c.remove(p);
		System.out.println(c);
	}
}
