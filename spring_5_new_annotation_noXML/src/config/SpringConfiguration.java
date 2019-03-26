package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 如果不想用xml，可以把配置放在任意一个class类中
 * 在这个case下，我们新建一个class专门用来放spring configuration
 * 一个spring的配置类
 * 它的作用就相当于bean.xml
 */

@Configuration  //把当前类看成是spring的配置类
@ComponentScan({"config"})
public class SpringConfiguration {
	
//	@Bean(name="runner)  //它是吧方法的返回值存入spring容器中。
//				该注解有一个属性， name:用于指定bean的ID。当不指定时它有默认值。默认值是方法的名称
//	public QueryRunner createQueryRunner(DataSource dataSource) {
//		return new QueryRunner(dataSource);
//	}
	
//	@Bean(name="dataSource")
//	public DataSource createDataSource() {
//		CombopooledDataSource ds = new COmbopooledDataSource();
//		//TODO
//		return ds;
//	}
}
