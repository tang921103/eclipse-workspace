package cn.tedu.demo;

public class BeanLife {
	//自定义对象调用的无参构造方法
	public BeanLife() {
		System.out.println("BeanLife的构造器");
	}
	//自定义初始化方法
	public void init() {
		System.out.println("BeanLife的初始化");
	}
	//自定义销毁方法
	public void destroy() {
		System.out.println("BeanLife的销毁");
	}
	
}
