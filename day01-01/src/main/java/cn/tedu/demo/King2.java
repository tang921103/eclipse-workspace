package cn.tedu.demo;

public class King2 {
	/**
	 * 需要的时候初始化
	 */
	private static King2  king ;
	private King2() {	}
	public static King2 getKing2() {
		if(king==null) {
			king = new King2();
		}
		return king;
	}
} 
