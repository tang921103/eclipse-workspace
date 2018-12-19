package cn.tedu.demo;

public class User {
	public User() {
		System.out.println("User的无参构造方法");
	}
	public void init() {
		System.out.println("user的初始化方法");
	}
	public void destroy() {
		System.out.println("user的销毁方法");
	}
}
