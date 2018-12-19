package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 
 * 集合的工具类：java.util.Collections
 * 提供了很多的静态方法，便于操作集合。
 * @author soft01
 *
 */
public class Collections_sort1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0;i<10;i++) {
			list.add(rand.nextInt(100));
		}
		System.out.println(list);
		//排序（升序) 
		Collections.sort(list);
		System.out.println(list);
		//乱序
		Collections.shuffle(list);
		System.out.println(list);
	}
}
