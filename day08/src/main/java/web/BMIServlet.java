package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet{
	private int max;
	private int min;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println(request.getParameter("height"));
		System.out.println(request.getParameter("weight"));
		Double height = Double.parseDouble(request.getParameter("height"));
		Double weight = Double.parseDouble(request.getParameter("weight"));
		int bmi = (int)(weight/height/height);
		String str = null;
		if(bmi>max) {
			 str = "过重";
		}else if(bmi<min){
			str = "过轻";
		}else {
			str = "正常";
		}
		request.setAttribute("bmi","bmi"+bmi+":"+str );
		request.getRequestDispatcher("bmi.jsp").forward(request, response);
		//response.getWriter().println("bmi"+bmi+":"+str);
	}

	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		max = Integer.parseInt(config.getInitParameter("max"));
		min = Integer.parseInt(config.getInitParameter("min"));
		System.out.println(max);
		System.out.println(min);
	}
	
}
