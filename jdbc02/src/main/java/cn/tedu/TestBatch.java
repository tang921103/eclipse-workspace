package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class TestBatch {
	@Test
	public void testStatement() {
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
			String sql1 = "insert into user values(null,'悟空',18)";
			String sql2 = "insert into user values(null,'八戒',28)";
			String sql3 = "insert into user values(null,'悟净',38)";
			//批量执行
			stat.addBatch(sql1);
			stat.addBatch(sql2);
			stat.addBatch(sql3);
			//执行 arr是每条sql的生效行数
			int arr[] = stat.executeBatch();
			System.out.println("执行完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
	@Test
	public void testPreparedStatement() {
		//把各种资源声明在try-catch外面，为了在finally里面关闭
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			//获取连接对象
			conn = DBUtils.getConn();
			//创建sql执行对象
			String sql = "insert into user values(null,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, "刘备");
			stat.setInt(2, 20);
			//添加到批量操作
			stat.addBatch();
			stat.setString(1, "关羽");
			stat.setInt(2, 30);
			//添加到批量操作
			stat.addBatch();
			stat.setString(1, "张飞");
			stat.setInt(2, 40);
			//添加到批量操作
			stat.addBatch();
			//执行sql
			int[] arr = stat.executeBatch();
			System.out.println("执行完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
	@Test
	public void testBatch() {
		//把各种资源声明在try-catch外面，为了在finally里面关闭
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			//获取连接对象
			conn = DBUtils.getConn();
			//创建sql执行对象
			String sql = "insert into user values(null,?,?)";		
			stat = conn.prepareStatement(sql);
			for(int i = 0;i<100;i++) {
				stat.setString(1, "name"+i);
				stat.setInt(2, i);
				stat.addBatch();
				//避免内存溢出
				if(i%20==0) {
					stat.executeBatch();
					//清空执行过的sql，不然会重复添加
					stat.clearBatch();
				}
			}
			//执行sql
			stat.executeBatch();
			System.out.println("执行完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}

}
