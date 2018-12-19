package day05;

public class MaxOfArray {

	public static void main(String[] args) {
	/*
		int[] arr = new int[10];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100);
		}
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		int[] arr = new int[10];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.println("第"+(i+1)+"个数为"+arr[i]);
		}*/
		/*
		int[] arr = new int[10];
		for(int i =0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		int max = arr[0];
		int min = arr[0];
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]>max) {
				max= arr[i];
			}
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		System.out.println("最大值为"+max);
		System.out.println("最小值为"+min);
		*/
		int[] arr = new int[12];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.println(arr[i]);						
		}
		int max = arr[0];
		int min = arr[0];
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]>max){
				max = arr[i];
			}
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		System.out.println("最大值"+max);
		System.out.println("最小值"+min);
		System.out.println(max-min);
	}

}
