package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{
	public HelloTag() {
		System.out.println("HelloTag实例化");
	}
	private String info;
	private int qty;
	
	public String getInfo() {
		return info;
	}

	public int getQty() {
		return qty;
	}

	public void setInfo(String info) {
		this.info = info;
		System.out.println("setInfo方法："+info);
	}

	public void setQty(int qty) {
		this.qty = qty;
		System.out.println("setQty方法："+qty);
	}

	/**
	 * 标签类；
	 * a.继承SimpleTagSupport类
	 *  b.重写doTag（）方法
	 *  c.标签有哪些属性，标签类也要有对应的属性，并且有对应的set方法。
	 */
	@Override
	public void doTag() throws JspException, IOException {
		/*
		 * 通过继承自SimpleTagSupport类的方法来获得PageContext对象，
		 * 该对象提供了一些方法来获取的其他所有隐含对象。
		 */
		System.out.println("doTag方法");
		PageContext pctx = (PageContext)getJspContext();
		JspWriter out = pctx.getOut();
		for(int i = 0;i<qty;i++) {
			out.println(info+"<br>");
		}
	}
		
}
