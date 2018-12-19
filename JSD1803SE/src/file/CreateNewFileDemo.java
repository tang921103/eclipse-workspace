package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 * 
 * @author soft01
 *
 */
public class CreateNewFileDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下创建test.txt文件
		 */
		File file = new File("./text.txt");
		File file2 = new File("./study.txt");
		/*
		 * boolean exists()  
		 * 判断当前file表示的文件或目录是否已经存在
		 */
		if(!file.exists()) {
			file.createNewFile();
		}else {
			System.out.println("文件已存在");
		}
		if(!file2.exists()) {
			file2.createNewFile();
		}else {
			System.out.println("文件2已存在");
		}
		
		System.out.println(file2.getName()+" "+file2.length());
	}

}
