package reflect;

import java.lang.reflect.Method;

/**
 * 调用有参的方法
 * @author soft01
 *
 */
public class Demo4 {
	public static void main(String[] args) throws Exception {
		//1加载Person
		Class cls = Class.forName("reflect.Person");
		//实例化
		Object o = cls.newInstance();
		//获取sayHello(String name,int age)方法
		Method method = cls.getDeclaredMethod("sayHello", new Class[] {String.class,int.class});
		//调用方法
		method.invoke(o,new Object[] {"唐秋",25});
	}
}
