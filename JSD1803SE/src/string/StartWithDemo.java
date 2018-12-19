package string;
/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * 判断当前字符串是否以给定的字符开始或结束
 * @author soft01
 *
 */
public class StartWithDemo {
	public static void main(String[] args) {
		String str = "thinking in java";
		boolean c = str.startsWith("t");
		System.out.println(c);
		c = str.endsWith(" java");
		System.out.println(c);
		c = str.startsWith("thi");
		System.out.println(c);
		c = str.endsWith("av");
		System.out.println(c);
	}
}
