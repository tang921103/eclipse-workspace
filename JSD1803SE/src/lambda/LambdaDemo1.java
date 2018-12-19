package lambda;
/**
 * JDK8之后推出了一个新特性，lambda表达式
 * 使用lambda可以快速简单的创建仅含有一个抽象方法接口或者抽象类的子类实例（替代匿名内部类的创建）
 * 
 * lambda语法：
 * ([参数列表])->{方法体}
 * @author soft01
 *
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread()+":hello");
			}
		};
		Thread t = new Thread(r);
		t.start();
		/*
		 * lambda是编译器认可，最终会被改为内部类形式创建并且编译器会结合源代码上下文自动分析
		 * 要匿名创建的类型。由于要求该接口只能由一个方法，所以方法不存在争议。
		 */
		Runnable r1 = ()->{System.out.println(Thread.currentThread()+":word");};
		Thread t1 = new Thread(r1);
		t1.start();
		/*
		 * 当重写的方法中只有一句代码时，lambda可以忽略{}
		 */
		Runnable r2 = ()->System.out.println(Thread.currentThread()+":helloword");
		Thread t2 = new Thread(r2);
		t2.start();
	}
}
