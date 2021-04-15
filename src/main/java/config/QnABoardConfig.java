package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import QnABoard.QnABoardDao;
import controller.QnAController;

@Configuration
@EnableTransactionManagement
public class QnABoardConfig {

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
	//dataSource소스의 메서드를 의존받아 QnABoardDto객체 생성
	public QnABoardDao qnaBoardDto(){
		return new QnABoardDao(dataSource());	//생성자 생성
	}
	
	//QnAController객체 생성 qnaBoardDto의존
	@Bean
	public	QnAController qnaController() {
		QnAController qnaController = new QnAController(qnaBoardDto());	//생성자 생성
		return qnaController;
	}
	
}
