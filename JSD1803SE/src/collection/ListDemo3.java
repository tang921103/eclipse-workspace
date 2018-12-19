package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取子集
 * @author soft01
 *
 */
public class ListDemo3 {
	public static void main(String [] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			list.add(i);
		}
		System.out.println("list:"+list);
		/*
		 * List subList(int s,int e)
		 * 获取指定范围内的子集
		 */
		//获取3-7
		List<Integer> subList = list.subList(3, 8);
		System.out.println("subList:"+subList);
		
		//将子集中每个元素扩大10倍
		for(int i = 0;i<subList.size();i++) {
			subList.set(i, subList.get(i)*10);
		}
		System.out.println(subList);
		System.out.println("list:"+list);
		/*
		 * 对子集的操作就是对原集合对应元素的操作。
		 */
		//删除2-8
		list.subList(2, 9).clear();
		System.out.println("list:"+list);
	}
}
