package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	public HelloServlet() {
		System.out.println("HelloServlet的构造器");
	}
	
	/**
	 * Servlet容器收到请求之后，会将Servlet实例化,接下来调用该实例的service方法来处理请求；
	 * 容器会将请求request对象和响应response对象作为参数传递进来。
	 * 注：容器会提供网络相关的服务，容器会解析请求数据包，并且将解析到的数据存放到request对象里面。开发人员不用再
	 * 解析请求数据包了，只需要调用request对象的方法就可以了。同理，开发人员只需要调用response对象的方法写入处理结果，
	 * 容器会从response对象中取出处理结果，然后生成响应数据包。
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet的service方法");
		/*
		 * 依据请求参数名获得请求参数值
		 */
		String number = request.getParameter("number");
		System.out.println("<h1>Hello Kitty "+number+"</h1>");
		/*
		 * 设置Content-Type响应头的值，告诉浏览器，服务器返回的数据类型。
		 */
		response.setContentType("text/html;charset=utf-8");
		/*
		 * 通过response对象获取一个输出流
		 */
		PrintWriter out = response.getWriter();
		/*
		 * 将数据写到响应response对象里面，容器会从响应对象中去取出数据，然后创建响应数据包，并发送给浏览器。
		 * 注：out在输出时，默认会使用ISO8859-1来编码，所以中文，会产生乱码。
		 */
		out.println("<h1>Hello Kitty 你的高考成绩是多少？"+number+"</h1>");
		out.close();	
	}
}
