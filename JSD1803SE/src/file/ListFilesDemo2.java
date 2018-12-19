package file;

import java.io.File;
import java.io.FileFilter;

/**
 * File提供了一个重载listFiles的方法，可以指定一个文件
 * 过滤器，然后将一个目录中满足过滤器要求的子项返回。不满足的则忽略。
 * @author soft01
 *
 */
public class ListFilesDemo2 {

	public static void main(String[] args) {
		File dir = new File(".");
		File[] subs = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
		 		return file.getName().endsWith(".txt");
	}
	});
		for(int i = 0;i<subs.length;i++) {
			System.out.println(subs[i]);
		}
		System.out.println(subs.length);
	}

}
 class MyFilter implements FileFilter{
	public boolean accept(File file) {
		String name = file.getName();
		System.out.println("正在过滤"+name);
		return name.endsWith(".txt");
	}
}
