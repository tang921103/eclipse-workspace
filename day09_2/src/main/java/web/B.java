package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sctx = getServletContext();
		String company = sctx.getInitParameter("company");
		String str = (String)sctx.getAttribute("username");
		String password = (String)sctx.getAttribute("password");
		String city = (String)(request.getSession().getAttribute("city"));
		System.out.println(str);
		System.out.println(password);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("username:"+str);
		response.getWriter().println("password:"+password);
		response.getWriter().println("city:"+city);
		response.getWriter().println("company:"+company );
	}

}
