package date;

import java.util.Calendar;

/**
 * Calendar提供了计算时间的方法：
 * void add(int field,int amount)
 * 对给定的时间分量加上指定的值，若给定的值为负数，则是减去。
 * @author soft01
 *
 */
public class Calendar_add {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		/*
		 * 查看3年2个月25天后所在周的周三是哪天？
		 */
		calendar.add(Calendar.YEAR, 3);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		System.out.println(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		System.out.println(calendar.getTime());
	}
}
