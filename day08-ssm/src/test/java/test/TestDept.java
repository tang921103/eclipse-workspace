package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ssm.bean.Dept;
import cn.tedu.ssm.dao.DeptDao;
import cn.tedu.ssm.service.IDeptService;

	public class TestDept {
	@Test
	public void testInsertDept() {
	AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
	DeptDao dao = ac.getBean("deptDao",DeptDao.class);
	Dept dept = new Dept();
	dept.setDeptName("工程管理部");
	dept.setDeptLoc("汝阳东沟");
	dao.insertDept(dept);
	ac.close();
}
	@Test
	public void testInsertService() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IDeptService deptService = ac.getBean("deptService",IDeptService.class);
		Dept dept = new Dept();
		dept.setDeptName("规划部2");
		dept.setDeptLoc("汝阳东沟");
		deptService.insertDept(dept);
		ac.close();	
	}
	@Test
	public void testSelectAll() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		DeptDao dao = ac.getBean("deptDao",DeptDao.class);
		List<Dept> depts = dao.selectAll();
		System.out.println(depts);
		ac.close();
	}
	@Test
	public void testDelete() {
		AbstractApplicationContext ac  = new ClassPathXmlApplicationContext("application-dao.xml");
		DeptDao dao = ac.getBean("deptDao",DeptDao.class);
		dao.deleteById(8);
		
	}
}
