package base.web;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import base.common.Handler;
import base.common.HandlerMapping;

public class DispatcherServlet extends HttpServlet {
	// 负责请求路径与处理器的对应关系
	private HandlerMapping hMapping;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获得请求资源路径
		String uri = request.getRequestURI();
		// 截取请求资源路径中的一部分
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		System.out.println(path);
		// 依据请求路径找到相应的Handler
		Handler handler = hMapping.getHandler(path);
		Method mh = handler.getMh();
		Object obj = handler.getObj();
		// 处理器方法的返回值
		String rv = null;
		try {
			// 调用处理器的方法
			/*
			 * 利用java反射，查看处理器的方法带不带参数，如果带参数就要给参数赋值。
			 */
			// 获得方法的参数类型
			Class[] types = mh.getParameterTypes();
			if (types.length > 0) {
				Object[] args = new Object[types.length];
				// 执行带参数方法
				for (int i = 0; i < types.length; i++) {
					if (types[i] == HttpServletRequest.class) {
						args[i] = request;
					}
					if (types[i] == HttpServletResponse.class) {
						args[i] = response;
					}
				}
				rv = (String) mh.invoke(obj, args);
			} else {
				// 执行不带参数方法
				rv = (String) mh.invoke(obj);
			}
			// 检查视图名，如果是以“redirect:”开头，则重定向，否则转发。
			if (rv.startsWith("redirect:")) {
				// 重定向
				// 将视图名转换成重定向地址
				String redirectPath = contextPath + "/" + rv.substring("redirect:".length());
				response.sendRedirect(redirectPath);
			} else {
				// 转发
				// 将返回值（即视图名）转换成jsp地址
				String jspPath = "/WEB-INF/" + rv + ".jsp";
				// 转给jsp
				request.getRequestDispatcher(jspPath).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * 读取配置文件config.xml，获得处理器的类名。 然后利用java反射将处理器实例化，然后将处理器实例交给HandlerMapping来处理。
	 * 注：HandlerMapping（映射处理器）利用java反射读取@RequestMapping中的路径信息， 建立请求路径与处理器方法的对应关系。
	 */
	public void init() throws ServletException {
		// 利用dom4j来解析cofig.xml文件,目的是为了读取处理器类名
		SAXReader reader = new SAXReader();
		InputStream in = getClass().getClassLoader().getResourceAsStream("config.xml");
		try {
			Document doc = reader.read(in);
			// 找到根元素
			Element root = doc.getRootElement();
			// 找到根元素下的 所有子元素
			List<Element> list = root.elements();
			// 遍历所有子元素
			List beans = new ArrayList();
			for (Element e : list) {
				String className = e.attributeValue("class");
				System.out.println(className);
				// 处理器实例化
				Object obj = Class.forName(className).newInstance();
				// 将处理器实例方法一个集合里面，方便管理
				beans.add(obj);
			}
			System.out.println(beans);
			// 将处理器实例交给HandlerMapping来处理
			hMapping = new HandlerMapping();
			hMapping.process(beans);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	} 
}
