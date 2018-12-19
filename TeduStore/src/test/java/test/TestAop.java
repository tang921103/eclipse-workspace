package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.aop.IStudentService;
import cn.tedu.store.aop.StudentProxy;

public class TestAop {
	@Test
	public void testProxy() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-aop.xml");
	IStudentService sp = ac.getBean("studentProxy",IStudentService.class);
		sp.add();
		ac.close();
	}
}
