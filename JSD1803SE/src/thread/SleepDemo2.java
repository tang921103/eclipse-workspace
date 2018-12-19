package thread;
/**
 * 打断睡眠阻塞
 * @author soft01
 *
 */
public class SleepDemo2 {
	public static void main(String [] args) {
		Thread lin  = new Thread() {
			public void run() {
				System.out.println("睡觉");
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException e) {				
					System.out.println("干嘛呢");
				}
			}
		};
		Thread huang = new Thread() {
			public void run() {
				for(int i = 0;i<5;i++) {
					System.out.println("80");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {					
						e.printStackTrace();
					}
				}
				System.out.println("搞定");
				lin.interrupt();
			}
		};	
		lin.start();
		huang.start();
	}
}
