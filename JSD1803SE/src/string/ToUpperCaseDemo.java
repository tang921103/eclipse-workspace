package string;
/**
 * String toUpperCase()
 * String toLowerCase()
 * 将当前字符串中的英文部分转换为全大写或全小写
 * @author soft01
 *
 */
public class ToUpperCaseDemo {
	public static void main(String[] args) {
		String str = "我爱Java";
		String upper = str.toUpperCase();
		System.out.println("upper:"+upper);
		System.out.println(str);
		String lower = str.toLowerCase();
		System.out.println("lower:"+lower);

	}

}
