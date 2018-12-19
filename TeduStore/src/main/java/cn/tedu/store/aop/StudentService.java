package cn.tedu.store.aop;

import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{

	public void add() {
		System.out.println("添加成功");
	}

	public void update() {
		System.out.println("修改成功");
	}

	public void delete() {
		System.out.println("删除成功");
	}

	public void get() {
		System.out.println("获取成功");
	}

	public void getAll() {
		System.out.println("获取所有成功");
	}

}
