package cn.tedu.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
@Component
public class Person {
	@Resource
	private Animal a;
	public void handler() {
		a.showInfo();
	}
}
