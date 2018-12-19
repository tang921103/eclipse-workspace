package cn.tedu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	@Value("#{test.name}")
	private String name;
	public void showName() {
		System.out.println(name);
	}
}
