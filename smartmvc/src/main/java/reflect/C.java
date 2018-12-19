package reflect;

public class C {
	@Test(value="haha")
	public void m1() {
		System.out.println("C的m1的方法");
	}
	@Test(value="hehe")
	public String m2() {
		System.out.println("C的m2方法");
		return "I am m2";
	} 
	public void foo() {
		System.out.println("C的foo方法");
	}
}
