package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener {
	/**
	 * session对象创建之后容器会调用此方法。 注：HttpSessionEvent是事件对象
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated方法");
		HttpSession session = se.getSession();
		ServletContext sctx = session.getServletContext();
		// 通过上下文得到绑定的人数
		Integer count = (Integer) sctx.getAttribute("count");
		if (count == null) {
			// 第一个用户
			System.out.println("第一次");
			count = 1;		
		} else {
			// 不是第一个用户
			count++;
			System.out.println("不是第一次");	
		}
		sctx.setAttribute("count", count);
	}

	/**
	 * session对象销毁之后容器会调用此方法。
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed方法");
		ServletContext sctx = se.getSession().getServletContext();
		Integer count = (Integer)sctx.getAttribute("count");
		count--;
		sctx.setAttribute("count", count);
	}

}
