package file;

import java.io.File;

/**
 * 创建一个多级目录
 * 
 * @author soft01
 *
 */
public class MkDirsDemo {

	public static void main(String[] args) {
	/*
	 * 在当前目录下创建a/b/c/d/e/f/目录
	 */
		File dir = new File("./a/b/c/d/e/f/");
		if(!dir.exists()) {
			dir.mkdirs();
			System.out.println("目录创建成功");
		}else {
			System.out.println("目录已存在");
		}
		System.out.println(dir);
	}

}
