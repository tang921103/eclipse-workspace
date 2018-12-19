package reflect;

import java.util.Scanner;

/**
 * 测试，变换不同的类名，依靠反射机制实例化该类实例
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入你要实例化的类的名字");
		String className = scan.nextLine();
		try {
			Class cls = Class.forName(className);
			Object obj = cls.newInstance();
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
