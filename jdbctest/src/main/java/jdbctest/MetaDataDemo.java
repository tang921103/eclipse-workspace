package jdbctest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataDemo {
	@Test
public void databaseDemo() {
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
		DatabaseMetaData  md = conn.getMetaData();
		String url = md.getURL();
		String product = md.getDatabaseProductName();
		String driver = md.getDriverName();
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		//关闭资源
		DBUtils.close(rs, stat, conn);
	}
}
	@Test
	public void tableDemo() {
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
			rs = stat.executeQuery("selelc * from emp");
			ResultSetMetaData  md = rs.getMetaData();
			String name = md.getColumnName(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
}
