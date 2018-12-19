package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo5 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		System.out.println(c);
		Object[] obj = c.toArray();
		String [] str = c.toArray(new String[c.size()]);
		System.out.println(Arrays.toString(str));
		for(int i =0;i<str.length;i++) {
			System.out.println(str);//集合里面存放的是引用的地址
		}
	}
}
