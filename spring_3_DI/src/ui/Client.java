package ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import service.ICustomerService;

public class Client {
	
	//ClassPathXmlApplicationContext
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.获取容器
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		ICustomerService cs2 = (ICustomerService) ac.getBean("customerService2");
		ICustomerService cs3 = (ICustomerService) ac.getBean("customerService3");
		//2.根据bean的id获取对象
		cs.saveCustomer();
		cs2.saveCustomer();
		cs3.saveCustomer();
	}

}
