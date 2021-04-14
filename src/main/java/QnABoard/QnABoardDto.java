package QnABoard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class QnABoardDto {
	
	private JdbcTemplate jdbcTemplate;
	
	public QnABoardDto(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//게시판 전체 목록 가져오기
	public List<QnABoardDao> AllList(){
		String sql = "select * from qnaboard";

		List<QnABoardDao> result = jdbcTemplate.query(sql,new RowMapper<QnABoardDao>() {
			@Override
			public QnABoardDao mapRow(ResultSet rs,int rowNum) throws SQLException {
				QnABoardDao aBoardDto = new QnABoardDao(
						rs.getString("no"), 
						rs.getString("title"), 
						rs.getString("board"), 
						rs.getInt("ref"), 
						rs.getInt("step"), 
						rs.getInt("refOrder"), 
						rs.getInt("answerNum"), 
						rs.getInt("parontNum"), 
						rs.getTimestamp("r_date"));
				return aBoardDto;
			}
		});
		return result;
		
	}
	
	//게시판에 글 등록
	public void qnaInsert(QnABoardDao dao) {
		String sql = "insert into qnaboard values(?,?,?,?,?,?,?,?,?)";
		Timestamp time = new Timestamp(System.currentTimeMillis());	//현재 시간받기
		
		this.jdbcTemplate.update(sql, 
				dao.getId(), 
				dao.getTitle(),
				dao.getBoard(),
				dao.getRef(),
				dao.getStep(),
				dao.getRefOrder(),
				dao.getAnswerNum(),
				dao.getParontNum(),time);
	}

	//게시판에 글 수정
	public void qnaUpdate(QnABoardDao dao) {
		String sql = "update QNABOARD set title=? , board=? where id=?";
		
		this.jdbcTemplate.update(sql, 
				dao.getTitle(),
				dao.getBoard(),
				dao.getId());
	}

}
