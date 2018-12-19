package cn.tedu.demo;

public class King1 {
	/**
	 * 饿汉式：加载类的时候直接初始化
	 */
	private static final King1 king = new King1();
	private King1() {}
	public static King1 getKing() {
		return king;
	}
}
