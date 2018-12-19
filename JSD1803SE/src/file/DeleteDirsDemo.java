package file;

import java.io.File;

/**
 * 练习题：
 * 1.请编写代码，完成1+2+3+4+...+100并输出结果
 * 	  在代码中不得出现for  while关键字
 * 2：一个人买汽水，1元1瓶汽水，3个瓶盖可以换1瓶汽水，2个空瓶可以换1瓶汽水，
 * 编写一段程序计算20块钱可以买到多少汽水。
 * 
 * 删除目录
 * 由于delete方法删除目录时必须是一个空目录
 * 那么在实际情况中，我们需要先将一个要删除的目录清空才可以将其删除
 * 递归调用（方法内部调用自己方法的现象）
 * 递归能不用就不用，随着递归的次数增加，内存开销大。
 * 1：递归现象必须在一个分之中控制
 * 2：层级尽量少
 * @author soft01
 *
 */
public class DeleteDirsDemo {

	public static void main(String[] args) {
		File file = new File("./a");
		delete(file);
	}
	public static void delete(File file) {
		if(file.isDirectory()) {
			/*
			 * 先将目录清空
			 * 1.获取该目录的所有子项
			 * 2.遍历将他们一个一个删除
			 */
			File[] subs = file.listFiles();
			for(int i = 0;i<subs.length;i++) {
				File sub = subs[i];
				delete(sub);
			}
		}
		file.delete();
	}
}
