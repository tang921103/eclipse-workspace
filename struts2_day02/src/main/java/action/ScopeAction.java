package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

public class ScopeAction implements ServletContextAware,ServletRequestAware{
	private ServletContext con;
	private HttpServletRequest req;
	
	public ServletContext getCon() {
		return con;
	}
	public void setCon(ServletContext con) {
		this.con = con;
	}
	public HttpServletRequest getReq() {
		return req;
	}
	public void setReq(HttpServletRequest req) {
		this.req = req;
	}
	public String test1() {
		ServletContext sc = ServletActionContext.getServletContext();
		HttpServletRequest sr = ServletActionContext.getRequest();
		HttpSession session = sr.getSession();
		sc.setAttribute("context", "application");
		sr.setAttribute("request", "requestScope");
		session.setAttribute("session", "sessionScope");
		return "ok";
	}
	public String test2() {
		req.setAttribute("request2", "requestScope2");
		con.setAttribute("context2", "application2");
		req.getSession().setAttribute("session2", "session2");
		return "ok";
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		req = request;
	}
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		con = context;
	}
}
