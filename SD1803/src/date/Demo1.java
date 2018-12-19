package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo1 {
	public static void main(String[] args) throws ParseException {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		Date date = cal.getTime();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		cal.setTime(date);
	}
}
