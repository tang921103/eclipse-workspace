package thread;
/**
 * 线程能允许我们“同时执行”多段代码
 * 线程有两种创建方式
 * 1：继承Thread并重写run方法，在run方法中定义线程要执行的任务。
 * @author soft01
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		t1.start();
		t2.start();
		/*
		 * 线程启动要调用start方法，而不是直接调用run方法。
		 * start方法的作用是将线程纳入线程调度中，线程调度会
		 * 统一管理需要并发运行的多个线程，调度CPU，分配时间片段给线程，
		 * 得到时间片段的线程会被cpu运行这段时间，运行完毕后，线程调度会再
		 * 分配时间片段给一个线程使cpu运行该线程。
		 * 线程调度分配时间片段给每个线程并非有序的“一人一次"，
		 * 但是在整体的过程中，每个线程获取的cpu时间片段的次数是基本一致的。
		 */
	}
}
/**
 * 第一种创建线程方式存在两种不足：
 * 1：由于java是单继承，这就导致杂实际开发中我们往往需要继承
 * 某个类复用方法，而当前类又需要并发运行，导致不能同时又继承
 * 复用方法的类又继承线程。
 * 2：定义线程的同时重写run方法定义任务，这就导致了线程和任务
 * 有一个必然的耦合关系，不利于线程的重用。
 * @author soft01
 *
 */
class MyThread1 extends Thread{
	public void run() {
		for(int i = 0;i<10000;i++) {
			System.out.println("Hello");
		}
	}
}
class MyThread2 extends Thread{
	public void run() {
		for(int i = 0;i<10000;i++) {
		System.out.println("World");
		}
	}	
}
