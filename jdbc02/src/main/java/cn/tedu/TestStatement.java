package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestStatement {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
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
			while(true) {		
				System.out.println("请输入姓名");
				String name = scan.nextLine();
				if("EXIT".equals(name.toUpperCase())) {
					break;
				}
				System.out.println("请输入年龄");
				int age = Integer.parseInt(scan.nextLine());
				String sql = "insert into user values(null,'"+"\'"+name+"\'"+","+age+")";
				stat.executeUpdate(sql);
				System.out.println("插入成功");			
			}									
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}
}
