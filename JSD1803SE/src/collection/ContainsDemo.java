package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * boolean contains(E e)
 * 判断当前集合是否包含给定元素
 * 
 * @author soft01
 *
 */
public class ContainsDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		System.out.println(c);// 自动调用toString的结果
		Point p  = new Point(1,2);
		/*
		 * 集合是用给定的元素与现有元素进行equals比较，若有比较为
		 * true则认为集合包含该元素。所以元素的equals方法直接影响集合的
		 * contains方法的结果。
		 * （Object中提供的equals方法是用“==”进行判断的，除非指向同一个对象，即地址一样结果才能为true）
		 */
		boolean contains = c.contains(p);
		System.out.println(contains);
	}
}
