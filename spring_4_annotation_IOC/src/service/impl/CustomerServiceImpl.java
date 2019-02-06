package service.impl;

import dao.ICustomerDao;
import service.ICustomerService;

/*
 * 客户的业务层实现类
 */

public class CustomerServiceImpl implements ICustomerService {
	
//	private ICustomerDao customerDao = new CustomerDaoImpl();
	
//	private ICustomerDao customerDao = BeanFactory.getCustomerDao();
	
	private ICustomerDao customerDao = null;

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
		customerDao.saveCustomer();
	}

}
