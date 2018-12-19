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

public class AddUserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 告诉服务端，如何对请求参数进行解码；
		 * 注： 这行代码要添加到所有的getParameter方法的前面。
		 * 		只针对post请求有效
		 */
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj==null) {
				response.sendRedirect("login.jsp");
			}else {
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");	
			UserDAO dao = new UserDAO();	
			try {
				/*
				 * 先检查用户名是否存在，如果存在则提示用户“用户名已存在”，
				 * 否则将用户信息插入到数据库。
				 */
				User user = dao.find(username);			
				if(user==null) {
					//将数据插入到数据库				
						user = new User();
						user.setUname(username);
						user.setPassword(password);
						user.setEmail(email);				
						dao.save(user);
						//重定向到用户列表
						response.sendRedirect("list");					
				}else {
					request.setAttribute("user_exist", "用户已存在！");
					request.getRequestDispatcher("addUser.jsp").forward(request, response);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				request.setAttribute("error", "系统繁忙，请稍后再试");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			}
			
	}

}
