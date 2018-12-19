package day05;

import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int score= 0 ;
		int i = 0;
			for(int times = 1;times<=10;times++) {
				int num1 = (int)(Math.random()*100);
				int num2 = (int)(Math.random()*100);
				int question = num1+num2;
				System.out.println("("+times+")"+num1+"+"+num2+"=?");
				System.out.println("请输入计算结果");
				int result = scan.nextInt();
				if(result==-1) {
					break;
				}
				if(question==result) {
					System.out.println("答对了");
					score += 10;
					i++;
				}else {
					System.out.println("答错了");
				}
			}
			String judge = (score>=60)?"及格":"不及格";
			System.out.println("答对"+i+"题"+",分数"+score+"，"+judge);
	}

}
