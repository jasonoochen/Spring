package service.impl;

import org.springframework.stereotype.Component;

import dao.ICustomerDao;
import service.ICustomerService;

/*
 * 客户的业务层实现类
 * 
 * 注解
 * 1.用于创建bean对象
 * 		@Component
 * 			作用：配置一个bean标签
 * 			出现位置：class上方
 * 			属性：value.含义是指定bean的id。当不写时，默认值是当前类的短名，首字母改小写
 */

@Component
public class CustomerServiceImpl implements ICustomerService {
	
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
