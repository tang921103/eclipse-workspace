package date;

import java.util.Date;

/**
 * java.util.Date
 * Data的每一个实例用于表示一个确切的时间，内部维护一个long值，
 * 该值为1970年1月1日00：00：00到当前Date所表示的时间之间经过的毫秒数。
 * 由于Date设计时存在时区问题，所有大部分操作时间的方法都被声明为过时，
 * 不再建议使用。
 * @author soft01
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		//默认实例化表示当前系统时间
		Date date = new Date();
		System.out.println(date);
		//获取内部维护的long值
		long time = date.getTime();
		time += 1000*60*60*24;
		//可以设置一个long值指使date表示该日期
		date.setTime(time);
		System.out.println(date);
	}
}
