package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 获得Session对象
		 */
		HttpSession s = request.getSession(true);
		//设置超时时间（秒）
		//s.setMaxInactiveInterval(35);
		//获得SessionId
		String sessionId = s.getId();
		System.out.println(sessionId);
		Integer count = (Integer)s.getAttribute("count");
		if(count==null) {
			//第一次 ，将值设为1
			count=1;
		}else {
			//不是第一次，则累加
			count++;
		}
		//将访问此时绑定到session对象上
		s.setAttribute("count",count);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("你是第"+count+"次访问");
		//删除session对象，使之无效；
		//s.invalidate();
	}
}
