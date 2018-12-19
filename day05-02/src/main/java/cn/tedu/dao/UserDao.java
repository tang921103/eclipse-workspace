package cn.tedu.dao;

import cn.tedu.bean.User;

public interface UserDao {
	 User selectByUsername(String username);
}
