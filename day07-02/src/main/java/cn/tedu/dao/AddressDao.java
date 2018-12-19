package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.Address;

public interface AddressDao {
	Integer insertAddress(Address address);
	Integer updateAddress(Address address);
	Integer deleteAddress(Integer id);
	Address selectById(Integer id);
	List<Address> selectAll();
}
