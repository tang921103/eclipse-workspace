package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo1 {
	public static void main(String[] args) throws Exception {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","soft01");
					Statement stat = conn.createStatement();
					String sql = "create table if not exists jdbct2(id int primary key auto_increment,name varchar(10),age int default 100)";
					stat.execute(sql);
					System.out.println("创建表成功");
					sql = "insert into jdbct2(name) values('关羽')";
					stat.executeUpdate(sql);
					sql = "select * from jdbct2";
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int age = rs.getInt("age");
						System.out.println(id+":"+name+":"+age);
					}
	}
}
