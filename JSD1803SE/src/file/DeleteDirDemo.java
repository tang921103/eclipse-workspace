package file;

import java.io.File;

/**
 * 删除一个目录
 * @author soft01
 *
 */
public class DeleteDirDemo {

	public static void main(String[] args) {
		/*
		 * 将当前目录中的demo目录删除
		 */
		File dir = new File("./a/b/c/d/e/f");
		if(dir.exists()) {
			/*
			 * 删除目录的前提时该目录是一个空目录
			 * 多级目录只能一级一级的删除
			 */
			dir.delete();
			System.out.println("删除完毕");
		}else {
			System.out.println("目录不存在");
		}
	}

}
