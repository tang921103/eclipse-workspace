package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestStatement2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//把各种资源声明在try-catch外面，为了在finally里面关闭
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		System.out.println("请输入姓名");
		String name = scan.nextLine();
		System.out.println("请输入年龄");
		int age = Integer.parseInt(scan.nextLine());
		try {
			//获取连接对象
			conn = DBUtils.getConn();
			//创建预编译sql执行对象
			String sql = "insert into user values(null,？,?)";
			stat = conn.prepareStatement(sql);
			//把？替换为真正的值（数字代表？的位置）
			stat.setString(1, name);
			stat.setInt(2, age);
			//执行sql
			stat.executeUpdate();
			System.out.println("插入成功");			
											
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
}
