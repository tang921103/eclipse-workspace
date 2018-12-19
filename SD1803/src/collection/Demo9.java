package collection;

import java.util.Deque;
import java.util.LinkedList;

public class Demo9 {
	public static void main(String[] args) {
		Deque<String> de = new LinkedList<String>();
		de.offer("one");
		de.offer("two");
		de.offer("three");
		System.out.println(de);
		System.out.println(de.poll());
		System.out.println(de);
	}
}
