package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
		private static String driver;
		private static String url;
		private static String user;
		private static String password;
		private static BasicDataSource dataSource;
		private static Connection conn;
		static {
			Properties prop = new Properties();
			InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			try {
				prop.load(ips);
				 driver = prop.getProperty("driver");
				 url = prop.getProperty("url");
				 user = prop.getProperty("user");
				 password = prop.getProperty("password");
				 
				//1.创建数据源对象
				  dataSource = new BasicDataSource();
					//2.设置数据库连接信息
					dataSource.setDriverClassName("com.mysql.jdbc.Driver");
					dataSource.setUrl("jdbc:mysql://localhost:3306/db2");
					dataSource.setUsername("root");
					dataSource.setPassword("soft01");
					//3.设置连接池策略信息
					dataSource.setInitialSize(3);//初始连接数量
					dataSource.setMaxActive(5);//最大连接数量
					//4.从连接池中获取连接对象
					 conn = dataSource.getConnection();
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		/**封装获取连接对象的代码*/
		public static  Connection getConn() throws Exception {							
			/*//1.注册驱动
			Class.forName(driver);
			//2.创建连接对象
			Connection conn = DriverManager.getConnection(url, user, password);*/								
			return conn;
		}
		//关闭资源
		public static void close(ResultSet rs,Statement stat,Connection conn)  {
			try {
				//避免空指针异常
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
