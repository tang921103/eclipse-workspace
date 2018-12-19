package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.User;

public interface IUserDao {
	//添加用户
	void insertUser(User user);
	//修改用户信息
	void updateUser(User user);
	//删除用户信息
	void deleteUser(Integer id);
	//根据id查询用户信息
	User selectUser(Integer id);
	//查询所有用户信息
	List<User> getAll();
}
