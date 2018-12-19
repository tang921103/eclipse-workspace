package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.bean.User;
import cn.tedu.dao.UserDaoImpl;
import cn.tedu.service.UserServiceImpl;

public class TestUser {
	@Test
	public void testSelectByUsername() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserDaoImpl userDao = ac.getBean("userDaoImpl",UserDaoImpl.class);
		User user = userDao.selectByUsername("Sallly");
		System.out.println(user);
	}
	@Test
	public void testUserLogin() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-service.xml","application-dao.xml");
		UserServiceImpl us = ac.getBean("userServiceImpl",UserServiceImpl.class);
		User u = us.login("tangqiu", "123");
		System.out.println(u);
		ac.close();
	}
}
