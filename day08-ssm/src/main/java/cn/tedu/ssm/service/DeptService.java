package cn.tedu.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ssm.bean.Dept;
import cn.tedu.ssm.dao.DeptDao;
@Service
public class DeptService implements IDeptService{
	@Resource
	private DeptDao deptDao;
	public void insertDept(Dept dept) {
		deptDao.insertDept(dept);
	}
	public List<Dept> showAll(){
		return deptDao.selectAll();
	}
	public void deleteDept(Integer id) {
			deptDao.deleteById(id);
	}
}
