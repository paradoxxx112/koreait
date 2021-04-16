package QnABoard;

import java.sql.Timestamp;

public class BoaredCheck {

	private String title;
	private String board;
	private Timestamp timestamp;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	//들어온 모든 데이터가 있으면 true 없으면 false
	public Boolean check() {
		boolean check = false;
		
		//현재시간값 셋팅
		this.timestamp = new Timestamp(System.currentTimeMillis());
		
		//셋팅 값이 없으면 false
		if(this.title == null || this.title.equals("")) {
			return check = false;
		}else if(this.board == null || this.board.equals("")) {
			return check = false;
		}else if(this.timestamp == null) {
			return check = false;
		}
		
		//셋팅 값이 있으면  true
		check = true;
		
		return check; 
	}
	
	//전체 데이터를 객체로 가져옴
//	public BoaredCheck getBoaredCheck(BoaredCheck boaredCheck) {
//		
//		return BoaredCheck;
//	}
}
