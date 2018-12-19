package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection提供了方法：toArray()
 * 该方法可以将当前集合转换为一个数组
 * @author soft01
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two"); 
		c.add("three");
		c.add("four");
		System.out.println("c:"+c);
		// Object[] array = c.toArray();  返回Object数组，不用
		String[] array = c.toArray(new String[c.size()]);
		System.out.println(Arrays.toString(array));
		array[1] = "2";
		System.out.println("c:"+c);
		System.out.println("array:"+Arrays.toString(array));
	}
}
