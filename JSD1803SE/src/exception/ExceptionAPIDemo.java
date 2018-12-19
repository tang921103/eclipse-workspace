package exception;
/**
 * 异常常用方法
 * @author soft01
 *
 */
public class ExceptionAPIDemo {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "a";
			System.out.println(Integer.parseInt(str));
		}catch(Exception e) {
			//输出错误堆栈信息，有助于定位错误并解决
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("程序结束了");
	}
}
