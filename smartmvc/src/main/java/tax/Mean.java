package tax;

public class Mean extends SuperMean{
	@Exe(value=1)
	public void method() {
		System.out.println("子类方法");
	}
	public Mean() {
		System.out.println("构造器");
	}
	@Exe(value=2)
		public void run() {
			System.out.println("run方法");
		}
}
