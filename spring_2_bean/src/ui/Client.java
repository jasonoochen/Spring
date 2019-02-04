package ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import service.ICustomerService;

public class Client {

	/*
	 * ClassPathXmlApplicationContext:它只能加载类路径下的配置文件
	 * FileSystemXmlApplicationContext:它可以加载磁盘任意位置的配置文件
	 * 
	 * Bean创建的两种规则：
	 * 	BeanFactory:
	 * 		提供的是一种延迟加载思想来创建bean对象。bean对象什么时候用什么时候创建。
	 * 	ApplicationContext:
	 * 		提供的是一种立即加载的思想来撞见bean对象。只要一解析完配置文件，就立马创建bean对象。
	 * 
	 * Bean的三种创建方式
	 * 	一：调用默认无参构造函数创建(最常用)
	 * 		默认情况下，如果类中
	 * 	二：使用静态工厂中的方法创建对象
	 * 		需要使用bean标签的factory-method属性，指定静态工厂中创建对象的方法
	 * 	三：使用实例工厂中的方法创建
	 * 
	 * Bean的作用范围
	 * 		可以通过配置的方式来调整作用范围
	 * 		配置的属性：bean标签的scope属性
	 * 		属性的取值：
	 * 			singleton: 单例(默认值)
	 * 			prototype: 多例(当我们让spring接管struts2的action创建时，action必须配置此值)
	 * 			request: 作用范围是一次请求，和当前请求的转发
	 * 			session： 作用范围是一次会话
	 * 			globalsession： 作用范围是一次全局会话
	 * 
	 * Bean的生命周期：
	 * 		涉及bean标签的两个属性：
	 * 			init-method
	 * 			destory-method
	 * 		单例：
	 * 			create:容器创建，对象就创建
	 * 			alive:只要容器在
	 * 			dead:容器销毁，对象销毁
	 * 		多例：
	 * 			create:每次使用时，创建对象
	 * 			alive:只要对象在使用中
	 * 			dead:当对象长时间不适用，并没有别的对象引用时，由java的GC回收
	 */
	
	//ClassPathXmlApplicationContext
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.获取容器
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		//2.根据bean的id获取对象
//		ICustomerService cs = (ICustomerService) ac.getBean("staticCustomerService");
//		ICustomerService cs = (ICustomerService) ac.getBean("instanceCustomerService");
		cs.saveCustomer();
		ac.close();
	}

//	//XmlBeanFactory
//	@SuppressWarnings("all")
//	public static void main(String[] args) {
//		//1.获取容器
//		Resource resource = new ClassPathResource("bean.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		//2.根据bean的id获取对象
//		ICustomerService cs = (ICustomerService) factory.getBean("customerService");
//		System.out.println(cs);
//	}
}
