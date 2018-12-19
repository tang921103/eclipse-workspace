package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("path:" + path);
		if("/toLogin".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else if("/toAdd".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
		}	else if ("/login".equals(path)) {
			processLogin(request, response);
		} else if ("/list".equals(path)) {
			processList(request, response);
		} else if ("/add".equals(path)) {
			processAdd(request, response);
		} else if ("/del".equals(path)) {
			processDel(request, response);
		}
	}

	private void processDel(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj == null) {
			response.sendRedirect("toLogin.do");
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				User user = new User();
				user.setId(id);
				UserDAO dao = new UserDAO();
				dao.delete(user);
				response.sendRedirect("list.do");
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "系统繁忙，请稍后再试！");
				request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}
		}
	}

	private void processAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		/*
		 * 告诉服务端，如何对请求参数进行解码； 注： 这行代码要添加到所有的getParameter方法的前面。 只针对post请求有效
		 */
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj == null) {
			response.sendRedirect("toLogin.do");
		} else {
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			UserDAO dao = new UserDAO();
			try {
				/*
				 * 先检查用户名是否存在，如果存在则提示用户“用户名已存在”， 否则将用户信息插入到数据库。
				 */
				User user = dao.find(username);
				if (user == null) {
					// 将数据插入到数据库
					user = new User();
					user.setUname(username);
					user.setPassword(password);
					user.setEmail(email);
					dao.save(user);
					// 重定向到用户列表
					response.sendRedirect("list.do");
				} else {
					request.setAttribute("user_exist", "用户已存在！");
					request.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				request.setAttribute("error", "系统繁忙，请稍后再试");
				request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}
		}
	}

	private void processList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// session验证，登陆过的才可以访问list
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj == null) {
			// 没有登陆，重定向到登录页面
			response.sendRedirect("toLogin.do");
		} else {
			try {
				// 查询出所有用户信息
				UserDAO dao = new UserDAO();
				List<User> users = dao.findAll();
				/*
				 * 因为servlet不便于生成复杂的页面，所以通常转发给jsp，由jsp来生成页面。
				 */
				// 1.绑订数据到请求对象request
				request.setAttribute("users", users);
				// 2.获得转发器
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listUser4.jsp");
				// 3.转发
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				// 转发到系统处理异常页面
				request.setAttribute("error", "系统繁忙，稍后重试");
				request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}
		}
	}

	private void processLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		/*
		 * 调用dao对象方法查询数据库，如果有匹配条件的记录，则登陆成功，重定向到用户列表， 否则登陆失败，转发到登陆页面并提示用户。
		 */
		try {
			UserDAO dao = new UserDAO();
			User user = dao.find(username);
			if (user != null && user.getPassword().equals(password)) {
				// 登陆成功
				HttpSession session = request.getSession(true);

				session.setAttribute("user", user);
				response.sendRedirect("list.do");
			} else {
				// 登陆失败
				request.setAttribute("login_failed", "用户名或密码错误");
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "系统异常，请稍后重试！");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}
	}
}
