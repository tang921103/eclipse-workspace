package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AddressController {
	@RequestMapping("/showAddress.do")
	public String showAddress() {
		return "show";
	}
	@RequestMapping("/addAddress.do")
	public String addAddress() {
		return "add";
	}
	@RequestMapping("/modifyAddress.do")
	public String modifyAddress() {
		return "modify";
	}
}
