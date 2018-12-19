package collection;
/**
 * 新循环 自JDK1.5之后推出的一个特性
 * 
 * 新循环是用来遍历集合或数组使用的。
 * 新循环又称为：增强for循环，for each
 * 
 * @author soft01
 *
 */
public class NewForDemo1 {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four","five"};
		for(int i = 0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		/*
		 * 新循化是编译器认可，而不是JVM认可，遍一切会将新循环遍历数组改为普通for循环。
		 * 
		 */
		
		
		for(String str : array) {
			System.out.println(str);
		}
	}
}
