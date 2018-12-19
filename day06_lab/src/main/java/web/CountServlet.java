package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class CountServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
		 * 先查看有没有一个名称呢为count的cookie，如果没有则添加该cookie，值为1；
		 * 如果有的话，则将该值加1之后，再将cookie发送给浏览器。
		 */
		String count = CookieUtil.findCookie("count",request);
		if(count==null) {
			CookieUtil.addCookie("count", "1", 30*24*60*60, "/day06_lab", response);
			out.println("你是第1次访问");
		}else {
			int v1 = Integer.parseInt(count)+1;
			CookieUtil.addCookie("count", v1+"", 30*24*60*60, "/day06_lab", response);
			out.println("你是第"+v1+"次访问");
		}
	}

}
