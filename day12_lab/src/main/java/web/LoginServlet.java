package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		/*
		 * 调用dao对象方法查询数据库，如果有匹配条件的记录，则登陆成功，重定向到用户列表，
		 * 否则登陆失败，转发到登陆页面并提示用户。
		 */
		try {
			UserDAO dao = new UserDAO();
			User user = dao.find(username);
			if(user != null&& user.getPassword().equals(password)) {
				//登陆成功
				HttpSession session = request.getSession(true);
				
				session.setAttribute("user", user);
				response.sendRedirect("list");
			}else {
				//登陆失败
				request.setAttribute("login_failed", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error","系统异常，请稍后重试！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
		
}
