package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

public class ScopeAction implements ServletContextAware,ServletRequestAware{
	private HttpServletRequest req;
	private ServletContext con;
	public String test1() {
		ServletContext sc = ServletActionContext.getServletContext();
		HttpServletRequest rs = ServletActionContext.getRequest();
		HttpSession session = rs.getSession();
		sc.setAttribute("skey", "contextScope");
		rs.setAttribute("rkey", "requestScope");
		session.setAttribute("session", "sessionScope");
		return "ok";
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		req = request;
		req.setAttribute("rkey1", "requestScope1");
	}

	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		con = context;
		con.setAttribute("skey1", "contextScope1");
	}
}
