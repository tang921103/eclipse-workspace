package com.tedu.webserver.http;

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
 * 该类定义了HTTP协议相关信息
 * @author soft01
 *
 */
public class HttpContext {
	/*
	 * 状态代码与对应的状态描述的映射关系
	 * key：状态代码
	 * value:状态描述
	 */
		private static Map<Integer,String> STATUS_REASON_MAPPING = new HashMap<Integer,String>(); 
		/*
		 * 资源后缀与Content-Type之间的映射关系
		 * key : 资源后缀名
		 * value: 该资源对应的Content-Type 的值
		 * 注：不同的资源对应Content-Type的值在位w3c上都有定义，可以前往w3c官网查询MIME定义。
		 */
		private static Map<String,String> MIME_MAPPING = new HashMap<String,String>();
		static {
			initStatusReasonMapping();
			initMimeMapping();
		}
		/**
		 * 初始化资源后缀与Content-Type映射关系
		 */
		
		private static void initMimeMapping() {
			/*
			 * 读取cong/web.xml文件，将根元素下所有名为<mime-mapping>的子元素
			 * 读取出来，然后将<mime-mapping>的子元素中<extension>中间的文本作为key，
			 * <mime-type>中间的文本作为value存入到MIME_MAPPING中，完成初始化。
			 */
			try {
				FileInputStream file = new FileInputStream("./conf/web.xml");
				SAXReader reader = new SAXReader();
				try {
					Document doc = reader.read(file);
					Element root = doc.getRootElement();
					List<Element> subs = root.elements("mime-mapping");
					for(int i = 0;i<subs.size();i++) {
					List<Element> sub = subs.get(i).elements();					
						String name = sub.get(0).getText();
						String value = sub.get(1).getText();
						MIME_MAPPING.put(name, value);				
					}
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 初始化状态代码与描述的映射MAP
		 */
		private static void initStatusReasonMapping() {
			STATUS_REASON_MAPPING.put(200,"OK");
			STATUS_REASON_MAPPING.put(302, "Move Temporaily");
			STATUS_REASON_MAPPING.put(404, "Not Found");
			STATUS_REASON_MAPPING.put(500, "Internal Server Error");
		}
	/**
	 * 根据给定的状态代码获取对应的状态描述
	 * @param statusCode
	 * @return
	 */
	public static String getStatusReason(int statusCode) {
		return STATUS_REASON_MAPPING.get(statusCode);
	}	
	/**
	 * 根据资源后缀名获取对应的Content-Type的值
	 * @param ext
	 * @return
	 */
	public static String getMimeType(String ext) {
		return MIME_MAPPING.get(ext);
	}
}
