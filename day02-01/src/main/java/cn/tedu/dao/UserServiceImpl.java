package cn.tedu.dao;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}

	public void addUser() {
		userDao.insertUser();
	}
}
