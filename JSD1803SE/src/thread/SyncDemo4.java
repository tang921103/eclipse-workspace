package thread;
/**
 * 死锁现象
 * 当多个线程都持有自己的锁，但是都等对方先释放锁时，就会出现“僵持“的情况，
 * 使得所有线程进入阻塞状态。
 * 这个现象成为死锁现象。
 * @author soft01
 *
 */
public class SyncDemo4 {
	public  static void main(String [] args) {
		Coo coo = new  Coo();
		Thread t1 = new Thread() {
			public void run() {
				coo.methodA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				coo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}
class Coo{
	private Object lockA = new Object();
	private Object lockB = new Object();
	public void methodA() {
		Thread t = Thread.currentThread();
		synchronized(lockA) {
			System.out.println(t.getName()+":持有A的锁，开始运行A方法");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
			System.out.println(t.getName()+"开始运行B方法");
			methodB();
		}
		System.out.println("A方法执行完毕");
	}
	public void methodB() {
		Thread t = Thread.currentThread();
		synchronized(lockB) {
			System.out.println(t.getName()+":持有B的锁，开始运行B方法");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getName()+":开始运行A方法");
			methodA();
		}
		System.out.println("B方法执行完毕");
	}
}