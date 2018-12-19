package integer;
/**
 * 数字类型的包装类都有两个常量MAX_VALUE,MIN_VALUE
 * 用于表示其对应的基本类型数据的取值范围
 * @author soft01
 *
 */
public class IntegerDemo2 {

	public static void main(String[] args) {
		int max =  Integer.MAX_VALUE;
		System.out.println(max);
		int min = Integer.MIN_VALUE;
		System.out.println(min);
		double max1 = Double.MAX_VALUE;
		System.out.println(max1);
		double min1 = Double.MIN_VALUE;
		System.out.println(min1);
		long max2 = Long.MAX_VALUE;
		System.out.println(max2);
	}

}
