package factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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
	
	 //定义一个容器，用于存放我们要使用的对象
	 private static Map<String, Object> beans = new HashMap<>();
	 
	 //使用静态代码，初始化map
	 static {
		 try {
			//1.读取配置文件中所有的配置，key
			 Enumeration<String> keys = bundle.getKeys();
			 //2.遍历keys
			 while(keys.hasMoreElements()) {
				 String key = keys.nextElement();
				 //4.根据key获取beanPath
				 String beanPath = bundle.getString(key);
				 //5.根据beanPath反射创建类对象
				 Object value = Class.forName(beanPath).newInstance();
				 //6.存入map
				 beans.put(key, value);
			 }
		} catch (Exception e) {
			throw new ExceptionInInitializerError("容器创建失败，程序停止运行");
		}
	 }
	/*
	 * 根据bean名称创建类对象
	 */
	public static Object getBean(String beanName) {
		//根据bean的唯一标识获取对象
		return beans.get(beanName);
//		try {
//			//1.读取配置文件，跟beanName获取全限定类名
//			String beanPath = bundle.getString(beanName);
//			return Class.forName(beanPath).newInstance();
//		}catch (Exception e) {
//			throw new RuntimeException(e);
//		}
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
