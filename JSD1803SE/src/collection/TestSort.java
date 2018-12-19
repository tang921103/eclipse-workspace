package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 向一个List集合中添加10个100以内的随即数，然后按照从大到小的顺序排序。
 * @author soft01
 *
 */
public class TestSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0;i<10;i++) {
			list.add(rand.nextInt(100));
		}
		System.out.println(list);
		Collections.sort(list,new Comparator<Integer>() {
			public int compare(Integer t1,Integer t2) {
				return t2-t1;
			}
		});
		System.out.println(list);
	}
}
