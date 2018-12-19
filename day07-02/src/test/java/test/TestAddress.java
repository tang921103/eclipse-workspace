package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.tedu.bean.Address;
import cn.tedu.dao.AddressDao;
import cn.tedu.util.SqlSessionUtil;

public class TestAddress {
	@Test
	public void testInsertAddress() {
		SqlSession session = SqlSessionUtil.getSession();
		AddressDao dao = session.getMapper(AddressDao.class);
		Address address = new Address();
		address.setProvince("湖北a");
		address.setCity("恩施a");
		address.setArea("利川a");
		address.setUserAddress("东城a");
		dao.insertAddress(address);
		session.commit();
		session.close();
	}
	@Test
	public void testUpdate() {
		SqlSession session = SqlSessionUtil.getSession();
		AddressDao dao = session.getMapper(AddressDao.class);
		Address address = new Address();
		address.setProvince("湖北");
		address.setCity("恩施");
		address.setArea("利川");
		address.setUserAddress("东城");
		address.setId(1);
		Integer a = dao.updateAddress(address);
		System.out.println(a);
		session.commit();
		session.close();
	}
	@Test
	public void testDelete() {
		SqlSession session = SqlSessionUtil.getSession();
		AddressDao dao = session.getMapper(AddressDao.class);
		dao.deleteAddress(2);
		session.commit();
		session.close();
	}
	@Test
	public void testSelectById() {
		SqlSession session = SqlSessionUtil.getSession();
		AddressDao dao = session.getMapper(AddressDao.class);
		Address address = dao.selectById(2);
		session.commit();
		session.close();
		System.out.println(address);
		
	}
	@Test
	public void testSelectAll() {
		SqlSession session = SqlSessionUtil.getSession();
		AddressDao dao = session.getMapper(AddressDao.class);
		List<Address> list = dao.selectAll();
		for(Address add: list) {
			System.out.println(add);
		}
		session.commit();
	}
}
