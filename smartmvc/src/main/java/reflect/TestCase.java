package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestCase {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入类名");
		//读取类名
		String className = scan.nextLine();
		System.out.println("类名："+className);
		//通过反射，加载该类，然后实例化
		Class cls = Class.forName(className);
		Object obj = cls.newInstance();
		//获取该类的所有方法
		Method[] methods = cls.getDeclaredMethods();
		//遍历所有方法
		for(Method mh : methods) {
			//获得方法名
			String mName = mh.getName();
			System.out.println("方法名："+mName);
			//调用方法(rv是方法的返回值)
			Object rv = null;
			if("foo".equals(mName)) {
				//调用带参方法
				Object[] params = new Object[] {"vavava"};
				rv = mh.invoke(obj, params); 
			}else {
				//调用不带参方法
				rv = mh.invoke(obj);
			}
			
			System.out.println("返回值："+rv);
		}
	}
}
