package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		Cookie c = new Cookie("username",URLEncoder.encode("小马哥","utf-8"));
		//设置生存时间
		c.setMaxAge(40);
		response.addCookie(c);
		Cookie c2 = new Cookie("city","beijing");
		response.addCookie(c2);
	}
	
}
