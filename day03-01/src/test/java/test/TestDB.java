package test;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.bean.BeanLife;
import cn.tedu.bean.DemoLazy;
import cn.tedu.bean.DemoScope;
import cn.tedu.bean.User;
import cn.tedu.dao.UserDao;
import cn.tedu.service.UserService;
import cn.tedu.service.UserService2;
import cn.tedu.test.Person;

public class TestDB {
	@Test
	public void test() throws SQLException {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		BasicDataSource bds = ac.getBean("basicSource",BasicDataSource.class);
		//在控制台输出属性
		System.out.println(bds.getUsername());
		System.out.println(bds.getUrl());
		
		System.out.println(bds.getPassword());
		System.out.println(bds.getDriverClassName());
		System.out.println(bds.getInitialSize()); 
		System.out.println(bds.getMaxActive());
		//获取连接对象
		System.out.println(bds.getConnection());
		ac.close();
	}
	//测试注解扫描
	@Test
	public void testDao() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		UserDao ud  = ac.getBean("userDao",UserDao.class);
		ud.insertUser();
	}
	@Test
	public void testLife() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		BeanLife bl = ac.getBean("life",BeanLife.class);
		bl.service();
		ac.close();
	}
	@Test
	public void testScope() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		DemoScope ds1 = ac.getBean("demoScope",DemoScope.class);
		DemoScope ds2 = ac.getBean("demoScope",DemoScope.class);
		System.out.println(ds1);
		System.out.println(ds2);
		ac.close();
	}
	//测试延迟加载
	@Test
	public void testLazy() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		DemoLazy dl = ac.getBean("demoLazy",DemoLazy.class);
		ac.close();
	}
	@Test
	public void testResource() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		UserService us = ac.getBean("userService",UserService.class);
		us.addUser();
		ac.close();
	}
	@Test
	public void testAutowired() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		UserService2 us = ac.getBean("userService2",UserService2.class);
		us.addUser();
		ac.close();
	}
	@Test
	public void testValue() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		User u = ac.getBean("user",User.class);
		u.showName();
		ac.close();
	}
	@Test
	public void testPerson() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		Person p = ac.getBean("person",Person.class);
		p.handler();
		ac.close();
	}
}
