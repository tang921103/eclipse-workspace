package cn.tedu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.tedu.bean.User;
import cn.tedu.util.SqlSessionUtil;

public class UserDao implements IUserDao{

	public void insertUser(User user) {		
		//调用工具类的静态方法获得session
		SqlSession session = SqlSessionUtil.getSession();
		//第一个参数：namespace.id(命名空间与id一起，中间用点连接)
		session.insert("userDao.insertUser", user);
		//提交事务
		session.commit();
		session.close();
	}

	public void updateUser(User user) {
		SqlSession session = SqlSessionUtil.getSession();
		session.update("userDao.updateUser", user);
		session.commit();
		session.close();
	}

	public void deleteUser(Integer id) {
		SqlSession session = SqlSessionUtil.getSession();
		session.delete("userDao.deleteUser", id);
		session.commit();
		session.close();
	}

	public User selectUser(Integer id) {
		SqlSession session = SqlSessionUtil.getSession();
		User user =  session.selectOne("userDao.selectUser", id);
		session.close();
		return user;
	}

	public List<User> getAll() {
		SqlSession session = SqlSessionUtil.getSession();
		List<User> list = session.selectList("userDao.getAll");
		session.commit();
		session.close();
		return list;
	}

}
