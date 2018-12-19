package thread;
/**
 * 静态方法若使用synchronized修饰后，那么该方法
 * 一定具有同步效果。
 * @author soft01
 *
 */
public class SyncDemo2 {
	public static void main(String [] args) {
	Thread t1 = new Thread() {
		public void run() {
			Foo.dosome();
		}
	};
	Thread t2 = new Thread() {
		public void run() {
			Foo.dosome();
		}
	};
	t1.start();
	t2.start();
}
}
class Foo{
	public synchronized static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在执行");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		System.out.println(t.getName()+":执行完毕");
	}
}
