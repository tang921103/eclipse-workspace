package string;
/**
 * 字符串
 * 
 */
public class StringDemo {
	/**
	 * 测试 字符串 一旦被创建不能被改变
	 * @param args
	 */
	public static void  main(String [] args) {
		String s1 = "abc123";
		//s2重用s1创建的字符串对象，指向同一个地址
		String s2 = "abc123";
		System.out.println(s1==s2);
		String s3 = "abc123";
		//修改内容会创建新对象
		s1 = s1+"!";
		System.out.println(s1);
		System.out.println(s1==s2);//false 创建了新对象
		String s4 = new String("abc123");//强制创建新对象
		System.out.println(s2==s4);//false 创建了新对象
		/*
		 * 编译器有一个优化措施：
		 * 当一个计算表达式计算符号两边都是字面量时，编译器会直接
		 * 将结果计算出来并替代原来的表达式，所以JVM在运行class文件时，
		 * 看到下面的代码被编译器改为了：
		 * String s5 = "123abc";
		 * 所以会重用上面s2的对象
		 * 
		 */
		String s5 = "abc"+"123";
		System.out.println(s2==s5);//true
		String s6 = "abc";
		String s7 = "123";
		String s8 = s6+s7;//s6 s7都不是字面量，编译器不会将结果计算出来并替代
		System.out.println(s8==s2);
				
	}
}
