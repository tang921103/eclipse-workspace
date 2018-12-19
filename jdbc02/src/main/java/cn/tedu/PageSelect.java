package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PageSelect {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入页数");
		int page = scan.nextInt();
		System.out.println("请输入每页的数量");
		int mount = scan.nextInt();
		//把各种资源声明在try-catch外面，为了在finally里面关闭
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			//获取连接对象
			conn = DBUtils.getConn();
			//创建sql执行对象
			String sql = "select * from user limit ? , ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, (page-1)*mount);
			stat.setInt(2, mount);
			rs = stat.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println(id+","+name+","+age);
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
