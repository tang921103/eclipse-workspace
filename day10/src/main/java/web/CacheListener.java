package web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import utils.User;
import utils.UserDAO;

public class CacheListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		 UserDAO dao = new UserDAO();	
		 System.out.println("创建ServletContext");
		 try {
			List<User> users = dao.showAll();
			System.out.println(users);
			ServletContext sctx = sce.getServletContext();
			sctx.setAttribute("users", users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

}
