package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			String str = it.next();
			if(str.equals("two")) {
				c.remove(str);
				System.out.println(str);
			}
		}
		System.out.println(c);
	}
}
