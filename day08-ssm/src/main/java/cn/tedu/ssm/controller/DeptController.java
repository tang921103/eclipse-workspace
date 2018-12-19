package cn.tedu.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ssm.bean.Dept;
import cn.tedu.ssm.service.IDeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Resource
	private IDeptService deptService;
	//显示addDept页面
	@RequestMapping("/showAddDept.do")
	public String  showAddDept() {
		return "addDept";
	}
	//添加部门信息
	@RequestMapping("/addDept.do")
	public String addDept(String deptName,String deptLoc) {
		Dept dept = new Dept();
		dept.setDeptName(deptName);
		dept.setDeptLoc(deptLoc);
		deptService.insertDept(dept);
		return "index";
	}
	@RequestMapping("/showAllDept.do")
	public String showAllDept(ModelMap map) {
		List<Dept> depts = deptService.showAll();
		map.addAttribute("all", depts);
		return "showAll";
	}
	@RequestMapping("/delete.do")
	public String removeDept(Integer id) {
		deptService.deleteDept(id);
		return "redirect:showAllDept.do";
	}
}
