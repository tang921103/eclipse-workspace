package tax;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		Scanner scan = new Scanner(System.in);
//		String className = scan.nextLine();
		Class cls = Class.forName("tax.Mean");
		Object obj = cls.newInstance();
		Method[] methods = cls.getDeclaredMethods();
		for(Method m : methods) {
			String name = m.getName();
			System.out.println(name);
			Exe exe = m.getAnnotation(Exe.class);
			int value = exe.value();
			System.out.println("value:"+value);
		}
	}
}
