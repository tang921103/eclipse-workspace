package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo1 {
public static void main(String[] args) {
	Collection c = new ArrayList();
		c.add("hello");
		c.add("world");
		c.add("name");
		c.add("passwrod");
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
			if(obj.equals("hello")) {
				it.remove();
			}
		}
			System.out.println(c);
}
}
