package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.SpringConfiguration;
import dao.ICustomerDao;
import service.ICustomerService;

public class Client {

	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ICustomerService cs = (ICustomerService) ac.getBean("customerServiceImpl");
		cs.saveCustomer();
	}
}
