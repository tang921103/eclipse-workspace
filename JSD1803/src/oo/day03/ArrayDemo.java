package oo.day03;

public class ArrayDemo {

	public static void main(String[] args) {	
		Student[] studs = new Student[3];
		studs[0] = new Student("zhangsan",22,"chongqing");
		studs[1] = new Student("zhaosi",23,"chongqing");
		studs[2] = new Student("wangwu",24,"chongqing");
		System.out.println(studs[1].name+"，"+studs[2].age);
		Student[] ss = new Student[] {
				 new Student("zhangsan",22,"chongqing"),
				 new Student("zhaosi",23,"chongqing"),
			   new Student("wangwu",24,"chongqing")
		};
		int[][] arr = new int[3][];
		arr[0] = new int[2];
		arr[1] = new int[3];
		arr[2] = new int[4]; 
		arr[0][1] = 100;
		System.out.println(arr[0][1]);
		int[][] ass = new int[3][4];
		for(int i =0;i<ass.length;i++) {
			for(int j = 0;j<ass[i].length;j++) {
				ass[i][j] = (int)(Math.random()*100);
				System.out.print(ass[i][j]+" ");				
			}
			System.out.println();
		}
		
	}
}
