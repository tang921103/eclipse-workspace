package string;
/**
 * String 支持正则表达式方法之二
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分
 * 返回所有被拆分后的部分
 * 
 * @author soft01
 *
 */
public class SplitDemo {

	public static void main(String[] args) {	
		String str = "abc1234baaga1234fafewf56afaf12";
		/*
		 * 若拆分是连续匹配了拆分内容，那么会拆分出空字符串。
		 * 但是若在字符串的末尾连续匹配了拆分内容，那么所有的空字符串都被忽略。
		 */
		String[] array = str.split("[0-9]");
		System.out.println(array.length);
		for(int i = 0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		String image = "123.png";
		String[] name = image.split("\\.");
		image = System.currentTimeMillis()+"."+name[1];
		System.out.println(image);
	}

}
