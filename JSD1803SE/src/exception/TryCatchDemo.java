package exception;
/**
 * java异常处理机制中的try-catch
 * 语法：
 * try{
 * 		
 * 			代码片段
 * 
 * }catch(xxxException e){
 * 
 * 捕获try代码片段中出现的xxxException后的处理的后段
 * 
 * }
 * @author soft01
 *
 */
public class TryCatchDemo {
	public static void main(String[] args) {
		System.out.println("程序开始了");
	
		/*
		 * 当JVM执行代码遇到异常时，会实例化该异常的一个实 例，然后设置好代码执行的过程
		 * 并将该异常抛出
		 * 如果抛出异常的代码所在方法没有处理异常的能力，异常会抛到当前方法之外，
		 * 由调用当前方法的代码片段去处理。
		 */
		try {
			String str ="a";
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
			/*
			 * try代码片段中出错的代码之后内容都不会被运行。
			 */
			System.out.println("!!");
		}catch(NullPointerException e) {
			System.out.println("空指针异常");
			/*
			 * catch可以定义多个，针对不同的异常有不同的处理手段，可以分别捕获这些异常。
			 */
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("字符串下标越界异常");
			/*
			 * 应当有一个好习惯，在最后一个catch中捕获Exception，尽量避免因为一个未捕获的
			 * 异常导致程序中断。
			 * 捕获顺序应当是子类型异常在上面先捕获，父类型异常在下后捕获。
			 */
		}catch(Exception e) {
			System.out.println("反正就是报了个错");
		}
		
		System.out.println("程序结束了");
		
	}

}
