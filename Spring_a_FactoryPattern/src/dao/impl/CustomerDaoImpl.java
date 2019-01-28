package dao.impl;

import dao.ICustomerDao;

/*
 * 模拟客户的持久层实现类
 */

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public void saveCustomer() {
		System.out.println("持久层保存了客户");
	}

}
