package cn.tedu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
		private static Connection conn;	
		private static String driver;
		private static String url;
		private static String username;
		private static String password;
		private static BasicDataSource dataSource;
		static {		
			try {
				Properties prop = new Properties();
				prop.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
				 driver = prop.getProperty("driver");
				 url = prop.getProperty("url");
				 username = prop.getProperty("username");
				 password = prop.getProperty("password");
				 dataSource = new BasicDataSource();
				 dataSource.setDriverClassName(driver);
				 dataSource.setUrl(url);
				 dataSource.setUsername(username);
				 dataSource.setPassword(password);
				 dataSource.setInitialSize(3);
				 dataSource.setMaxActive(5);
				 conn = dataSource.getConnection();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static Connection getConnection() {				
			return conn;
		}

	public static void close(Connection conn,Statement stat,ResultSet rs) {	
			try {
				if(conn!=null) {
				conn.close();
				}
				if(stat!=null) {
					stat.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

