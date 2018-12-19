package cn.tedu.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Dog extends Animal{
	@Value("旺财")
	private String name;
	public void showInfo() {
		System.out.println("dog:"+name);
	}
}
