package cn.tedu.dao;

import org.springframework.stereotype.Repository;
//@Repostory表示实例化持久层对象
//默认id的值：类名的第一个字母小写（userDao）
@Repository
public class UserDao {
	public void insertUser() {
		System.out.println("insert用户");
	}
}
