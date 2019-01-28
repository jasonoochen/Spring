package factory;

import dao.ICustomerDao;
import service.ICustomerService;

/*
 * 一个工厂类
 */

public class BeanFactory {

	public static ICustomerService getCustomerService() {
		try {
			return (ICustomerService) Class.forName("service.impl.CustomerServiceImpl").newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ICustomerDao getCustomerDao() {
		try {
			return (ICustomerDao) Class.forName("dao.impl.CustomerDaoImpl").newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
}
