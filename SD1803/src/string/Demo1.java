package string;

public class Demo1 {
	public static void main(String[] args) {
		String str ="thinking in java";
		char c = str.charAt(3);
		System.out.println(c);
		String info = "上海自来水来自海上 ";
		for(int i = 0;i<info.length()/2;i++) {
			if(info.charAt(i)!=info.charAt(info.length()-i-1)){
				System.out.println("不是回文");
				return;
			}
		}
		System.out.println("是回文");
	}
}
