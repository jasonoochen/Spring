package dao.impl;

import org.springframework.stereotype.Repository;

import dao.ICustomerDao;

/*
 * 模拟客户的持久层实现类
 */

@Repository("customerDaoImpl")
public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public void saveCustomer() {
		System.out.println("持久层保存了客户");
	}

}
