package ui;

import factory.BeanFactory;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;

/*
 * 模拟一个表现层，用于调用业务层
 */

public class Client {

	public static void main(String[] args) {
//		ICustomerService customerService = new CustomerServiceImpl();
//		ICustomerService customerService = BeanFactory.getCustomerService();
		ICustomerService customerService = (ICustomerService) BeanFactory.getBean("CUSTOMERSERVICE");
		customerService.saveCustomer();
	}

}
