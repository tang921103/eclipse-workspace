package test;

import java.util.List;

import org.junit.Test;

import cn.tedu.bean.User;
import cn.tedu.dao.IUserDao;
import cn.tedu.dao.UserDao;

public class TestUserDao {
	@Test
	public void  testInsert() {
		IUserDao userDao = new UserDao();
		User user = new User();
		user.setUsername("张");
		user.setPassword("123456");
		user.setPhone("145697123");
		user.setEmail("tangqiu@qq.com");
		userDao.insertUser(user);
	}
	@Test
	public void testUpdate() {
		IUserDao userDao = new UserDao();
		User user = new User();
		user.setUsername("李四");
		user.setId(15);
		user.setPassword("222555");
		user.setPhone("999999");
		user.setEmail("flafa@tedu.cn");
		userDao.updateUser(user);
	}
	@Test
	public void testDelete() {
		IUserDao userDao = new UserDao();
		userDao.deleteUser(15);
	}
	@Test
	public void testSelectOne() {
		IUserDao userDao = new UserDao();
		System.out.println(userDao.selectUser(13));
	}
	@Test
	public void testSelectAll() {
		IUserDao userDao = new UserDao();
		List<User> list = userDao.getAll();
		for(User u : list) {
			System.out.println(u);
		}
	}
}
