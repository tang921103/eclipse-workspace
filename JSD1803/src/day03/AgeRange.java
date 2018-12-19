package day03;
import java.util.Scanner;
public class AgeRange {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年龄：");
		int age = scan.nextInt();
		System.out.println(age);
		if(age>=18&&age<=50) {
			System.out.println("年龄介于18和50");
		}else {
			System.out.println();
		}
		}
	}


