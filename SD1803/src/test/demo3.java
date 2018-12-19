package test;

import java.util.Arrays;

public class demo3 {
	public static void main(String[] args) {
		int [] arr = new int[10];
		for(int i =0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100);
		}
		int max = arr[0];
		for(int i =0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println(max);
		arr = Arrays.copyOf(arr,arr.length+1);
		arr[arr.length-1] = max;
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
