package jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class TransActionDemo {
@Test
	public void transactiondemo1() {
		//把各种资源声明在try-catch外面，为了在finally里面关闭
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			//获取连接对象
			conn = DBUtils.getConn();
			//创建sql执行对象
			conn.setAutoCommit(false);
			String sql1 = "update person set money=money-2000 where id=1";
			stat = conn.prepareStatement(sql1);
			stat.executeUpdate();
			String sql2 = "update person set money=money+2000 where id=2";
			stat = conn.prepareStatement(sql2);
			stat.executeUpdate();
			rs = stat.executeQuery("select * from person where id=1");
			int money = 0;
			while(rs.next()) {
				money = rs.getInt(3);
				System.out.println(money);
			}
			if(money>=0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			//执行sql
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
}
}
