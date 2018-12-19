package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBCUtilsTest {
	@Test
	public void  insert() {
		//把各种资源声明在try-catch外面，为了在finally里面关闭
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//获取连接对象
			conn = DBUtils.getConn();
			//创建sql执行对象
			stat = conn.createStatement();
			//执行sql
			String sql = "insert into jdbct1 values(4,'刘备')";
			stat.executeUpdate(sql);
			System.out.println("插入成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
	@Test
	public void  select() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from jdbct1");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name  = rs.getString("name");
				System.out.println(id+":"+name);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, stat, conn);
		}
	}
	@Test
	public void  update() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql = "update jdbct1 set name='李连杰' where id=2";
			stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs,stat,conn);
		}	
	}
	@Test  
	public void  delete() {
		Connection conn =null ;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql = "delete from jdbct1 where id=2";
			stat.executeUpdate(sql);
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, stat, conn);
		}
	}
}
