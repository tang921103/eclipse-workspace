package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo11 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "soft01");
		Statement stat = conn.createStatement();
		String sql = "create table if not exists jdbct3(id int primary key auto_increment,name varchar(10))";
		stat.execute(sql);
		System.out.println("创建成功");
		conn.close();
		stat.close();
	}
}
