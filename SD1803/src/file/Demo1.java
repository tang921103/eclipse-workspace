package file;

import java.io.File;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		File file = new File("./demo.txt");
		String name = file.getName();
		System.out.println(name);
		if	(!file.exists()) {
			file.createNewFile();
		}
		System.out.println(file.length());
		System.out.println(file.isFile());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		System.out.println(file.isHidden());
	}
}
