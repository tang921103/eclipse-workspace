package date;

import java.util.Calendar;

/**
 * Calendar提供了一个Set方法，可以对指定时间分量设置对应的值：
 * void set(int field,int value)
 * 
 */
public class Calendar_set {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		//设置年
		calendar.set(Calendar.YEAR, 2008);
		//设置月
		calendar.set(Calendar.MONTH,07);
		//设置日
		calendar.set(Calendar.DAY_OF_MONTH,9);
		System.out.println(calendar.getTime());
		//设置为周4 
		//按照西方标准，一周的第一天为周日
		 calendar.set(Calendar.DAY_OF_WEEK,4);
		System.out.println(calendar.getTime());
	}
}
