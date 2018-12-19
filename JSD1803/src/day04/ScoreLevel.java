package day04;

import java.util.Scanner;

public class ScoreLevel {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入成绩：");
		int score = scan.nextInt();
		System.out.println(score);
		if(score<0||score>100) {
			System.out.println("成绩无效");
		}else if(score>=90) {
			System.out.println("A优秀");
		}else if(score>=80){
			System.out.println("B良好");
		}else if(score>=60) {
			System.out.println("C一般");
		}else {
			System.out.println("不及格");
		}
			
		if(score>=0&&score<=100) {
			if(score>=90){
				System.out.println("A");
			}else if(score>=80) {
				System.out.println("B");
			}else if(score>=60) {
				System.out.println("C");
			}else {
				System.out.println("不及格");
			}
		}else {
			System.out.println("成绩不合法");
		}
	}

}
