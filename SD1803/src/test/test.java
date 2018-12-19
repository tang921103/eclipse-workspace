package test;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		int [] arr = new int[10];
		for(int i = 0;i<arr.length;i++) { 
			arr[i] = (int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		int max = arr[0];
		for(int i =1;i<arr.length;i++) {
			if(arr[i]>max) {
				int t = 0;
				t = arr[i];
				arr[i] = max;
				max = t;
			}
		}
		System.out.println(max);
		
  }
}
 