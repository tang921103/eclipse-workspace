package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/toBmi".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/view1.jsp").forward(request, response);;
		}else if("/bmi".equals(path)) {
			String weight = request.getParameter("weight");
			String height = request.getParameter("height");
			BmiService bmi = new BmiService();
			String msg = bmi.bmi(Double.parseDouble(height), Double.parseDouble(weight));
			request.setAttribute("bmi", msg);
			request.getRequestDispatcher("/WEB-INF/view2.jsp").forward(request, response);
		}
	}

}
