package collection;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		System.out.println(list);
		List<Integer> subs = list.subList(2,6);
		System.out.println(subs);
		for(int i =0;i<subs.size();i++) {
			subs.set(i, subs.get(i)*10);
		}
		System.out.println(subs);
		System.out.println(list);
	}
}
