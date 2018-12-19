package thread;
/**
 * 使用匿名内部类完成两种创建方式
 * @author soft01
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0;i<10000;i++) {
					System.out.println("你是谁啊");
				}
			}
		});
		Thread t2 = new Thread() {
			public void run() { 
				for(int i = 0;i<1000;i++) {
					System.out.println("我是查的水表");
				}			
		}
		};
		t1.start();
		t2.start();
	}
}

