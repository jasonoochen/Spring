package service.impl;

import service.ICustomerService;

/*
 * 客户的业务层实现类
 */

public class CustomerServiceImpl implements ICustomerService {
	
//	private ICustomerDao customerDao = new CustomerDaoImpl();
	
//	private ICustomerDao customerDao = BeanFactory.getCustomerDao();
	
//	private ICustomerDao customerDao = null;
	
	public CustomerServiceImpl() {
		System.out.println("bean object created");
	}
	
	public void init() {
		System.out.println("bean object initialized");
	}
	
	public void destroy() {
		System.out.println("bean object destroied");
	}
	
	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
//		customerDao.saveCustomer();
	}

}
