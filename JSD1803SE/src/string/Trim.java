package string;
/**
 * String trim()
 * 去除一个字符串两边的空白字符
 * @author soft01
 *
 */
public class Trim {
	public static void main(String[] args) {
		//中间的空格不会被去掉
		String str = "	hel lo         ";
		System.out.println(str);
		 str = str.trim();
		 System.out.println(str);
		 
	}
}
