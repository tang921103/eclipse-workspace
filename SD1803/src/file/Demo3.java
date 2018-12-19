package file;

import java.io.File;
import java.io.FileFilter;

public class Demo3 {
	public static void main(String[] args) {
		File dir = new File(".");
		File[] subs = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.getName().endsWith("txt");
			}
		});
		for(File f : subs) {
			System.out.println(f);
		}
	}
}
