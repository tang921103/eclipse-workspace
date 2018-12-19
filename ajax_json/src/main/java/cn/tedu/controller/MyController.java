package cn.tedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.bean.City;
import cn.tedu.bean.ResponseData;
import cn.tedu.bean.User;

@Controller
public class MyController {
		@RequestMapping("/show.do")
		public String show() {
			return "user";
		}
		@RequestMapping("/showUser.do")
		@ResponseBody
		public ResponseData<User> showUser() {
			ResponseData<User> rd = new ResponseData<User>();
			User user = new User();
			user.setName("唐秋");
			user.setAddress("湖北省利川市");
			user.setEmail("tangqiuemail@sina.cn");
			rd.setData(user);
			rd.setState(1);
			rd.setMessage("OK");
			return rd;
		}
		@RequestMapping("/showCity.do")
		@ResponseBody
		public ResponseData<List<City>> showCity(Integer code){
			ResponseData<List<City>> rd = new ResponseData<List<City>>();
			List<City> list = new ArrayList<City>();
			if(code == 1) {
				City c1 = new City(11,"武汉");
				City c2 = new City(12,"恩施");
				list.add(c1);
				list.add(c2);
			}else if(code == 2) {
				City c1 = new City(21,"郑州");
				City c2 = new City(22,"洛阳");
				list.add(c1);
				list.add(c2);
			}
			rd.setState(1);
			rd.setMessage("OK");
			rd.setData(list);
			return rd;
		}
}
