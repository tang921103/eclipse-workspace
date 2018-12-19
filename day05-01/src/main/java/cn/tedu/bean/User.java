package cn.tedu.bean;

public class User {
	private String name;
	private int age;
	private String password;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", password=" + password + "]";
	}
	
}
