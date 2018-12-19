package string;
/**
 * 截取域名
 * @author soft01
 *
 */
public class Test {

	public static void main(String[] args) {
		String name = getHostName("www.baidu.com");
		System.out.println(name);
		name = getHostName("www.sohu.com.cn");
		System.out.println(name);
	}
	public static String getHostName(String str) {
		int a = str.indexOf(".");
		int b = str.indexOf(".",a+1);
		String name = str.substring(a+1,b);
		return name;
	}
	
}
