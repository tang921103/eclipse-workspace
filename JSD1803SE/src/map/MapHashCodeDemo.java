package map;

import java.util.HashMap;

public class MapHashCodeDemo {
	public static void main(String [] args) {
		/*
		 * 作为key的类，如果不能很好的重写equale 和 hashCode方法，
		 * 会造成HashMap工作故障。
		 */
		HashMap<Player,String> map = new HashMap<>();
		map.put(new Player(1), "吃鸡");
		map.put(new Player(2),"英雄联盟");
		map.put(new Player(3),"魂斗罗");
		map.put(new Player(4),"吃鸡");
		Player one = new Player(1);
		String name = map.get(one);
		System.out.println(name);
	}
}
class Player{
	private int id;
	public Player(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}	
}
