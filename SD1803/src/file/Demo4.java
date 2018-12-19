package file;

import java.io.File;

public class Demo4 {
	public static void main(String[] args) {
		File dir = new File("./a");
		del(dir);
		
	}
	public static void del(File file) {
		if(file.isDirectory()) {
			File[] subs = file.listFiles();
			for(int i =0;i<subs.length;i++) {
					del(subs[i]);
					}
			}
		file.delete();
		}
		
	}

