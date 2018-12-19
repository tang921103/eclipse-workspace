package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCookieServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean check = true;
		if(cookies!=null) {
			for(int i =0;i<cookies.length;i++) {
				String name = cookies[i].getName();
				if("cart".equals(name)) {
					String value = cookies[i].getValue();
					out.println(name+" "+value);
					check = false;
					break;
				}			
			}
		}
		if(cookies==null || check) {
			Cookie c = new Cookie("cart","007");
			response.addCookie(c);
		}
	}
}
