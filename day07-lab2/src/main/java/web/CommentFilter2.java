package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter2 implements Filter{
	private FilterConfig config;
	public void init(FilterConfig filterConfig) throws ServletException {
		config  = filterConfig;
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requ = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		requ.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String content = requ.getParameter("content");
		int illegal =Integer.parseInt(config.getInitParameter("illegal"));
		if(content.length()>illegal) {
			request.setAttribute("long", "评论字数太长");
			request.getRequestDispatcher("comment.jsp").forward(requ, resp);
		}else {
			chain.doFilter(requ, resp);
		}
	}

	public void destroy() {
		
		
	}

}
