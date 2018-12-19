package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo1 {
	public static void main(String[] args) throws Exception {
		//1.注册驱动	
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取数据库链接对象(选择java.sql)
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "soft01");
		System.out.println(conn);
		//3.创建sql执行对象
		Statement stat = conn.createStatement();
		//4.执行sql  执行DDL使用execute(),执行DML使用executeUpdate(),执行DQL使用executeQuery()
		String sql = "create table if not exists jdbct2(id int,name varchar(10))";
		stat.execute(sql);
		System.out.println("创建成功");
		//5.关闭资源（类似于关闭流）
		stat.close();
		conn.close();
	}
}
