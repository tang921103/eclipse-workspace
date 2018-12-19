package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCUtilTest {
		private Connection conn ;
		private Statement stat;
		private ResultSet rs;
	@Test
	public void insert() {	
		try {
			Connection conn = DBUtils.getConnection();
			Statement stat = conn.createStatement();
			String sql = "insert into jdbct2 values(null,'张三',45)";
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	@Test
	public void select() {
		try {
			conn = DBUtils.getConnection();
			stat = conn.createStatement();
			String sql = "select * from jdbct2";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
			 int id = rs.getInt(1);
			 String name = rs.getString(2);
			 int age = rs.getInt(3);
			 System.out.println(id+","+name+","+age);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	@Test
	public void update() {
		
		try {
			 conn = DBUtils.getConnection();
			stat = conn.createStatement();
			String sql = "update jdbct2 set age=99";
			stat.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void delete() {
			try {
			 conn = DBUtils.getConnection();
			stat = conn.createStatement();
			 String sql = "delete from jdbct2 where name='张三'";
			 stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
