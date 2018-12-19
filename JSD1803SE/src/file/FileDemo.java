package file;

import java.io.File;

/**
 * java.io.File
 * File的每一个实例可以用于表示文件系统中的一个文件或目录
 * 使用File可以：
 * 	1.访问文件或目录的属性（名字 大小 修改时间等）
 * 	2.操作文件或目录（创建 删除）
 * 	3.访问一个目录的子项
 * 但是不能读写文件数据
 * @author soft01
 *
 */
public class FileDemo {
	/**
	 * 路径尽量选取相对路径，不同系统的路径方式不同
	 * 相对路径可以做到跨平台
	 * 
	 * eclipse中当前目录（./）是当前程序所在项目的目录
	 * 例如：
	 * windows：D：/workspace/JSD1803SE/
	 * linux：home/soft01/eclipse-workspace/JSD1803SE/
	 * @param args
	 */
	public static void main(String [] args) {
		File file = new File("./demo.txt");
		String name = file.getName();
		System.out.println("name"+name);
		long len = file.length();
		System.out.println("len"+len);
		boolean kd = file.canRead();
		boolean kx = file.canWrite();
		System.out.println("是否可读"+kd);
		System.out.println("是否可写"+kx);
		boolean isHidden = file.isHidden();
		System.out.println("是否隐藏:"+isHidden);
		
	}
}
