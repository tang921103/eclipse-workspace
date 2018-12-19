package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtils;

public class ListUserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	//查询出所有用户信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//依据查询到的用户信息生成表格
			out.println("<table align='center' text-align='center' border='1' width='20%' cellpadding='0' cellspacing='0'>");
			out.println("<tr><td>ID</td><td>用户名</td><td>密码</td><td>邮箱</td><td>操作</td></tr>");
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String tr = "<tr><td>"+id+"</td><td>"+username+"</td><td>"+password+"</td><td>"+email+"</td><td><a href='del?id="+id+"'>删除</a></td></tr>";
				out.println(tr);
			}
			out.println("</table>");
			out.println("<p align='center'><a href='addUser.html'>添加用户</p>");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("系统繁忙，请稍后重试！");
		}finally {
			DBUtils.close(rs, ps, conn);
		}
	}
	
}
