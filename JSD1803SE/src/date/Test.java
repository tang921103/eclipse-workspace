package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 输入自己的生日，然后经过程序计算，输出到今天为止一共活了多少天
 * @author soft01
 *
 */
public class Test {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入生日");
		String str = scan.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1= sdf.parse(str);
			long time1 = date1.getTime();
			Date date2 = new Date();
			long time2 = date2.getTime();
			long days = (time2-time1)/1000/60/60/24;
			System.out.println("到今天为止活了："+days);
			time1 = time1+10000*24*60*60*1000L;
			date2.setTime(time1);
			System.out.println(date2);
			String memory = sdf.format(date2);
			System.out.println("出生10000天纪念日为："+memory);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
