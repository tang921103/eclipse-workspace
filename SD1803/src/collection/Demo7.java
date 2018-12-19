package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo7 {
	public static void main(String[] args) {
		   List<Point> list = new ArrayList<Point>();
		   list.add(new Point(1,2));
		   list.add(new Point(3,4));
		   list.add(new Point(3,1));
		   Collections.sort(list,new Comparator<Point>() {
			   	public int compare(Point p1,Point p2) {
			   		return p1.getX() - p2.getX();
			   	}
		   });
		   System.out.println(list);
	}
}
