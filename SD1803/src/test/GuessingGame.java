package test;

import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate();
		while(true) {
			System.out.println("请输入");
			String input = scan.nextLine().toUpperCase();
			if("EXIT".equals(input)) {
				break;
			}
			char[] user = input.toCharArray();
			int[] count = check(chs,user);
			System.out.println(chs);
			if(count[1]==chs.length) {
				System.out.println("猜对了");
				break;
			}else {
				System.out.println("个数对了:"+count[0]+",位置对了："+count[1]);
			}
			
		}
		
		
		
	}
	public static char[] generate() {
		char[] chs = new char[5];
		char[] src = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		boolean[] flag = new boolean[src.length];
		for(int i =0;i<chs.length;i++) {
			while(true) {
			int index = (int)(Math.random()*src.length);	
			if(!flag[index]) {
				chs[i] = src[index];
				flag[index] = true;
				break;
			}
			}
		}
		return chs;
	}
	public static int[] check(char[] chs,char[] user) {
		int[] count = new int[2];
		for(int i =0;i<chs.length;i++) {
			boolean repeat = true;
			for(int j=0;j<user.length;j++) {
				if(chs[i]==user[j]) { 			
					if(i==j) {
						count[1]++;
					}
				repeat = false;
				}
				}
			if(!repeat) {
				count[0]++;
			}
		}
		return count;
	}
}
