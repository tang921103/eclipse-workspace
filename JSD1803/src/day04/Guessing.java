package day04;

import java.util.Scanner;

public class Guessing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = (int)(Math.random()*1000+1);
		System.out.println(num);
		int guess;
		do {
			System.out.println("猜吧");
		  guess = scan.nextInt();
		  if(guess==0) {
				break;
			}
			if(guess>num) {
				System.out.println("猜大了");
			}else if(guess<num){
				System.out.println("猜小了");
			}		
		}while(guess!=num);
		if(guess==num) {
			System.out.println("恭喜你猜对了");
		}else {
			System.out.println("退出，下次再来吧");		
		}
		
		
		
		
		
		
		
		
		
		
		
		/*
		int chance = 1;
		System.out.println("猜吧");
		int guess = scan.nextInt();
		while(guess!=num&&chance<5) {
			if(guess==0) {
				break;
			}
			if(guess>num) {
				System.out.println("猜大了");
			}else {
				System.out.println("猜小了");
			}		
			System.out.println("猜吧");
			guess = scan.nextInt();
			chance++;			
		}
		if(guess==num) {
			System.out.println("恭喜你猜对了");
		}else if(guess==0){
			System.out.println("退出，下次再来吧");		
		}else {
			System.out.println("机会没有了");
		}
			*/
		
	}

}
