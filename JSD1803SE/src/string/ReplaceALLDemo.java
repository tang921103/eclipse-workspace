package string;
/**
 * 字符串支持正则表达式方法之三
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为给定的字符串
 * @author soft01
 *
 */
public class ReplaceALLDemo {
	public static void main(String[] args) {				
		String str = "123jflaf143ljl3546wrw";
		/*
		 * 将数字部分替换为#NUMBER#
		 * 将字母部分替换为、#CHAR#
		 */
		str = str.replaceAll("[0-9]+","#NUMBER");
		System.out.println(str);
		String str1 = "123jflaf143ljl3546wrw";
		str = str1.replaceAll("[a-zA-Z]+","#CHAR#");
		System.out.println(str1);
		/*
		 * 和谐用语
		 */
		String regex = "(wqnilgb|cnm|mmp|sb|nc|mdzz)";
		String message = "mmp!cnm!你这个sb1你怎么这么nc！";
		message = message.replaceAll(regex, "***");
		System.out.println(message);
	}

}
