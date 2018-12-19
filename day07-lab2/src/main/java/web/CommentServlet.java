package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentServlet extends HttpServlet{
	public CommentServlet() {
		System.out.println("CommentServlet的构造器被调用了");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service方法开始执行");
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("评论是："+content);
		System.out.println("service方法执行完毕");
	}

}
