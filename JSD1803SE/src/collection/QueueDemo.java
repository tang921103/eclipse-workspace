package collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列
 * 队列可以存放一组数据但是存取必须按照先进先出的原则。
 * Queue是一个接口，其继承自Collection，所以，队列也具有集合的特性。
 * add 、size等方法依然可以用。
 * 
 * Queue也提供了一组进出队列的方法，常用实现类：
 * java.util.LinkedList
 * @author soft01
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		//入队操作
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		//出队操作（删除队首元素）
		String str = queue.poll();
		System.out.println(queue);
		//引用队首元素(队首元素依然在队列中，不会被删除)
		String str1 = queue.peek();
		System.out.println(str1);
		System.out.println(queue);
		/*
		 * 遍历队列可以使用迭代器（新循环）
		 * 遍历不会影响队列中的元素。
		 * 
		 */
		for(String s : queue) {
			System.out.println(s);
		}
		System.out.println(queue);
	}
}
