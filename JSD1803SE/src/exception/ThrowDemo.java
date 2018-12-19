package exception;
/**
 * 使用当前类测试异常的抛出
 * @author soft01
 */
public class ThrowDemo {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		Person p = new Person();
		try {
			/*
			 * 当调用一个含有throws声明异常抛出的方法时，
			 * 编译器要求必须处理这个异常，处理方式有两种：
			 * 1：使用trt-catch处理该异常
			 * 2：在当前方法上继续声明throws将该异常抛出
			 * 具体如何处理，结合实际业务需求而定。
			 */
			p.setAge(1000);
		}catch(IllegalAgeException e) {
			e.printStackTrace();
		}	
		System.out.println(p.getAge());
		System.out.println("程序结束了");
	}
}
