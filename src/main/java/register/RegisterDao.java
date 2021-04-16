package register;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegisterDao {
	
private JdbcTemplate jdbcTemplate;
	
	public RegisterDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
		//일반유저회원가입
		public void userInsert(RegisterVO dto) {
			String sql = "insert into REGISTER_USER values(register_user_seq.nextval,?,?,?,?,?,?,?,?,1)";
			this.jdbcTemplate.update(sql, 
					dto.getUserId(),		//1
					dto.getUserPassword(),	//2
					dto.getUserName(),		//3
					dto.getUserBirth(),		//4
					dto.getUserPhone(),		//5
					dto.getUserEmail(),		//6
					dto.getUserAddress(),	//7
					dto.getUserRegdate());	//8
		}
}
