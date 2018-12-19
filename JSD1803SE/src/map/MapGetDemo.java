package map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MapGetDemo {
	public static void main(String[] args) {
		/*
		 * 测试map的查询方法
		 * 1.如果找到就返回key对应的值
		 * 2.如果没有找到就返回null
		 */
		Map<String,String> map = new HashMap<String,String>();
		//添加数据
		map.put("u1", "Tom");
		map.put("u2", "Jerry");
		//从map中检索
		String v1 = map.get("u1");
		String v3 = map.get("u3");
		System.out.println(v1);
		System.out.println(v3);
		//纵向比较map的查询性能
		System.out.println("map：");
		test(10000);
		test(100000);
		//测试LinkedList的查找性能
		//LinkedList的头尾查找性能好，中部查找性能差
		System.out.println("LinkedList:");
		testLinkedList(10000);
		testLinkedList(100000);
	}
	public static void test(int n) {
		Map<Integer,String> map = new HashMap<>();
		for(int i = 0;i<n;i++) {
			map.put(i,"n"+i);
		}
		//long nanoTime() 返回系统纳秒数1ms = 1000000ns;
		long t1 = System.nanoTime();
		String s = map.get(n-1);
		long t2 = System.nanoTime();
//		System.out.println(t1);
//		System.out.println(t2);
		System.out.println(t2-t1);
	}
	public static void testLinkedList(int n) {
		LinkedList<String> list = new LinkedList<String>();
		for(int i = 0;i<n;i++) {
			list.add("u"+i);
		}
		long t1 = System.nanoTime();
		list.get(n/2);
		long t2 = System.nanoTime();
//		System.out.println(t1);
//		System.out.println(t2);
		System.out.println(t2-t1);
	}
}
