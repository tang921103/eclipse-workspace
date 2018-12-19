package demo.controller;

import javax.servlet.http.HttpServletRequest;

import base.annotation.RequestMapping;

/**
 *  处理器：
 *  负责处理业务逻辑。
 * @author soft01
 *
 */
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("HelloContrlo的hello方法");
		//返回的是视图名
		return "hello";
	}
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("HelloControl的hello方法");
		return "login";
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		System.out.println("HelloControl的hello方法");
		String uname = request.getParameter("uname");
		System.out.println("用户名："+uname);
		return "redirect:welcome.do";
	}
	@RequestMapping("/welcome.do")
	public String wel() {
		return "welcome";
	}
}
