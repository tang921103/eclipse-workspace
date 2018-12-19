package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(cookies!=null) {
			for(int i = 0;i<cookies.length;i++) {
				String name = cookies[i].getName();
				String value = URLDecoder.decode(cookies[i].getValue(),"utf-8");		
				out.println(name+"="+value+"<br>");
			}
		}else {
			out.println("没有cookie");
		}
	}
	
}
