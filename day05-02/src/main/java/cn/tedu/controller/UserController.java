package cn.tedu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.bean.User;
import cn.tedu.service.UserService;
import cn.tedu.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userServiceImpl;
	//显示登录页面
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	//登录验证
	@RequestMapping("/login.do")
	public String login(String username,String password,HttpSession session,ModelMap map) {
		System.out.println("name:"+username);
		try {
			User user = userServiceImpl.login(username, password);
			session.setAttribute("user",user);
			return "index";
		}catch(RuntimeException e) {
			if(e.getMessage().equals("用户名错误")|| e.getMessage().equals("密码错误")) {
				map.addAttribute("error", e.getMessage());
				return "login";		
			}
			throw new RuntimeException(e.getMessage());
		}
	}
	//显示个人信息页面
	@RequestMapping("/showInfo.do")
	public String showInfo() {
		return "info";
	}
	//退出
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		//session无条件失效
		session.invalidate();
		return "login";
	}
}
