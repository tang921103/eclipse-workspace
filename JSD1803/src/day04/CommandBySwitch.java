package day04;

import java.util.Scanner;

public class CommandBySwitch {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请选择功能:1.显示全部记录 2.查询登陆记录 0.退出");
		int command = scan.nextInt();
		System.out.println(command);
		switch(command) {
		case 1:
			System.out.println("显示全部记录");
			break;
		case 2:
			System.out.println("查询登陆记录"); 
			break;
		case 0:
			System.out.println("退出");
			break;
		default :
				System.out.println("输入错误");				
		}
		if(command==1) {
			System.out.println("显示全部记录");
		}else if(command==2) {
			System.out.println("查询登陆记录");
		}else if(command==0) {
			System.out.println("退出");
		}else {
			System.out.println("输入错误");
		}
		switch(command) {
		case 1:
			System.out.println("显示全部记录");
			break;
		case 2:
			System.out.println("查询登陆记录");
			break;
		case 0: 
			System.out.println("退出");
			break;
		default:
				System.out.println("输入错误");
		}
	}	

}
