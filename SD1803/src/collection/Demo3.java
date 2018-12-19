package collection;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
	 public static void main(String[] args) {
		 List<String> list =new ArrayList<String>();
		 list.add("one");
		 list.add("two");
		 list.add("three");
		 list.add("four");
		 System.out.println(list);
		 System.out.println(list.size());
		 System.out.println(list.get(2));
		 list.set(2, "3");
		 System.out.println(list);
		 list.add(2, "1");
		 System.out.println(list);
		 list.remove(3);
		 System.out.println(list);
	 }
}
