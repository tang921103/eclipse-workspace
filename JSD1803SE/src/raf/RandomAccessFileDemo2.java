package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写基本类型数据，以及RAF指针的操作
 * 
 */
public class RandomAccessFileDemo2 {

	public static void main(String[] args) throws IOException {
	RandomAccessFile raf = new RandomAccessFile("test.txt","rw");
	/*
	 * 获取指针位置
	 * long getFilePointer()
	 * 
	 */
	long pos = raf.getFilePointer();
	System.out.println(pos);
	/*
	 * 向文件中写入最大值
	 */
	int max = Integer.MAX_VALUE;
	raf.write(max>>>24);
	System.out.println(raf.getFilePointer());
	raf.write(max>>>16);
	raf.write(max>>>8);
	raf.write(max);
	System.out.println(raf.getFilePointer());
	/*
	 * RAF提供了方便我们写出基本类型的相关方法
	 * 一次性将给定的int值4字节全部全部写出
	 * readInt() 、read() 的返回值类型？ int
	 * 
	 */
	raf.writeInt(max);
	raf.writeLong(123L);
	System.out.println(raf.getFilePointer());
	raf.writeDouble(134.56);
	/*
	 * void seek(long pos)
	 * 移动指针到指定位置
	 */
	raf.seek(0);
	System.out.println(raf.getFilePointer());
	System.out.println(raf.readInt());
	System.out.println(raf.getFilePointer());
	System.out.println(raf.readInt());
	System.out.println(raf.getFilePointer());
	System.out.println(raf.readLong());
	System.out.println(raf.getFilePointer());
	System.out.println(raf.readDouble());
	System.out.println(raf.getFilePointer());
	raf.close();
	System.out.println("写入完毕");
	}

}
