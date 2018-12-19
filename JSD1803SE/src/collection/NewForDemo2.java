package collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 使用新循环遍历集合
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		System.out.println(c);
		/*
		 * 新循环遍历集合就是迭代器遍历集合，所以在遍历的过程中不能
		 * 通过集合的方法增删元素。
		 */
		for(Object obj:c) {//集合里面的元素都是Object类型的
			String str = (String)obj;
//			if("#".equals(str)) {
//				c.remove(str);
//			}
			System.out.println(str);
		}
	}
}
