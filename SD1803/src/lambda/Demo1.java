package lambda;

public class Demo1 {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
			
		};
		Thread t = new Thread(r);
		t.start();
	}
}
