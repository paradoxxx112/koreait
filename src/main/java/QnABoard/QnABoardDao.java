package QnABoard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class QnABoardDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public QnABoardDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//게시판 전체 목록 가져오기(미완성 계층형으로 구현해야함 order by)
	public List<QnABoardVO> AllList(){
		String sql = "select * from qnaboard";

		List<QnABoardVO> result = jdbcTemplate.query(sql,new RowMapper<QnABoardVO>() {
			@Override
			public QnABoardVO mapRow(ResultSet rs,int rowNum) throws SQLException {
				QnABoardVO aBoardDto = new QnABoardVO(
						rs.getString("id"), 
						rs.getString("title"), 
						rs.getString("board"), 
						rs.getInt("ref"), 
						rs.getInt("step"), 
						rs.getInt("refOrder"), 
						rs.getInt("answerNum"), 
						rs.getInt("parontNum"), 
						rs.getTimestamp("r_date")
						);
						aBoardDto.setNo(rs.getInt("no"));	//no값 셋팅
				
				return aBoardDto;
			}
		});
		return result;
		
	}
	
	//아이디를 받아서 비밀번호를 가져옴
	public String DBpassword(String id){
		//join을 통해 REGISTER_USER 테이블에서 비밀번호 값 받아오기
		String sql = "SELECT u.userPassword FROM QnABoard q , REGISTER_USER u "
				+ "WHERE u.id = q.id AND q.userid = ?";
		
		String result = jdbcTemplate.queryForObject(sql,String.class,id);
				
		return result;
		
	}
	
	//게시판에 글 등록
	public void qnaInsert(QnABoardVO qnaBoardVO) {
		String sql = "insert into qnaboard values(seq_qna.nextval,?,?,?,?,?,?,?,?,?)";
		
		this.jdbcTemplate.update(sql, 
				qnaBoardVO.getId(), 
				qnaBoardVO.getTitle(),
				qnaBoardVO.getBoard(),
				qnaBoardVO.getRef(),
				qnaBoardVO.getStep(),
				qnaBoardVO.getRefOrder(),
				qnaBoardVO.getAnswerNum(),
				qnaBoardVO.getParontNum(),
				qnaBoardVO.getR_date()
				);
	}

	//게시판에 글 수정
	public void qnaUpdate(QnABoardVO dao) {
		String sql = "update QNABOARD set title=? , board=? where id=?";
		
		this.jdbcTemplate.update(sql, 
				dao.getTitle(),
				dao.getBoard(),
				dao.getId());
	}
	
	//게시판현재 ref(부모 게시글) max +1 값 가져오기 (게시판 부모글 작성시 사용)
	public int maxRef() {
		String sql = "select max(ref) from qnaboard";
		int result = jdbcTemplate.queryForObject(sql,Integer.class)+1;
		
		return result;
	}

	//게시판현재 ref(부모 게시글) max +1 값 가져오기
	public int maxRef1(int ref) {
		String sql = "select max(ref) from qnaboard ";
		int result = jdbcTemplate.queryForObject(sql,Integer.class);
		
		return result;
	}

}
