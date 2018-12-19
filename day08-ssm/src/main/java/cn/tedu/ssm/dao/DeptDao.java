package cn.tedu.ssm.dao;

import java.util.List;

import cn.tedu.ssm.bean.Dept;

public interface DeptDao {
	void insertDept(Dept dept);
	List<Dept> selectAll();
	void deleteById(Integer id); 
}
