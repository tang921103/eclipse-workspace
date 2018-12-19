package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo12 {
	public static void main(String[] args) throws Exception{
		Class .forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","soft01");
		Statement stat = con.createStatement();
		String sql = "drop table jdbct3";
		stat.execute(sql);
		con.close();
		stat.close();
	}
}
