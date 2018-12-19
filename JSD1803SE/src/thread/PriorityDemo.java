package thread;
/**
 * 线程优先级
 * 线程之所以能得以并发运行，是靠线程调度的工作，
 * 线程调度会分配CPU时间片给某个线程，使得其可以运行。
 * 线程不能主动获取cpu时间。
 * 调整线程的优先级可以最大程度的改善某个线程获取cpu
 * 时间片段的次数。理论上线程优先级越高的线程获取cpu
 * 时间片的次数越多。
 * 线程的优先级由数字1-10表示，1是最低优先级，10是最高
 * 优先级，5为默认值。
 * @author soft01
 *
 */
public class PriorityDemo {
	public static void main(String[] args) {
		Thread max = new Thread() {
			public void run() {
				for(int i = 0;i<1000;i++) {
				System.out.println("max");
				}
			}
		};
		Thread min = new Thread() {
			public void run() {
				for(int i = 0;i<1000;i++) {
					System.out.println("min");
				}
			}
		};
		Thread norm = new Thread() {
			public void run() {
				for(int i = 0;i<1000;i++) {
					System.out.println("norm");
				}
			}
		};
		max.setPriority(max.MAX_PRIORITY);
		min.setPriority(min.MIN_PRIORITY);
		min.start();
		norm.start();
		max.start();
		
	}
}
