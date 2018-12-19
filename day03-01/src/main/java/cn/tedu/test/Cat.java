package cn.tedu.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("a")
public class Cat extends Animal{
	@Value("小强")
	private String name;
	public void showInfo() {
		System.out.println("cat:"+name);
	}
}
