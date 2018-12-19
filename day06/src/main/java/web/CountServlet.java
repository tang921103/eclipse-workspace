package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean check = true;
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				if("count".equals(name)) {
					int value = Integer.parseInt(URLDecoder.decode(c.getValue(),"utf-8"));
					value++;
					c = new Cookie("count",value+"");
					c.setMaxAge(30*24*60*60);
					c.setPath("/day06");
					response.addCookie(c);
					out.println("访问次数："+value);
					check = false;
				}
			}
		}
		if(cookies == null || check) {
			Cookie c = new Cookie("count","1");
			c.setMaxAge(30*24*60*60);
			c.setPath("/day06");
			response.addCookie(c);
			out.println("访问次数："+(cookies.length+1));
		}
	}
	
}
