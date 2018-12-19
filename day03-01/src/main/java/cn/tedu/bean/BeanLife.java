package cn.tedu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
//实例化BeanLifeD对象
//Component("life")表示被bean对象起名，等价于bean标签中的id属性值。
@Component("life")
public class BeanLife {
		public BeanLife() {
			System.out.println("life构造方法");
		}
		//定义初始化方法的注解
		//@PostConstruct是tomcat运行环境依赖的jar包。
		@PostConstruct
		public void init() {
			System.out.println("life的初始化方法");
		}
		//做业务的方法
		public void service() {
			System.out.println("life的service方法");
		}
		//表示定义销毁的方法
		//@PreDestroy是tomcat运行环境依赖的jia包
		@PreDestroy
		public void destroy() {
			System.out.println("life的销毁方法");
		}
}
