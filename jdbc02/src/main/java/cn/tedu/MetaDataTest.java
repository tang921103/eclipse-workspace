package cn.tedu;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataTest {
	@Test
	public void database() {
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
			//得到元数据
			DatabaseMetaData md = conn.getMetaData();
			System.out.println("驱动版本："+md.getDriverVersion());
			System.out.println("用户名："+md.getUserName());
			System.out.println("连接地址："+md.getURL());
			System.out.println("数据库厂商："+md.getDatabaseProductName());
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
	@Test
	public void table() {
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
			 rs = stat.executeQuery("select * from user");
			 //从结果集中得到表的元数据
			 ResultSetMetaData md = rs.getMetaData();
			 //得到表字段数量
			 int columCount = md.getColumnCount();
			 //获取表字段的名称
			 for(int i = 0;i<columCount;i++) {
				 String name = md.getColumnName(i+1);
				 System.out.println("字段："+name);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
}
