package test;

import java.util.Arrays;
/**
 * 冒泡排序
 * @author soft01
 *
 */
public class demo4 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i =0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.print(arr[i]+",");
		}
		for(int i= 0;i<arr.length-1;i++) {
			for(int j =0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
		}
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
