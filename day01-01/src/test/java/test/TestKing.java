package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.demo.King;

public class TestKing {
	/**
	 * 测试单例模式
	 */
	@Test
	public void testKing() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		King k1 = ac.getBean("king",King.class);
		King k2 = ac.getBean("king",King.class);
		System.out.println(k1+"  "+k2);
		ac.close();
	}
	/**
	 * 测试延迟加载
	 */
	@Test
	public void test2() {
		//默认为初始化的时候实例化bean对象，如果lazy-init属性为true会在调用的时候初始化。
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		King k = ac.getBean("king",King.class);
		k.sayHello();
		ac.close();
	}
	
}
