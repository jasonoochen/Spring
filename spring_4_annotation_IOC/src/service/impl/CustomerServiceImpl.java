package service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
 * 		由此注解衍生的三个注释：
 * 		@Controller		一般用于表现的注解
 * 		@Service			一般用于业务层
 * 		@Repository		一般用于持久层
 * 		他们和@Component的作用及属性完全一样(继承)
 * 2.用于注入数据
 * 		@AutoWired
 * 			作用：自动按照类型注入.只要有唯一的类型匹配就能注入。
 * 				如果注入的bean在容器中类型不唯一时，他会把变量名称作为bean的id，在容器中查找，找到后也能注入成功。
 * 				如果容器中有多个多个实现此类型的bean,而且没有找到一致的bean的,会报错。
 * 				当我们使用注解注入时，set方法不是必须的。
 * 		@Qualifier
 * 			作用：在自动按照类型注入的基础只上，再按照bean的ID注入.
 * 				它在给类成员注入数据时，不能独立使用。但是在给方法的形参注入数据时，可以独立使用。
 * 			属性：
 * 				value:用于指定bean的id
 * 		@Resource
 * 			作用：直接按照bean的id注入。
 * 			属性：
 * 				name:用于指定bean的id。
 * 		以上三个注解都是用于注入其他bean类型的。用于注入基本类型和String类型需要使用Value
 * 		@Value:
 * 			作用：用于注入基本类型和String类型数据.他可以借助spring的el表达式读取properties文件中的配置。
 * 			属性：
 * 				value:永不指定要注入的数据
 * 3.用于改变作用范围
 * 4.和生命周期有关
 * 5.spring的新注解
 */		

@Service("customerServiceImpl")
public class CustomerServiceImpl implements ICustomerService {
	
	@Value("test")
	private String name;
	
//	@Autowired
//	@Qualifier("customerDaoImpl")
	@Resource(name = "customerDaoImpl")
	private ICustomerDao customerDao = null;

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
		customerDao.saveCustomer();
		System.out.println(name);
	}

}
