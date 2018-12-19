package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了一组重载的add，remove方法
 * @author soft01
 *
 */
public class ListDemo2 {
		public static void main(String[] args) {
			List<String> list = new ArrayList<String>();
			list.add("one");
			list.add("two");
			list.add("three");
			list.add("four");
			System.out.println("list:"+list);
			/*
			 * void add(int index,E e)
			 * 将给定元素插入到指定位置
			 */
			list.add(2,"2");
			System.out.println("list:"+list);
			
			/*
			 * E remove(int  index)
			 * 删除当前集合中指定位置对应的元素并将其返回。
			 */
			String old = list.remove(1);
			System.out.println("list:"+list);
		}
}
