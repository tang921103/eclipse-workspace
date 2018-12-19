package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.UserDao;
@Service
public class UserService {
	//@Resource表示给成员变量赋值，依赖注入；可以省略set方法；
	//@Resource默认按名称（属性名）依赖注入(byName)。
	//@Resource 如果名称不同，那么按类型依赖注入（byType）。
	//@Resource(name="userDao")找到相同名字的对象。
	@Resource(name="userDao")
	private UserDao userDao;
	public void addUser() {
		userDao.insertUser();
	}
}
