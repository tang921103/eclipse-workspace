package cn.tedu.demo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestInjection {
	private String name;
	private Integer age;
	private List<String> list;
	private Set<String> set;
	private Map<String,Object> map;
	private Properties pro;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public void setPro(Properties pro) {
		this.pro = pro;
	}
	@Override
	public String toString() {
		return "TestInjection [name=" + name + ", age=" + age + ", list=" + list + ", set=" + set + ", map=" + map
				+ ", pro=" + pro + "]";
	}
	
}
