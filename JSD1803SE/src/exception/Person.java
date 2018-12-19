package exception;
/**
 * 使用当前类测试异常的抛出
 * @author soft01
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws IllegalAgeException{
		/*
		 * 当不满足业务逻辑要求时，可以主动抛异常
		 * 
		 * 当一个方法中使用throw抛出一个异常时就应该在当前方法上使用throws声明该异常的抛出，
		 * 通知调用者在调用当前方法时要处理异常（RuntimeException除外）
		 * 否则编译不通过。
		 */
		if(age<0||age>100) {
			throw new IllegalAgeException("年龄不合法");
		}
		this.age = age;
	}
	
}
