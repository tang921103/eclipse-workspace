package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * Collention提供了统一的获取元素的操作:遍历
 * 而遍历集合使用的是迭代器模式：
 * Iterator iterator()
 * 该方法获取一个可以用于遍历当前集合的迭代器 
 * 
 * java.util.Iterator
 * Iterator 是一个接口，定义了迭代器遍历集合的相关操作方法。
 * 不同的集合都提供了一个迭代器实现类。
 * 
 * 迭代器遍历集合遵循：问、取、删的步骤，其中删除元素不是必要的操作。
 * @author soft01
 *
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		System.out.println("c:"+c);
		Iterator it = c.iterator();
		/*
		 * boolean hasNext()
		 * 判断当前集合是否还有元素可以迭代
		 *  
		 *  E next（）
		 *  获取下一个元素
		 */
		while(it.hasNext()) {
			String str = (String)it.next();
			if("#".equals(str)) {
				/*
				 * 迭代器要求在遍历集合的过程中不能通过集合的方法增删元素，
				 * 否则会抛出异常。
				 * 迭代器提供了remove方法，删除元素就是通过next遍历出来的元素。
				 */
				c.remove(str);
			}
			System.out.println(str);
		}
		System.out.println("c:"+c);
	}
}
