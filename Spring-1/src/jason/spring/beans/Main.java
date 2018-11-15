package jason.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		HelloWorld helloWorld = new HelloWorld();
//		helloWorld.setName("Hi");
		
		//1.创建Spring的IOC容器对象
		//ApplicationContext 代表IOC容器
		//ClassPathXmlApplicationContext:是ApplicationContext接口的实现类，该实现类从类路径下来加载配置文件。
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.从IOC容器中获取Bean实例
		//2.1利用id定位到IOC容器中的bean
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		//2.2利用类型返回IOC容器中的Bean,但要求IOC容器中必须只能有一个该类型的bean
		//HelloWorld hello = ctx.getBean(HelloWorld.class);
		
		helloWorld.hello();
	}

}
