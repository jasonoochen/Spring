package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ICustomerDao;
import service.ICustomerService;

public class Client {

	/*
	 * ClassPathXmlApplicationContext:它只能加载类路径下的配置文件
	 * FileSystemXmlApplicationContext:它可以加载磁盘任意位置的配置文件
	 */
	public static void main(String[] args) {
		//1.获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.根据bean的id获取对象
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		//ICustomerDao cdao = (ICustomerDao) ac.getBean("customerDao");
		cs.saveCustomer();
	}

}
