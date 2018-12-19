package cn.tedu.json.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.json.bean.City;
import cn.tedu.json.bean.ResponseResult;
import cn.tedu.json.bean.User;
@Controller
public class UserController {
	//响应客户端的数据为state:1,message:成功
	@RequestMapping("/test1.do")
	//不返回页面就使用这个注解
	@ResponseBody
	public ResponseResult<Void> test1(){
		//封装了状态码和状态码表示的信息
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"成功");
		return rr;
	}
	//返回对象
	@RequestMapping("/showData.do")
	@ResponseBody
	public ResponseResult<User> test2(){
		//1.创建rr对象
		ResponseResult rr = new ResponseResult();
		//2.创建User对象
		User user = new User();
		user.setId(1);
		user.setName("唐秋");
		user.setAddress("恩施");
		user.setPhone("123456");
		rr.setData(user);
		rr.setState(1);
		rr.setMessage("成功");
		//3.返回rr对象
		return rr;
	}
	//返回list集合
	@RequestMapping("/test3.do")
	@ResponseBody
	public ResponseResult<List<User>> test3(){
		ResponseResult<List<User>> rr = new ResponseResult<List<User>>();
		User user1 = new User();
		User user2 = new User();
		user1.setId(1);
		user1.setName("唐秋");
		user1.setAddress("恩施");
		user1.setPhone("123456");
		user2.setId(2);
		user2.setName("关羽");
		user2.setAddress("三国");
		user2.setPhone("55555");
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		rr.setData(list);
		return rr;			
	}
	@RequestMapping("/cityData.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceValue){
		ResponseResult<List<City>> rr = new ResponseResult<List<City>>();
		List<City> list = new ArrayList<City>();
		if(provinceValue.equals("1")) {
			City city1 = new City();
			City city2 = new City();
			city1.setCode(11);;
			city1.setName("武汉");
			city2.setCode(12);
			city2.setName("恩施");
			list.add(city2);
			list.add(city1);
		}else if(provinceValue.equals("2")){
			City city1 = new City();
			City city2 = new City();
			city1.setCode(21);;
			city1.setName("郑州");
			city2.setCode(22);
			city2.setName("洛阳");
			list.add(city2);
			list.add(city1);
		}
		rr.setData(list);
		rr.setMessage("成功");
		rr.setState(1);
		return rr;
	}
}
