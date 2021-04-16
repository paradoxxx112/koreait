package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import controller.RegisterController;
import register.RegisterDao;

@Configuration
@EnableTransactionManagement
public class RegisterConfig {

	//db 연결 셋팅
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1522:orcl");
		ds.setUsername("koreait");
		ds.setPassword("1111");
		ds.setInitialSize(10);
		ds.setMaxActive(1000);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
		
	}
	
	@Bean
	//dataSource소스의 메서드를 의존받아 RegisterDto객체 생성
	public RegisterDao registerDao(){
		return new RegisterDao(dataSource());
	}
	
	@Bean
	//RegisterController생성자 생성
	public RegisterController registerController() {
		return new RegisterController(registerDao());
	}
	
	
}
