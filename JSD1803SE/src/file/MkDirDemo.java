package file;

import java.io.File;

/**
 * 使用File新建一个目录
 * @author soft01
 *
 */
public class MkDirDemo {

	public static void main(String[] args) {
		File dir = new File("./demo");
		if(!dir.exists()) {
			dir.mkdir();
			System.out.println("目录已创建");
		}else {
			System.out.println("目录已存在");
		}
			
	}

}
