package string;

public class Demo2 {
	public static void main(String[] args) {
		String reg = "\\w+@[0-9a-zA-Z]+(\\.[a-zA-Z]+)+";
		String email ="tangqiuemail@sina.cn";
		boolean flag = email.matches(reg);
		System.out.println(flag);
	}
}
