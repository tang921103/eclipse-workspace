package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射机制调用某个类实例的方法
 * @author soft01
 *
 */
public class Demo3 {
	public static void  main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//实例化
		Person p = new Person();
		//调用该对象的方法
		p.sayHello();
		Class cls = Class.forName("reflect.Person");
		Object obj = cls.newInstance();
		/*
		 * Class提供了获取其表示的类相关信息的一组方法。
		 * 其中：
		 * Method getDeclaredMethod(String name,Class[] args)是获取当前Class所表示
		 * 的类定义的指定名字及参数列表的方法。
		 * 
		 * Method是反射API中一个重要的类。其每个实例用于表示某个类的一个具体的方法。
		 * 通过Method可以获取到其表示的方法的相关信息，如：方法名，返回值类型，参数类型，访问修饰等等。
		 * 并且可以通过Method动态调用其表示的方法。
		 */
		Method method = cls.getDeclaredMethod("sayHello", null);
		/*
		 * Method的invoke方法是用来调用当前Method所表示的方法。
		 * 参数1：由于成员方法所属对象，那么调用Method所表示的方法时要传入该方法所属对象。
		 * 参数2：实际参数，若该方法无参，则传入null即可。
		 * 即：
		 * 若method表示的时Person类的方法sayHello,
		 * 		那么method.invoke(obj,null)等同于obj.sayHello()
		 */
		method.invoke(obj, null);
	}
}




















