package bin;

public class Demo2 {

	public static void main(String[] args) {		
		for(int i = -10;i<0;i++) {
			System.out.println(Integer.toBinaryString(i));
		}
		int a = 10;
		System.out.println(Integer.toBinaryString(a));	
		int b = -10;
		System.out.println(Integer.toBinaryString(~a));
		System.out.println(Integer.toBinaryString(~a+1));
		System.out.println(Integer.toBinaryString(b));
		System.out.println();
		int c = -100;
		int d = 100;
		System.out.println(Integer.toBinaryString(100));
		System.out.println(Integer.toBinaryString(~100+1));
		System.out.println(Integer.toBinaryString(-100));
		int n = 100;
		byte b1 = (byte)(n+413);
		System.out.println(b1);
		int m = 0x234a8f2e;
		System.out.println(Integer.toBinaryString(m));
		int m1 = m<<1;
		System.out.println(Integer.toBinaryString(m1));
		int m2 = m<<2;
		System.out.println(Integer.toBinaryString(m2));
		int m8 = m<<8;
		System.out.println(Integer.toBinaryString(m8));
		/** 
		 *                    00100011 01001010 10001111 00101110
                                    10001101001010100011110 01011100
                           10001101001010100011110010111000
                              1001010100011110010111000000000
		 */
		int num2 = 1;
		for(int i = 0;i<32;i++) {
			System.out.println(Integer.toBinaryString(num2<<i));
		}
				
	}
	
}
