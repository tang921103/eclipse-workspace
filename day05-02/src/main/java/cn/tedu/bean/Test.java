package cn.tedu.bean;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Set<User> set = new HashSet<User>();
		User u1 = new User();
		u1.setId(1);
		u1.setUsername("tang");
		u1.setPassword("123");
		u1.setEmail("aaa");
		u1.setPhone("234");
		
		User u2 = new User();
		u2.setId(1);
		u2.setUsername("tang");
		u2.setPassword("123");
		u2.setEmail("aaa");
		u2.setPhone("234");
		set.add(u1);
		set.add(u2);
		for(User u : set) {
			System.out.println(u);
		}
	}

}
