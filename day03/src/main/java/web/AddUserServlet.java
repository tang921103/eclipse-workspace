package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");		
			response.setContentType("text/html;charset=utf-8");
			PrintWriter  out = response.getWriter();
			//将数据插入到数据库
			
			try {
				User user = new User();
				user.setUname(username);
				user.setPassword(password);
				user.setEmail(email);
				UserDAO dao = new UserDAO();
				dao.save(user);
				out.println("添加成功");
				//重定向到用户列表
				response.sendRedirect("list");
			} catch (SQLException e) {
				//记日志（保留现场）
				e.printStackTrace();
				/*
				 * 看异常能否恢复，如果不能恢复（比如数据库服务暂停，或者网络中断等产生的异常，一般称为系统异常）
				 * 提示用户稍后重试。
				 */
				out.println("系统繁忙，稍后重试！");
			}
	}

}
