package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * java.util,Deque 双端队列
 * Deque接口继承自Queue，双端队列是两端都可以 作进出队操作的队列。
 * 常用实现类：java.util.LinkedList
 * 
 * @author soft01
 *
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<String>();
		deque.offer("one");
		deque.offer("two");
		deque.offerFirst("three");
		deque.offerLast("four");
		System.out.println(deque);
		
		String str = deque.poll();
		System.out.println(str);
		
		str = deque.pollFirst();
		System.out.println(str);
		
		str = deque.pollLast();
		System.out.println(str);
	}
}
