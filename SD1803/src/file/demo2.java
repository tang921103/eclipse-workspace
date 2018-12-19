package file;

import java.io.File;

public class demo2 {
	public static void main(String[] args) {
		File dir = new File("./a/");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		System.out.println(dir);
		if(dir.isDirectory()) {
			File[] subs = dir.listFiles();
			System.out.println(subs.length);
			for(int i =0;i<subs.length;i++) {
				System.out.println(subs[i].getName());
			}
		}
		
	}
}
