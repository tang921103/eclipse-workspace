package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestCase4 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Scanner scan = new Scanner(System.in);
		String className = scan.nextLine();
		Class cls = Class.forName(className);
		Object obj = cls.newInstance();
		Method[] methods = cls.getDeclaredMethods();
		for(Method m : methods) {
			RequestMapping rm = m.getAnnotation(RequestMapping.class);
			if(rm != null) {
				m.invoke(obj);
				System.out.println(rm.value());
			}
		}
	}	
}
