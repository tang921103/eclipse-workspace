package object;

public class Point {
	private int x;
	private int y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "point:[x:"+x+",y:"+y+"]";
	}
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		if(obj instanceof Point) {
			Point p = (Point)obj;
			return p.x == this.x && p.y == this.y;
		}
		return false;
	}
}
