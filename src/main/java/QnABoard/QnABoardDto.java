package QnABoard;

import java.sql.Timestamp;

public class QnABoardDto {
	
	private int no;				//순서
	private String id;			//유저
	private String title;		//제목
	private String board;		//본문
	private int ref;			//본문순서
	private int step;			//자식글 순서
	private int refOrder;		//자식글 
	private int AnswerNum;		//자식글 갯수
	private int ParontNum;		//부모글의 기본키
	private Timestamp r_date;	//글 작성 시간

	
	public QnABoardDto(String id, String title, String board, int ref, int step, int refOrder, int answerNum,
			int parontNum, Timestamp r_date) {
		this.id = id;
		this.title = title;
		this.board = board;
		this.ref = ref;
		this.step = step;
		this.refOrder = refOrder;
		AnswerNum = answerNum;
		ParontNum = parontNum;
		this.r_date = r_date;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getBoard() {
		return board;
	}


	public int getRef() {
		return ref;
	}


	public int getStep() {
		return step;
	}


	public int getRefOrder() {
		return refOrder;
	}


	public int getAnswerNum() {
		return AnswerNum;
	}


	public int getParontNum() {
		return ParontNum;
	}


	public Timestamp getR_date() {
		return r_date;
	}
	
	
}
