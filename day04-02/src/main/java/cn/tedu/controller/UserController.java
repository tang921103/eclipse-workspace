package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//@Controller表示实例化控制器
@Controller
public class UserController {
		//定义方法，显示注册页面
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		//框架会把字符串封装到ModelAndView对象中
		return "register";
	}
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
}
