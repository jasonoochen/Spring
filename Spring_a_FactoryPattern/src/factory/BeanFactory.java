package factory;

import java.util.ResourceBundle;

import dao.ICustomerDao;
import service.ICustomerService;

/*
 * 一个工厂类
 */

public class BeanFactory {

	//只能用于读取properties文件
	//不能用于写文件
	//只能读取类路径下的文件
	 private static ResourceBundle bundle = ResourceBundle.getBundle("bean");
	
	/*
	 * 根据bean名称创建类对象
	 */
	public static Object getBean(String beanName) {
		try {
			//1.读取配置文件，跟beanName获取全限定类名
			String beanPath = bundle.getString(beanName);
			return Class.forName(beanPath).newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
//	public static ICustomerService getCustomerService() {
//		try {
//			return (ICustomerService) Class.forName("service.impl.CustomerServiceImpl").newInstance();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	public static ICustomerDao getCustomerDao() {
//		try {
//			return (ICustomerDao) Class.forName("dao.impl.CustomerDaoImpl").newInstance();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}	
//	}
	

}
