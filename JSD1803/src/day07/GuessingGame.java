package day07;
import java.util.Scanner;
public class GuessingGame {

	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);	
		char[] chs = generate();	
		System.out.println(chs);
		int count = 0;
		while(true) {
			System.out.println("猜吧");
			String str = scan.next().toUpperCase();
			if(str.equals("EXIT")) {
				System.out.println("退出");
				break;
			}
			char[] input = str.toCharArray();
			int[] result = check(chs,input);
			if(result[0]==chs.length) {
			  int score = 100*chs.length-10*count;
				System.out.println("恭喜你猜对了,得分为"+score);
				break;
			}else {
				System.out.println("猜错了"+"字符对了"+result[1]+"个"+"，位置对了"+result[0]+"个");
				count++;
			}
		}
	}
	public static char[] generate() {
		
		char[] chs = new char[5];
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		boolean[] flags = new boolean[letters.length];
		for(int i = 0;i<chs.length;i++) {
			int index;
			do {
				 index = (int)(Math.random()*letters.length);
			}while(flags[index]==true);
			
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}
	public static int[] check(char[] chs,char[] input) {
		int[] result = new int[2];
		for(int i = 0;i<chs.length;i++) {
			for(int j = 0;j<input.length;j++) {
				if(chs[i]==input[j]) {
					result[1]++;
					if(i==j) {
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
}
