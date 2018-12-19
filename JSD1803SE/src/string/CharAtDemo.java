package string;
/**
 * char charAt(int index)
 * 获取指定位置对应的字符
 * @author soft01
 *
 */
public class CharAtDemo {
	public static void main(String[] args) {
		String str = "thinking in java";
		//获取第五个字符
		char a = str.charAt(4);
		System.out.println(a);
		/*
		 * 检测回文
		 * 检测规律 正数位置的字符与倒数位置的字符都一样的是回文
		 */
		String info = "上海自来水来自海上";
		for(int i =0;i<info.length()/2;i++) {
			if(info.charAt(i)!=info.charAt(info.length()-1-i)) {
				System.out.println("不是回文");
				return;
			}		
		}
		System.out.println("是回文");
	}
}
