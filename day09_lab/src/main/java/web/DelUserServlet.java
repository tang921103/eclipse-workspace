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

public class DelUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj == null) {
			response.sendRedirect("login.jsp");
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				User user = new User();
				user.setId(id);
				UserDAO dao = new UserDAO();
				dao.delete(user);
				response.sendRedirect("list");
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "系统繁忙，请稍后再试！");
				request.getRequestDispatcher("error").forward(request, response);
			}
		}
	}

}
