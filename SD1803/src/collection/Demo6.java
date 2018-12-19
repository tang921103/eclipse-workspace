package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo6 {
	public static void main(String[] args) {
		String[] arr = new String[] {"one","two","three"};
		List<String> list = Arrays.asList(arr);
		for(String str:arr) {
			System.out.println(str);
		}
		list.set(2, "2");
		//list.remove(1);
		System.out.println(list); 
		List<String> list2 = new ArrayList<String>(list);
		
	}
}
