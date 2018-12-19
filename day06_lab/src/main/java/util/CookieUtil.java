package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	/**
	 * 添加cookie的方法
	 * @param name
	 * @param value
	 * @param age
	 * @param path
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	public static void addCookie(String name,String value,int age,String path,HttpServletResponse response) throws UnsupportedEncodingException {
			Cookie c = new Cookie(name,URLEncoder.encode(value,"utf-8"));
			c.setMaxAge(age);
			c.setPath(path);
			response.addCookie(c);
	}
	/**
	 * 依据cookie的名字返回cookie的值；
	 * 注：
	 * 			找不到返回null
	 * @param name 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String findCookie(String name,HttpServletRequest request) throws UnsupportedEncodingException {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(name)) {
					value = URLDecoder.decode(c.getValue(),"utf-8");
				}
			}
		}
		return value;
	}
}
