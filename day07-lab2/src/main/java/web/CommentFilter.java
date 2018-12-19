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
/**
 * 实现Filter接口
 * 重写三个方法
 * @author soft01
 *
 */
public class CommentFilter implements Filter{
	private FilterConfig config;
	/*
	 * 容器启动之后会立即创建过滤器实例（通过调用构造器）
	 * 注： 只会创建一个实例。
	 */
	public CommentFilter() {
		System.out.println("CommentFilter的构造器被调用了");
	}
	/**
	 * 容器在创建好过滤器实例后，会立即调用该实例的init方法（初始化方法）；
	 * 注：a.该方法只会执行一次；
	 * 	 b.容器会将FilterConfig对象最为参数传进来。可以利用该对象读取初始化参数。
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
		System.out.println("CommentFilter的init方法");
		
	}
/**
 * 容器收到请求之后会调用doFilter方法来处理请求。
 * 容器会将请求对象和响应对象作为参数传进来，
 * 注（了解）：
 * ServletRequest是HttpServletRequest的父接口，ServletResponse是HttpServletResponse的父接口。
 * 	这里没有用子接口是过度设计的产物。
 * 
 * 如果调用了FilterChain对象的doFilter方法，表示继续向后调用；否则中断请求，返回处理结果。
 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CommentFilter的doFilter开始执行");
		HttpServletRequest requ = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String content = request.getParameter("content");
		//调用FilterConfig对象的方法来读取初始化参数
		//找不到返回null
		String illegal = config.getInitParameter("illegal");
		if(content.indexOf(illegal)!=-1) {
			//包含了敏感字，不再向后调用，返回处理结果
			response.getWriter().println("包含敏感字");
		}else {
			//没有敏感字，继续向后调用
			chain.doFilter(requ, resp);//两个参数（ServletRequest request, ServletResponse response）；
		}
		System.out.println("CommentFilter的doFilter方法执行完毕");
	}
	/**
	 * 当容器删除过滤器实例之前，会先调用该实例的destroy方法，该方法只会被执行一次。
	 */
	public void destroy() {
		System.out.println("CommentFilter的destroy方法");
		
	}
	
}
