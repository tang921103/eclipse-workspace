package integer;
/**
 * JDK1.5之后推出了一个特性：自动拆装箱
 * 该特性时编译器认可，而非JVM认可。编译器在编译源代码时会自动补全基本类型与包装类之间的转换
 * 代码完成相互转换工作 ，从而让我们在编写源代码时实现了基本类型和包装类之间相互赋值的操作。
 * @author soft01
 *
 */
public class IntegerDemo4 {

	public static void main(String[] args) {
		/*
		 * 触发了编译器自动拆箱特性
		 * 编译器会自动补全代码完成包装类转换为基本类型的操作
		 * 下面代码在class文件中会被改为：
		 * int d = new Integer(1).intValue();
		 * Integer in = Integer.valueOf(1);
		 */
		int d = new Integer(1);
		Integer in = 1;
	}

}
