package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserServiceImpl;
import cn.tedu.demo.TestInjection;
import cn.tedu.demo.User;

public class Come {
	@Test
	public void run() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		User u = ac.getBean("user",User.class);
		System.out.println(u);
		ac.close();
	}
	@Test
	public void testScope() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		User u1 = ac.getBean("user",User.class);
		User u2 = ac.getBean("user",User.class);
		System.out.println(u1);
		System.out.println(u2);
	}
	@Test
	public void testSetter() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		UserServiceImpl us = ac.getBean("userServiceImpl",UserServiceImpl.class);
		us.addUser();
	}
	@Test
	public void testS() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		TestInjection tj = ac.getBean("testInjection",TestInjection.class);
		System.out.println(tj);
	}
}
