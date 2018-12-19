package jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DBUtilsTest {
@Test
public void insert() {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	try {
		 conn = DBUtils.getConn();
		 stat = conn.createStatement();
		 String sql = "insert into user values(null,'lisi',45)";
		 stat.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBUtils.close(rs, stat, conn);
	}
}
@Test
public void select() {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	try {
		conn = DBUtils.getConn();
		stat = conn.createStatement();
		String sql = "select * from user where id between 1 and 10";
		rs = stat.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println(id+":"+name+":"+age);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
@Test
public void update() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			stat.executeUpdate("update user set age=20 where id<10");
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
@Test
public void delete() {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	try {
		conn = DBUtils.getConn();
		stat = conn.createStatement();
		stat.executeUpdate("delete from user where id >20");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
