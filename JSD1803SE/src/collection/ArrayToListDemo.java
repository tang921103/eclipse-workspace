package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转为集合
 * 数组的工具类：Arrays提供了一个静态方法asList()
 * 该方法可以将给定的数组转换为一个List集合。
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four"};
		List<String> list = Arrays.asList(array);
		System.out.println(list);
		/*
		 * 对数组转换的集合进行操作，就是对原数组对应操作。
		 */
		list.set(1, "2");
		System.out.println("list:"+list);
		System.out.println("array:"+Arrays.toString(array));
		/*
		 * 增删元素是不支持的操作，因为会导致数组扩容或缩容，那样就无法表示原数组了。
		 */
		//list.add("five");  抛出不支持操作异常
		System.out.println("list:"+list);
		System.out.println("array:"+Arrays.toString(array));
		/*
		 * 可以自行创建一个集合，然后作操作。
		 * 所有的集合都支持一个参数为Collection的构造方法，作用是在创建当前集合的同时
		 * 包含给定集合中的所有元素。
		 */
		List<String> list2 = new ArrayList<String>(list);
		System.out.println("list2:"+list2);
		list2.add("five");
		System.out.println("list2:"+list2);
	}
}
