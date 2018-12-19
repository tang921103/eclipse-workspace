package string;
/**
 * String substring(int s,int e)
 * 截取当前字符串中指定范围内的字符串
 * @author soft01
 *
 */
public class substringDemo {
	public static void main(String[] args) {
		String str = "thinking in java";
		String sub = str.substring(5,8);
		System.out.println(sub);
		
		// 从指定位置开始截取到字符串末尾
		sub = str.substring(9);
		System.out.println(sub);
	}

}
