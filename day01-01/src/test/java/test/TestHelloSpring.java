package test;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.demo.BeanLife;
import cn.tedu.demo.HelloSpring;
import cn.tedu.demo.King1;
import cn.tedu.demo.King2;
import cn.tedu.demo.ValueBean;
import cn.tedu.service.UserService;


public class TestHelloSpring {
	//从容器中获取bean对象
	@Test
	public void testGetBean() {
		//1.初始化容器对象（获取容器对象）
		//AbstractApplicationContext类中定义了close方法，关闭容器。
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
		//2.获取bean对象s
		HelloSpring hs = ac.getBean("hello",HelloSpring.class);
		//3.调用方法
		hs.sayHello();
		//4.关闭容器
		ac.close();
	}
	//静态方法初始化bean对象
	@Test
	public void testGetByStaticBean() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		Calendar cl = ac.getBean("cl",Calendar.class);	
		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH)+1;
		int day = cl.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月"+day+"日");
		ac.close();
	}
	@Test
	public void testBeanInstanceMethod() {
		AbstractApplicationContext  ac = new ClassPathXmlApplicationContext("application.xml");
		Calendar cl = ac.getBean("calendar",Calendar.class);
		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH)+1;
		int day = cl.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月"+day+"日");
		ac.close();
	}
	@Test
	public void testBeanLife() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		BeanLife bf = ac.getBean("beanLife",BeanLife.class);
		ac.close();
	}
	@Test
	public void testKing1() {
		King1 k1 = King1.getKing();
		System.out.println(k1);
		King1 k2 = King1.getKing();
		System.out.println(k2);
	}
	@Test
	public void testKing2() {
		King2 k1 = King2.getKing2();
		King2 k2 = King2.getKing2();
		System.out.println(k1);
		System.out.println(k2);
	}
	//测试使用set方法和构造方法给成员变量赋值
	@Test
	public void test3() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		UserService us = ac.getBean("userService",UserService.class);
		us.addUser();
		ac.close();
	}
	//测试byName
	@Test
	public void test4() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		UserService us = ac.getBean("userService3",UserService.class);
		us.addUser();
		ac.close();
	}  
	//测试byType
	@Test
	public void test5() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		UserService us = ac.getBean("userService4",UserService.class);
		us.addUser();
		ac.close();
	}
	//测试属性
	@Test
	public void test6() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application2.xml");
		ValueBean vb = ac.getBean("valueBean",ValueBean.class);
		System.out.println(vb);
		ac.close();
	}
}
