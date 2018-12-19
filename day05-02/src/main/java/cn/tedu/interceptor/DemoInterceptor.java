package cn.tedu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{
	//1.在控制器方法之前执行。
	//2.方法的返回值如果为false，则不再继续向下执行，表示请求到此结束。
	//3.方法的返回值为true，会继续 执行控制器方法。
	//适合做登录页面。
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		//登录验证
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if(obj!=null) {
			return true;			
		}else {
			request.getRequestDispatcher("/WEB-INF/web/login.jsp").forward(request, response);
			return false;
		}
	}
	//表示在控制器的方法之后，在响应页面之前执行。
	//对响应视图对象进行处理。
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {		
		System.out.println("postHandle");
	}
	//当页面响应完成后执行。
	//适合处理一些首尾的操作，比如性能测试
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		
	}
	
}
