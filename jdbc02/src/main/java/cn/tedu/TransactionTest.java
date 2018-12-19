package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionTest {
	public static void main(String[] args) {
		//把各种资源声明在try-catch外面，为了在finally里面关闭
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			//获取连接对象
			conn = DBUtils.getConn();
			//创建sql执行对象\
			conn.setAutoCommit(false);
			String sql = "update person set money=money? where id=?";
			stat = conn.prepareStatement(sql);
				
			
			stat.setString(1, "-2000");
			stat.setInt(2, 1);
			stat.addBatch();
			
			stat.setString(1, "+2000");
			stat.setInt(2, 2);
			stat.addBatch();
			int [] arr = stat.executeBatch();
			 
			
			//执行sql
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
}
