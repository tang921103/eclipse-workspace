package bin;

public class Demo01 {

	public static void main(String[] args) {
		for(int i = 0;i<=63;i++) {
				System.out.print(i+" ");
				System.out.println(Integer.toBinaryString(i));
			}
		int a = 63;
		System.out.println(a);
		System.out.println(
				Integer.toBinaryString(a));
		int b = 22;
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b));
		int c = a+b;
		System.out.println(c);
		System.out.println(Integer.toBinaryString(c));
		int d = a*b;
		System.out.println(d);
		System.out.println(Integer.toBinaryString(d));
		int e = a-b;
		System.out.println(e);
		System.out.println(Integer.toBinaryString(e));
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		//0110 1110 0110 1010 1010 1011 0101 1101
		//0x6e6aab5d
		//1101 0101 1010 0110 1101 0011 1101 1111 
		//0xd5a6d3df
		int num = 0x6e6aab5d;
		System.out.println(Integer.toBinaryString(num));
		int num1 = 0xd5a6d3df;
		System.out.println(Integer.toBinaryString(num1));
		
	}

}
