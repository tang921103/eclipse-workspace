package map;

import java.util.HashMap;
import java.util.Map;

public class MapRemoveDemo {
	public static void main(String[] args) {
		/*
		 * 演示Map的方法：
		 * int size();
		 * boolean isEmpty();
		 *  v remove(K k);
		 *  void clear();
		 */
		Map<String ,String> map = new HashMap<String,String>();
		boolean isEmpty = map.isEmpty();
		int size = map.size();
		System.out.println("isEmpty:"+isEmpty);
		System.out.println("size:"+size);
		map.put("u1", "one");
		map.put("u2", "two");
		map.put("u3","three");
		map.put("u4", "four");
		System.out.println(map);
		//从map中删除u2元素，返回值为删除的value
		String remove = map.remove("u2");
		System.out.println("remove:"+remove);
		isEmpty = map.isEmpty();
		size = map.size();
		System.out.println("isEmpty:"+isEmpty);
		System.out.println("size:"+size);
		System.out.println(map);
		//清空map集合的内容
		map.clear();
		System.out.println(map);
	}
}
