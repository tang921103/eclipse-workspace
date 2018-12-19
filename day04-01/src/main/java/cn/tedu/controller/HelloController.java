package cn.tedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//定义（业务）控制器类
public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController!");
		//创建ModelAndView对象
		//并且设置视图名称（不包含扩展名）
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		return mv;
	}
		
}
