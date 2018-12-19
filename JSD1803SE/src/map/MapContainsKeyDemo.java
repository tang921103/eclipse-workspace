package map;

import java.util.HashMap;
import java.util.Map;

public class MapContainsKeyDemo {
	public static void main(String[] args) {
		/*
		 * 测试containsKey方法
		 * 检查map集合中是否包含指定的Key
		 * 
		 */
		Map<String ,String> map = new HashMap<>();
		map.put("u1", "one");
		map.put("u2", "two");
		map.put("u3", "three");
		map.put("u4", "four");
		//map中允许添加一个key为null的数据
		map.put(null, "tang");
		//map集合无序
		System.out.println(map);
		//检查集合中是否包含指定的key
		boolean containsKey = map.containsKey("u1");
		System.out.println(containsKey);
		containsKey = map.containsKey("u6");
		System.out.println(containsKey);
		containsKey = map.containsKey(null);
		System.out.println(containsKey);
	}
}
