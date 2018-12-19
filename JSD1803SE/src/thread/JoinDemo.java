package thread;
/**
 * join方法可以协调线程之间的同步运行。
 * join方法会让运行该方法的线程处于阻塞状态，
 * 直到该方法所属线程运行完毕才会解除阻塞。
 * @author soft01
 *
 */
public class JoinDemo {
private static boolean isFinish = false;
public static void main(String[] args) {
	Thread load = new Thread() {
		public void run() {
			System.out.println("开始下载图片了");
			for(int i = 0;i<100;i++) {
				System.out.println("下载"+i+"%");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			System.out.println("下载完毕");
			isFinish = true;
		}
	};
	Thread show = new Thread() {
		public void run() {
			System.out.println("开始显示图片了");
			try {
				//将show线程组阻塞，直到load将任务执行完毕
				load.join();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
				if(!isFinish) {
				throw new RuntimeException();			
			}
				System.out.println("显示完毕");
		}	
	};
	load.start();
	show.start();
}
}
