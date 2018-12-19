package base.common;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.annotation.RequestMapping;
/**
 * 映射处理器： 
 * 			负责提供请求路径与处理器的对应关系。
 * @author soft01
 *
 */
public class HandlerMapping {
	//用来存放请路径与处理器的对应关系
	private Map<String,Handler> handlerMap = new HashMap<String,Handler>();
	/**
	 * beans：处理器实例
	 * 此方法通过遍历集合，利用java反射读取@RequestMapping中的路径信息。
	 * 然后以路径信息作为key、以Handler对象作为value添加到handerMap中。
	 * @param beans
	 */
	public void process(List beans) {
		for(Object bean : beans) {
			//获得class对象
			Class clazz = bean.getClass();
			//获得所有方法
			Method[] methods = clazz.getDeclaredMethods();
			//遍历方法
			for(Method mh : methods) {
				//获取方法前的@RequestMapping
				RequestMapping rm = mh.getAnnotation(RequestMapping.class);
				//获取路径信息
				String path = rm.value();
				System.out.println(path);
				//以请求路径作为key,以Handler作为value,将对应关系添加到map中。
				handlerMap.put(path,new Handler(mh,bean));		
			}
		}
		System.out.println("handlerMap:"+handlerMap);
	}
	/**
	 * 依据请求路径返回Handler对象。
	 * @param path
	 * @return
	 */
	public Handler getHandler(String path) {
		return handlerMap.get(path);
	}
}
