package cn.tedu.ssm.service;

import java.util.List;

import cn.tedu.ssm.bean.Dept;

public interface IDeptService {
	void insertDept(Dept dept);
	List<Dept> showAll();
	void deleteDept(Integer id);
}
