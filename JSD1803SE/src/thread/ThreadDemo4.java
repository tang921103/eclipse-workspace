package thread;
/**
 * 获取线程相关信息的一组方法
 * @author soft01
 *
 */
public class ThreadDemo4 {
	public static void main(String [] args) {
		Thread main = Thread.currentThread();
		
		//获取线程的名字
		String name = main.getName();
		System.out.println("name:"+name);
		//获取线程的唯一标识
		long id = main.getId();
		System.out.println("ID:"+id);
		
		int priority = main.getPriority();
		System.out.println("优先级："+priority);
		
		boolean isAlive = main.isAlive();
		System.out.println("isAlive:"+isAlive);
		
		boolean isDaemon = main.isDaemon();
		System.out.println("是否为守护线程:"+isDaemon);
		
		boolean isInterrupted = main.isInterrupted();
		System.out.println("是否被中断:"+isInterrupted);
	}
}
