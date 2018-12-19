package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
			String str = URLEncoder.encode("小马哥","utf-8");
			System.out.println(str);
			String str2 = URLDecoder.decode(str,"UTF-8");
			System.out.println(str2);
	}
}
