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
 * 		由此注解衍生的三个注释：
 * 		@Controller		一般用于表现的注解
 * 		@Service			一般用于业务层
 * 		@Repository		一般用于持久层
 * 		他们和@Component的作用及属性完全一样(继承)
 * 2.用于注入数据
 * 3.用于改变作用范围
 * 4.和生命周期有关
 * 5.spring的新注解
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
