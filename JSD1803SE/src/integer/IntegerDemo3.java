package integer;
/**
 * 包装类支持一个静态方法：parseXXX(String str)
 * 可以将给定的字符串解析为对应的基本类型，但是前提时该字符串内容必须
 * 正确表示节本类型可以保存的值。
 * @author soft01
 *
 */
public class IntegerDemo3 {
	public static void main(String[] args) {
		String str = "123.12";
		int d = Integer.parseInt(str);
		System.out.println(str);
		double dou = Double.parseDouble(str);
		System.out.println(dou);
	}

}
