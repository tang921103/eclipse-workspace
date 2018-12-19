package com.tedu.webserver.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 服务端环境信息
 * @author soft01
 *
 */
public class ServerContext {
	/*
	 * 请求与Servlet映射
	 * key:请求路径
	 * value：对应Servlet的名字
	 */
		private static Map<String,String>  servletMapping = new HashMap<String,String>();
		static {
			initServletMapping();
		}
		/**
		 * 初始化请求与Servlet映射信息
		 */
		private static void initServletMapping() {
			/*
			 * 读取conf/server.xml文件
			 * 将所有的<servlet>标签解析出来，用其中的url属性值作为key
			 * className属性值作为value存入到servletMapping中。
			 */
			SAXReader reader = new SAXReader();
			try {
				Document doc = reader.read(new FileInputStream("conf/server.xml"));
				Element root = doc.getRootElement();
				Element servlets = root.element("servlets");
				List<Element> list = servlets.elements("servlet");
				for(Element ele : list) {
					String url = ele.attributeValue("url");
					String servlet = ele.attributeValue("className");
					servletMapping.put(url,servlet);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		public static String getServletName(String url) {
			return servletMapping.get(url);
		}
		public static void main(String[] args) {
			System.out.println(getServletName("/myweb/login"));
		}	
}
