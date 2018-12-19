package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo02 {
	@Test
	public void testDrop() throws Exception {
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "soft01");
		//3.创建sql执行对象
		Statement stat = conn.createStatement();
		//4.执行sql
		String sql = "drop table if exists jdbct2";
		stat.execute(sql);
		System.out.println("删除成功");
		//5.关闭资源
		conn.close();
		stat.close();
	}
	@Test
	public void testInsert() throws Exception{
				//1.注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				//2.获取连接对象
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "soft01");
				//3.创建sql执行对象
				Statement stat = conn.createStatement();
				//4.执行sql
				String sql = "insert into jdbct1 values(2,'Jerry'),(3,'李白')";
				stat.executeUpdate(sql);
				System.out.println("插入成功");
				//5.关闭资源
				conn.close();
				stat.close();
	}
	@Test
	public void testSelect() throws Exception {
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "soft01");
		//3.创建sql执行对象
		Statement stat = conn.createStatement();
		//4.执行sql
		String sql = "select * from jdbct1";
		ResultSet rs = stat.executeQuery(sql);
		//遍历结果
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id+":"+name);
		}
		System.out.println("查询成功");
		//5.关闭资源
		conn.close();
		stat.close();
	}
	
}
