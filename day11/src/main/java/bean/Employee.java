package bean;

public class Employee {
	private int ename;
	private double salary;
	private int age;
	private String[] msg;
	public String[] getMsg() {
		return msg;
	}
	public void setMsg(String[] msg) {
		this.msg = msg;
	}
	public int getEname() {
		return ename;
	}
	public double getSalary() {
		return salary;
	}
	public int getAge() {
		return age;
	}
	public void setEname(int ename) {
		this.ename = ename;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
