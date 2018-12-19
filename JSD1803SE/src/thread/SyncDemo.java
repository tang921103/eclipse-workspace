package thread;
/**
 * 当多个线程并发操作同一资源时就形成了“抢”的局面；
 * 由于线程切换不确定，可能会导致线程操作资源时未按照
 * 程序预订的执行顺序代码，导致逻辑出现混乱。
 * 严重时可导致系统崩溃。
 * @author soft01
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table table = new Table();
		 Thread t1 = new Thread() {
			public void run() {
				while(true) {
				int beans =table.getBeans();
				Thread.yield();
				System.out.println(getName()+":"+beans);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
				int beans = table.getBeans();
				System.out.println(getName()+":"+beans);
				}
			}
		};
		t1.start();
		t2.start();
	}
}
class Table{
	private int beans = 20;
	/*
	 * 当一个方法被synchronized修饰后，那么该方法成为同步方法，
	 * 即：多个线程不能同时在方法内部执行，从而解决了并发安全问题。
	 * 
	 * 在方法上使用synchronized，那么同步监视器对象就是当前方法所属对象
	 * 即：方法内部看到的this
	 */
	public synchronized int getBeans() {
		if(beans== 0) {
			throw new RuntimeException("没有豆子");
		}
		Thread.yield();
		return beans--;
	}
}
