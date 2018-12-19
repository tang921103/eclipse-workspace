package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算商品促销日期
 * 促销日计算规则：该商品过期日前两周的周三
 * 
 * 程序启动后，要求用户输入商品的生产日期，格式为yyyy-MM-dd
 * 然后再输入保质期天数
 * 
 * 然后经过计算，输出该商品促销日期，输出格式也是yyyy-MM-dd
 * @author soft01
 *
 */
public class Test2 {
	public static void main(String [] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入生产日期");
		String str = scan.nextLine();
		System.out.println("请输入保质期天数");
		int days = scan.nextInt();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, days);
		calendar.add(Calendar.WEEK_OF_YEAR, -2);
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		str = sdf.format(calendar.getTime());
		System.out.println(str);
	}
}
