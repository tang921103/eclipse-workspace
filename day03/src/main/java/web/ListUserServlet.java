package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class ListUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			// 查询出所有用户信息
			UserDAO dao = new UserDAO();
			List<User> users = dao.findAll();
			// 依据查询到的用户信息生成表格
			out.println(
					"<table align='center' text-align='center' border='1' width='20%' cellpadding='0' cellspacing='0'>");
			out.println("<tr><td>ID</td><td>用户名</td><td>密码</td><td>邮箱</td><td>操作</td></tr>");
			for (User u : users) {
				int id = u.getId();
				String username = u.getUname();
				String password = u.getPassword();
				String email = u.getEmail();
				String tr = "<tr><td>" + id + "</td><td>" + username + "</td><td>" + password + "</td><td>" + email
						+ "</td><td><a href='del?id=" + id + "'>删除</a></td></tr>";
				out.println(tr);
			}
			out.println("</table>");
			out.println("<p align='center'><a href='addUser.html'>添加用户</p>");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("系统繁忙，请稍后重试！");
		}
	}

}
