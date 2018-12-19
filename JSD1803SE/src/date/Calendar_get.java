package date;

import java.util.Calendar;

/**
 * Calendar提供了一个方法：
 * int get(int field)
 * 该方法可以获取指定时间分量所对应的值
 *  
 *  时间分量是一个int值，不同值表示不同时间分量，无需记忆这些具体数字是多少，
 *  Calendar提供了对应的常量。
 * @author soft01
 *
 */

public class Calendar_get {
		public static void main(String[] args) {
			Calendar calendar = Calendar.getInstance();
			//获取年
			int year = calendar.get(Calendar.YEAR);
			System.out.println(year);
			//获取月 月从零开始
			int month = calendar.get(Calendar.MONTH);
			System.out.println(month);
			/*
			 * 获取日
			 * 和“天”有关的常量；
			 * DAY_OF_MONTH :月中的天，就是俗称的“几号”
			 * DAT_OF_WEEK ：周中的天，就是只星期几
			 * DAY_OF_YRAR：年中的天
			 * DATE和DAY_OF_MONTH意义相同
			 */
			int date = calendar.get(Calendar.DATE);			
			System.out.println(date);
			int h = calendar.get(Calendar.HOUR);
			int m = calendar.get(Calendar.MINUTE);
			int s = calendar.get(Calendar.SECOND);
			/*
			 * 根据当前calendar表示的日期获取指定时间分量所允许的 最大值
			 * 今年总共多少天?
			 */
			int days = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
			System.out.println("今年总共："+days);
		}
}
