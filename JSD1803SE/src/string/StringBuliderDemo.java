package string;
/**
 * StringBuilder是专门设计用来修改字符串内容的
 * 内部维护一个可变的字符数组。开销小，性能好
 * 
 * 所以凡是有频繁修改字符串内容操作时，都应当使用它来完成。
 * @author soft01
 *
 */
public class StringBuliderDemo {
	public static void main(String[] args) {
		/*
		 * 默认创建的StringBuilder表示一个空字符串
		 */
		StringBuilder builder = new StringBuilder("好好学习java");
		/*
		 * 好好学习java，为了找个好工作！
		 */
    		builder.append("，为了找个好工作！");
		 String str = builder.toString();
		 System.out.println(str);
		 /*
		  * 好好学习java，就是为了改变世界！
		  * replace 替换部分内容
		  */
		 builder.replace(9, 16, "就是为了改变世界");
		 str = builder.toString();
		 System.out.println(str);
		 /*
		  * delete 删除指定范围内的字符串
		  */
		 builder.delete(0, 9);
		 str = builder.toString();
		 System.out.println(str);
		 /*
		  * insert 将给定内容插入到指定位置
		  */
		 builder.insert(0, "活着");
		 str= builder.toString();
		 System.out.println(str);
	}
}
