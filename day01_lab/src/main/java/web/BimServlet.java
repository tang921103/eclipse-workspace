package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BimServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double weight = Integer.parseInt(request.getParameter("weight"));
		double height = Integer.parseInt(request.getParameter("height"));
		String[] interest = request.getParameterValues("interesting");
		if(interest != null) {
			for(String str:interest) {
				System.out.println(str);
			}
		}
		

		/*
		 *  在服务器端一定要对请求参数值进行合法性检查。
		 */
		int bim = (int)(weight/height/height*100*100);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter  out = response.getWriter();
		out.println("你的BIM指数是："+bim);
		if(bim<19) {
			out.println("体重过轻");
		}else if(bim>25) {
			out.println("体重过重");
		}else {
			out.println("体重正常");
		}
		/*
		 * out.close()方法可以不调用，因为容器最后会自动关闭。
		 */
		out.close();		
	}
}
