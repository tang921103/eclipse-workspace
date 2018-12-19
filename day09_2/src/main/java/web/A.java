package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


 
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通过继承自GenericServlet提供的方法来获取Servlet上下文
		ServletContext sctx = getServletContext();
		System.out.println(sctx);
		String company = sctx.getInitParameter("company");
		System.out.println("company:"+company);
		sctx.setAttribute("username","Giving");
		sctx.setAttribute("password","123456");
		HttpSession session = request.getSession();
		session.setAttribute("city", "beijing");
		session.setMaxInactiveInterval(20);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("ServletContext:"+sctx);
		response.getWriter().println("company:"+company);
	}
}
