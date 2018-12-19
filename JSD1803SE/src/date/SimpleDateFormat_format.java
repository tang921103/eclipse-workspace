package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * SDF可以根据给定的日取格式将字符串与Date之间相互转换。
 * @author soft01
 *
 */
public class SimpleDateFormat_format {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E aHH:mm:ss");
		/*
		 * String format(Date date)
		 * 将给定的Date按照当前SDF指定的日期格式转换为对应内容的字符串。
		 */
		String str = sdf.format(date);
		System.out.println(str);
	}
}
