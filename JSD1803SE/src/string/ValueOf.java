package string;
/**
 * String 提供了一组重载的静态方法：valueOf
 * 作用是将java中其他类型转换为字符串
 * 常见的是将基本类型转换为字符串
 */
public class ValueOf {
	public static void main(String[] args) {
		int d = 100;
		String str = String.valueOf(d);
		System.out.println(str);
		dosome(str);
		str = d+"";
	}
	public static void dosome(String str) {
		
	}
}
