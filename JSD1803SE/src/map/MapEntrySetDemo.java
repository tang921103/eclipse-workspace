package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEntrySetDemo {
	public static void main(String [] args) {
		/*
		 * 利用entrySet对map集合进行遍历
		 */
		//如下数据相当于从浏览器收到的消息头
		Map<String,String> map = new HashMap<>();
		map.put("Host", "doc.tedu.cn");
		map.put("Connection", "keep-alive");
		map.put("Cache-Control","max-age=0");
		//遍历全部的消息头
		//map没有提供直接遍历的方法!
		//可以利用entrySet和keySet间接实现遍历
		/*
		 * 一个Entry（Map内部接口）对象中包含两个属性，key和value
		 * Entry的实现类是HashMap内部类
		 * set中包含全部的Key-Value对
		 * 只要遍历了set就相当于遍历了map
		 */
		Set<Entry<String,String>> set=	map.entrySet();
		for(Entry<String,String> e :set) {
			System.out.println(e.getKey()+","+e.getValue());
		}
	}
}
