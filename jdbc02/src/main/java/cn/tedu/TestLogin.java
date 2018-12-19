package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestLogin {
	public static void main(String[] args) {
		//获取用户输入的用户名和密码
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入用户名");
		String username = scan.nextLine();
		System.out.println("请输入密码");
		String password = scan.nextLine();
		//调用登陆方法
		boolean b = login(username,password);
		//判断登陆成功还是失败
		if(b) {
			System.out.println("登陆成功");
		}else {
			System.out.println("登陆失败");
		}
	}

	private static boolean login(String username, String password) {
		//把各种资源声明在try-catch外面，为了在finally里面关闭
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			//获取连接对象
			conn = DBUtils.getConn();
			//创建sql执行对象
			//stat = conn.createStatement();
			
			//执行sql
			/*String sql = "select count(*) from t_login where username='"+username+"' and password='"+password+"'";
			rs = stat.executeQuery(sql);*/
			//使用preparedStatement取代Statement
			String sql = "select count(*) from t_login where username=? and password=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			rs=stat.executeQuery();
			while(rs.next()) {
				//获取查询回来的唯一一个结果
				int count = rs.getInt(1);
				//判断是否登陆成功
				if(count>0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
		return false;
	}
}
