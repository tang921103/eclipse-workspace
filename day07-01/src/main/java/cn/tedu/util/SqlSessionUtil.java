package cn.tedu.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.tedu.dao.UserDao;

public class SqlSessionUtil {
	private static SqlSessionFactory ssf;
	static {
		// 1.读配置文件(通过类加载器)
		InputStream in = UserDao.class.getClassLoader().getResourceAsStream("SqlMapperConfig.xml");
		// 2.获得SqlSessionFactory
		 ssf = new SqlSessionFactoryBuilder().build(in);
	}
	public static SqlSession getSession() {
		return ssf.openSession();
	}
}
