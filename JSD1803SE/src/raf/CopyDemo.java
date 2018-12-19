package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author soft01
 *
 */
public class CopyDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("study.txt","r");
		RandomAccessFile desc = new RandomAccessFile("study_cp","rw");
		while(desc.read()!=-1) {
		desc.write(src.read());
		}
		System.out.println("复制完毕");
	}

}
