package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 排序自定义元素的集合
 * @author soft01
 *
 */
public class Collections_sort2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(2,4));
		list.add(new Point(2,3));
		list.add(new Point(6,3));
		list.add(new Point(3,1));
		list.add(new Point(2,1));
		/*
		 * Collections的sort方法杂排序集合时要求集合元素必须实现Comparable接口。
		 */
		Collections.sort(list);
		System.out.println(list);
	}
}
