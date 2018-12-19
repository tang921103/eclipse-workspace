package jdbctest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
		private static BasicDataSource  dataSource;
	static {
		Properties prop = new Properties();
		try {
			prop.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(3);
			dataSource.setMaxActive(5);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException {	
		return dataSource.getConnection();
	}
	public static void close(ResultSet rs,Statement stat,Connection conn) {
		try {
			if(rs!=null) {
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
