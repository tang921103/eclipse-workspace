package xml;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
public class Demo1 {
	public static void main(String[]args) throws FileNotFoundException, DocumentException { 
		/*
		 * 利用Dom4j读取XML文件
		 */
		FileInputStream in = new FileInputStream("books.xml");
		SAXReader  reader = new SAXReader();
		//如果xml文件格式错误，则抛异常
		Document doc = reader.read(in);
		//输出doc的内容 ，doc的内容与books的内容结构相同
		System.out.println(doc.asXML());
		System.out.println();
		//查找doc中的根元素，就是books.xml的根元素
		//Root 根 Element 元素
		Element root = doc.getRootElement();
		//Element类型的对象，就代表XML文件中的一个元素
		//输出root的信息，则会输出根元素的全部信息
		System.out.println( root.asXML());
		System.out.println();
		//查找根元素的第一个子元素，参数是子元素名
		Element book = root.element("book");
		System.out.println(book.asXML());
		System.out.println();
		//查找books的全部子元素
		List list = root.elements();
		//System.out.println(list);
		//list 是一个集合，相当于数组，存储了books的全部子元素
		//list.get(0) 获取第一个元素
		//list.get(1)获取第二个元素
		//list.get(2)获取第三个元素
		Element e1 = (Element)list.get(0);
		Element e2 = (Element)list.get(1);
		Element e3 = (Element)list.get(2);
		Element e4 = (Element)list.get(3);
		Element e5 = (Element)list.get(4);
		System.out.println(e1.asXML());
		System.out.println(e2.asXML());
		System.out.println(e3.asXML());
		System.out.println(e4.asXML());
		System.out.println(e5.asXML());
		System.out.println();
		//list.size() 返回list中元素的个数
		for(int i = 0;i<list.size();i++) {
			Element e = (Element)list.get(i);
			System.out.println(e.asXML());
			//e代表book子元素，查找book元素的name
			   //子元素 使用方法e.element()
			   Element n = e.element("author");
			   if(n!=null) {
				   System.out.println(n.asXML());//不存在，空指针
			   }
			  //获取一个元素的文本
				String str = e.getText();
				System.out.println(str);
		}
		
	}
}
