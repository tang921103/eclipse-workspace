package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class ScopeAction {
	public String test1() {
		ServletContext sc = ServletActionContext.getServletContext();
		HttpServletRequest rs = ServletActionContext.getRequest();
		HttpSession session = rs.getSession();
		sc.setAttribute("skey", "contextScope");
		rs.setAttribute("rkey", "requestScope");
		session.setAttribute("session", "sessionScope");
		return "ok";
	}
}
