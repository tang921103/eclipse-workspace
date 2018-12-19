package test;

public class demo1 {
	public static void main(String [] args) {
		int[] arr = new int[10];
		for(int i =0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		int max = arr[0];
		for(int i =1;i<arr.length;i++) {
			if(arr[i]>max) {
				int t = arr[i];
				arr[i] = max;
				max = t;
			}
			
		}
		System.out.println(max);
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
