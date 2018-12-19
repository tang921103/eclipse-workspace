package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.tedu.dao.UserDao;
@Service
public class UserService2 {
	//@Autowired表示依赖注入
	//@Autowired默认按照类型注入（byType）
	//@Autowired 如果使用属性名进行依赖注入，必须使用@Qualifier协助完成，
	//@Qualifier（“userDao"）,"userDao"表示属性名，@Qualifier实现依赖注入的时候不能单独使用。
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	public void addUser() {
		userDao.insertUser();
	}
}
