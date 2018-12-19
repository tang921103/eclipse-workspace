package thread;
/**
 * 线程的第二种创建方式：定义单线程任务
 * 实现Runuable接口并重写run方法。
 * @author soft01
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		//实例化线程任务
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		//创建线程
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}

class MyRunnable1 implements Runnable{
	public void run() {
		for(int i = 0;i<10000;i++) {
			System.out.println("Hello");
		}
	}
}
class MyRunnable2 implements Runnable{
	public void run() {
		for(int i = 0;i<10000;i++) {
			System.out.println("World");
		}
	}
}