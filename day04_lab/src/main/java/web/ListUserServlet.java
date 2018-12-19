package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		
		try {
			// 查询出所有用户信息
			UserDAO dao = new UserDAO();
			List<User> users = dao.findAll();
			/*
			 * 因为servlet不便于生成复杂的页面，所以通常转发给jsp，由jsp来生成页面。
			 */
			//1.绑订数据到请求对象request
			request.setAttribute("users", users);
			//2.获得转发器
			RequestDispatcher rd = request.getRequestDispatcher("listUser4.jsp");
			//3.转发
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			//转发到系统处理异常页面
			request.setAttribute("error", "系统繁忙，稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
