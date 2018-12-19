package test;

import java.util.Arrays;

public class demo2 {
	public static void main(String[] args) {
		int [] arr1 = new int[] {10,20,30,40,50};
		int [] arr2 = new int[5];
		System.arraycopy(arr1,1,arr2,0,4);
		arr1 = Arrays.copyOf(arr1,6);
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		
	}
}
