package map;

import java.util.HashMap;
import java.util.Map;

public class PutAllDemo {
	public static void main(String[] args) {
		Map<String,String> map1 = new HashMap<>();
		Map<String,String> map2 = new HashMap<>();
		map1.put("u1", "one");
		map1.put("u2", "two");
		map2.put("u3", "three");
		map2.put("u4","two");
		map2.put("u1", "five");
		map1.putAll(map2);
		System.out.println(map1);
		
	}
}
