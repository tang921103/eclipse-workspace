package cn.tedu.service;

import cn.tedu.dao.UserDao;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public UserServiceImpl() {
		
	}
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
		System.out.println("构造方法赋值");
	}
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void addUser() {
		userDao.insertUser();
	}
}
