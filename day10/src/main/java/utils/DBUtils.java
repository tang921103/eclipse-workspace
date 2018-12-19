package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource ds;
	static {
			try {
				Properties pro = new Properties();
				pro.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
				String driver = pro.getProperty("driver");
				String url = pro.getProperty("url");
				String username = pro.getProperty("username");
				String password = pro.getProperty("password");
				int initSize = Integer.parseInt(pro.getProperty("initSize"));
				int maxActive = Integer.parseInt(pro.getProperty("maxActive"));
				ds = new BasicDataSource();
				ds.setDriverClassName(driver);
				ds.setUrl(url);
				ds.setUsername(username);
				ds.setPassword(password);
				ds.setInitialSize(initSize);
				ds.setMaxActive(maxActive);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}

	public static Connection getConn() throws SQLException {
			return ds.getConnection();
	}

	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if(stat!=null) {
				stat.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
