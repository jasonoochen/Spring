package service.impl;

import dao.ICustomerDao;
import dao.impl.CustomerDaoImpl;
import factory.BeanFactory;
import service.ICustomerService;

/*
 * 客户的业务层实现类
 */

public class CustomerServiceImpl implements ICustomerService {
	
//	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	private ICustomerDao customerDao = BeanFactory.getCustomerDao();
	
	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
		customerDao.saveCustomer();
	}

}
