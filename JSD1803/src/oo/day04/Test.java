package oo.day04;

public class Test {
	public static void main(String[] args) {
		Person[] per = new Person[6];
		per[0]= new Student("zhangsan",23,"chongqing",113030129);
		per[1]= new Student("zhaosi",22,"chongqing",1103030129);
		per[2]= new Teacher("wangwu",33,"chongqing",5000.36);
		per[3]= new Teacher("zhaoliu",35,"chongqing",256.23);
		per[4]= new Doctor("zhangsi",22,"chongqing","主治医师");
		per[5]= new Doctor("wangqi",45,"chongqing","实习医师");
		for(int i = 0;i<per.length;i++) {
			System.out.println(per[i].name+"， "+per[i].age+"，"+per[i].address);
			per[i].sayHi();					
		}
		Person stu1 =  new Student("zhangsan",23,"chongqing",113030129);
		Student stu2 = new Student("zhangsan",23,"chongqing",113030129);
		stu1.sayHi();
		stu2.sayHi();
	}
}
