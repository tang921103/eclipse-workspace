package file;

import java.io.File;
import java.io.IOException;

/**
 * 删除一个文件
 * @author soft01
 *
 */
public class DeleteFileDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * 将当前目录中的text.txt文件删除
		 */
		File file = new File("./test.txt");
		if(!file.exists()) {
			file.createNewFile();
			System.out.println("文件创建完毕");
		}else {
			System.out.println("文件已存在");
		}
		
	}

}
