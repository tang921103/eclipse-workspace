package reflect;

public class D {
	@RequestMapping(value="方法一")
	public void d1() {
		System.out.println("d1方法");
	}
	@RequestMapping(value="方法二")
	public void d2() {
		System.out.println("d2方法");
	}
	public String d3() {
		System.out.println("d3方法");
		return "我是d3";
	}
}
