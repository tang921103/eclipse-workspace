package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.bean.User;
import cn.tedu.dao.UserDao;
@Service
public class UserServiceImpl implements UserService{
		//通过注解获取持久层对象
		@Resource
		private UserDao userDao;
		public User login(String username,String password) {
				User user = userDao.selectByUsername(username);
				if(user==null) {//用户名不存在
					throw new RuntimeException("用户名错误");
				}else {//用户名存在，判断密码是否正确
					if(user.getPassword().equals(password)) {//密码正确
							return user;
					}else {
						throw new RuntimeException("密码错误");//密码不正确
					}
				}
		}
}
