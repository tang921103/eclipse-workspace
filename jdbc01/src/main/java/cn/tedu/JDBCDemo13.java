package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo13 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","soft01");
		Statement s = c.createStatement();
		String sql = "insert into jdbct2 values(1,'唐秋')";
		s.executeUpdate(sql);
		s.close();
		c.close();
	}
}
