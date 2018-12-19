package lambda;

public class Demo2 {
	public static void main(String[] args) {
		Runnable r = ()->System.out.println(Thread.currentThread());
		Thread t = new Thread(r);
		t.start();
	}
}
