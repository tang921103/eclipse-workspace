package cn.tedu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.bean.User;

@Controller
@RequestMapping("/demo")
public class DemoController {
		//显示页面demo.jsp
	@RequestMapping("/showDemo.do")
	public String showDemo() {
		return "demo";
	}
	//使用request传值
	//特点：直接，但是不能自动类型转换。
	@RequestMapping("/test1.do")
	public String test1(HttpServletRequest request) {                                                                                                                                                                                                                                               
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String password = request.getParameter("password");
		System.out.println(name+","+age+","+password);
		return "ok";
	}
	//通过属性传值
	//特点：1 变量名必须和表单组件的name值相同
	//2 可以实现类型转换
	//3 在类型转换时可能会出现异常
	@RequestMapping("/test2.do")
	public String test2(String name,Integer age,String password) {
		System.out.println(name+" "+age+" "+password);
		return "ok";
	}
	//属性传值
	//表单组件的name属性值和变量名不相同，需要使用@RequestParam("password")辅助完成赋值
	//password表示表单组件的name属性值。
	@RequestMapping("/test3.do")
	public String test3(String name,Integer age ,@RequestParam("password")String pwd) {
		System.out.println(name+" "+age+" "+pwd);
		return "ok";
	}
	//bean对象传值
	//1.把表单组件的name属性值封装到bean类中。
	//2.方法的参数传递封装类类型的对型即可。
	//3.如果前端提交的数据较多，建议使用此种方式。
	@RequestMapping("/test4.do")
	public String test4(User user) {
		System.out.println(user);
		return "ok";
	}
	//request和session对象
	@RequestMapping("/test5.do")
	public String test5(HttpServletRequest request) {
		request.setAttribute("name", "admin");
		HttpSession session = request.getSession();
		session.setAttribute("age", "25");
		return "ok";
	}
	//使用ModelAndView传值
	//1.ModelAndView的构造方法中可以设置一个map对象
	//2.map对象经过框架处理后会把key-value设置到request中。
	@RequestMapping("test6.do")
	public ModelAndView test6() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "控制器向页面传值");
		ModelAndView mv = new ModelAndView("ok",map);
		return mv;
	}
	//ModelMap传值(ModelMap是框架提供的，我们不需要去初始化它)
	//1.ModelMap 是框架提供的map集合
	//2.ModelMap 同样是被框架设置到request对象中
	@RequestMapping("test7.do")
	public String test7(ModelMap map) {
		//设置属性值 
		map.addAttribute("error", "登录失败！");
		return "ok";
	}
	@RequestMapping("/login.do")
	public String login(ModelMap map,String name,String password) {
		if("admin".equals(name) && "123456".equals(password)) {
			return "ok";
		}else {
			map.addAttribute("tips", "用户名或者密码错误");
			return "demo";
		}
	}
	//转发和重定向
	@RequestMapping("/test9.do")
	public String test9(String name,HttpServletRequest request) {
		//如果用户是adimin，则转发到ok.jsp
		//如果用户不是admin，则重定向到demo.jsp
		if("admin".equals(name)) {
			return "forward:test.jsp";
		}else {
			return "redirect:/demo/showDemo.do";
		}
	}
}
