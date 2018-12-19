package day06;
import java.util.Arrays;
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
		/*
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
		
		
		arr = Arrays.copyOf(arr,arr.length+1);
		arr[arr.length-1] = max;
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
			*/
		int[] a = {2,3,4,5,6};
		int[] b = new int[7];
		System.arraycopy(a,0,b,3,4);
		
		for(int i = 0;i<b.length;i++) {					
			System.out.println(b[i]);			
		}
			}
}
