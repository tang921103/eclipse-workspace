package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AutoPrimaryKey2 {
	public static void main(String[] args) {
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
			String sql1 = "insert into dept values(null,'神仙')";					
			 stat.execute(sql1,Statement.RETURN_GENERATED_KEYS);
			rs = stat.getGeneratedKeys();
			int id =0;
			while(rs.next()) {
				id = rs.getInt(1);
				System.out.println("id:"+id);
			}
			String sql2 = "insert into emp values(null,'悟空',"+id+"),(null,'八戒',"+id+")";
			stat.executeUpdate(sql2);
			System.out.println("插入成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
}
