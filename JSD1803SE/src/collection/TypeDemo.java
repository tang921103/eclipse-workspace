package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK1.5之后推出了一个特性：泛型
 * 
 * 泛型又称为参数化类型，允许调用者在调用某个类的功能时传入一个或者多个类型来
 * 定义该类的属性，方法的参数以及返回值的类型。这大大提高了代码的灵活度。
 * 
 * 泛型应用最广泛的地方就是集合。用来指定集合中的元素的类型。
 * @author soft01
 *
 */
public class TypeDemo {
	public static void main(String[] args) {
		//泛型的原型就是Object
		Collection<String> c = new ArrayList<String>();
		//编译器检测实参类型是否符合泛型要求。
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		for(String str : c) {
			System.out.println(str);
		}
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			//获取元素时无需再造型
			String str = it.next();//如果Iterator没有指定泛型，则next()返回值类型是默认的Object类型。
			System.out.println(str);
		}
	}
}
