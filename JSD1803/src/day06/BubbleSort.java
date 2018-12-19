package day06;

public class BubbleSort {

	public static void main(String[] args) {
			int[] aar = new int[10];
			for(int i = 0;i<aar.length;i++) {
				aar[i]  = (int)(Math.random()*100);
			}
		for(int i = 0;i<aar.length-1;i++) {
			for(int j = 0;j<aar.length-1-i;j++) {
				if(aar[j]>aar[j+1]) {
					int t = aar[j];
					aar[j] = aar[j+1];
					aar[j+1] = t;
				}
			}
		}
		for(int i = 0;i<aar.length;i++) {
			System.out.println(aar[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*int[] aaa = new int[10];
		for(int i = 0;i<aaa.length;i++) {
			aaa[i] = (int)(Math.random()*100);
		}
		for(int i = 0;i<aaa.length-1;i++) {
			for(int j = 0;j<aaa.length-1-i;j++) {
				if(aaa[j]>aaa[j+1]) {
					int t = aaa[j];
					aaa[j] = aaa[j+1];
					aaa[j+1] = t;
				}
			}
		}
		for(int i = 0;i<aaa.length;i++) {
			System.out.println(aaa[i]);
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*	int[] a = new int[10];
			for(int i = 0;i<a.length;i++) {
				a[i] = (int)(Math.random()*100);				
			}
			for(int i = 0;i<a.length-1;i++) {
				for(int j = 0;j<a.length-1-i;j++) {
					if(a[j]>a[j+1]) {
						int t = a[j];
						a[j] = a[j+1];
						a[j+1] = t;
					}
				}
			}
			for(int i = 0;i<a.length;i++) {
				System.out.println(a[i]);
			}*/
	}

}
