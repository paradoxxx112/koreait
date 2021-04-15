package register;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegisterDto {
	
private JdbcTemplate jdbcTemplate;
	
	public RegisterDto(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//일반유저회원가입
		public void userInsert(RegisterDao dao) {
			String sql = "insert into REGISTER_USER values(?,?,?,?,?,?,?,?)";
						
			this.jdbcTemplate.update(sql, 
					dao.getUserId(), 
					dao.getUserPassword(),
					dao.getUserName(),
					dao.getUserBirth(),
					dao.getUserPhone(),
					dao.getUserEmail(),
					dao.getUserAddress(),
					dao.getUserRegdate());
		}
}
