package thread;
/**
 * 互斥锁
 * 当使用synchronized锁住多段不同的代码片段，但是这些同步代码
 * 使用的同步监视器对象是同一个，那么这些代码片段之间就是互斥的。
 * 多个线程不能同时执行他们。
 * @author soft01
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		Boo boo = new Boo();
		Thread t1 = new Thread() {
			public void run() {
				boo.methodA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				boo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}
class Boo{
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":程序开始执行");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+":执行完毕");
	}
	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":开始执行");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println(t.getName()+":执行完毕");
	}
}
