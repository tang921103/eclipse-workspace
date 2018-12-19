package cn.tedu.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
		private static SqlSessionFactory ssf;
		static {
			InputStream in = SqlSessionUtil.class.getClassLoader().getResourceAsStream("SqlMapperConfig.xml");
			ssf = new SqlSessionFactoryBuilder().build(in);
		}
		public static SqlSession getSession() {
			return ssf.openSession();
		}
}
