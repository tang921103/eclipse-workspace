package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AutoPrimaryKey {
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
			String sql = "insert into user values(null,'蜡笔小新',35)";
			//执行sql并返回自增主键
			stat.execute(sql,Statement.RETURN_GENERATED_KEYS);
			//得到返回的主键值
			rs = stat.getGeneratedKeys();
			while(rs.next()) {
				int id = rs.getInt(1);
				System.out.println("id:"+id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
	
}
