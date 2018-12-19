package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestCase2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Scanner scan = new Scanner(System.in);
		String className = scan.nextLine();
		Class cls = Class.forName(className);
		Object obj = cls.newInstance();
		Method[] methods = cls.getDeclaredMethods();
		for(Method m :methods) {
			String name = m.getName();
			if(name.startsWith("test")) {
				Object returns = m.invoke(obj);
				System.out.println("返回值："+returns);
			}
		}
	}
}
