package doc;
/**
 * 文档注释：
 * 文档注释是功能级注释，用于说明一个类、方法、常量的功能。
 * 
 * 在类上使用文档注释，用于说明设计此类的意图，以及这个类解决的问题等信息。
 * @author  
 * @version 1.0
 * @see java.lang.String
 * @since JDK1.0
 * 
 */
public class DocDemo {
	/**
	 * sayHello方法中的问候语
	 * 
	 */
	public static final String INFO = "你好";
	/**
	 * 对给定的用户添加问候语
	 * @param name 给定的用户名
	 * 
	 */
	public void sayHello(String name) {
		System.out.println("你好"+name);
	}
}
