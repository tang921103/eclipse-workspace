package reflect;
/**
 * 使用该类测试反射机制
 * @author soft01
 *
 */
public class Person {
		public void sayHello() {
			System.out.println("大家好");
		}
		public void sayHello(String name) {
			System.out.println("大家好，我叫"+name);
		}
		public void sayHello(String name,int age) {
			System.out.println("大家好！我叫"+name+",今年"+age+"岁了");
		}
		public void sayHi() {
			System.out.println("Hi!");
		}
		private void dosome() {
			System.out.println("我是私有方法");
		}
}
