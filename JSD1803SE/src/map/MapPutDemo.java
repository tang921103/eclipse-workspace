package map;
import java.util.HashMap;
import java.util.Map;
public class MapPutDemo {
	public static void main(String[] args) {
		/*
		 * 将数据添加到Map中
		 */
		Map map = new HashMap();
		//第一次将“u1-Tom”添加到map
		Object obj = map.put("u1","Tom");
		//第一次返回为空
		System.out.println(obj);
		//第二次将“u1”的value替换为Jerry
		obj = map.put("u1", "Jerry");
		//第二次返回被替换的Tom
		System.out.println(obj);
		System.out.println(map);
		
		/*
		 * 利用泛型定义类型安全的mao集合
		 */
		Map<String,String> map2 = new HashMap<String,String>();
		// java 6中不能省略<String,String>,之后的可以省略
		// Map<String,String> map3 = new HashMap<>();
		String s = map2.put("u1", "Tom");
		System.out.println(s);
		s = map2.put("u1", "Jerry");
		System.out.println(s);
		System.out.println(map2);
	}
}
