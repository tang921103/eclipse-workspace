package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends  HttpServlet{
	public SomeServlet(){
		System.out.println("SomeServlet的构造器");
	}
/*
 * 通过继承自GenericServlet的方法来获取ServletConfig对象
 */
	
	
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		System.out.println("SomeServlet的init方法");
		//读取初始化参数
		String company = config.getInitParameter("company");
		System.out.println(company);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SomeServlet的service方法");
	}


	@Override
	public void destroy() {
		System.out.println("SomeServlet的destroy方法");
	}
	
}
