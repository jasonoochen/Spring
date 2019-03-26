package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

//@Component
public class JDBCConfiguration {
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
//	@Bean(name="runner)  //它是吧方法的返回值存入spring容器中。
//	该注解有一个属性， name:用于指定bean的ID。当不指定时它有默认值。默认值是方法的名称
//	public QueryRunner createQueryRunner(DataSource dataSource) {
//		return new QueryRunner(dataSource);
//	}

//	@Bean(name="dataSource")
//	public DataSource createDataSource() {
//		CombopooledDataSource ds = new COmbopooledDataSource();
//		ds.setDriverClass(driver);
//		ds.setJdbcUrl(url);
//		ds.setUser(username);
//		ds.setPassword(password);
//		return ds;
//	}
}
