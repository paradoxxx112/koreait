package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import QnABoard.BoaredCheck;
import QnABoard.PasswordCheck;
import QnABoard.QnABoardDao;
import QnABoard.QnABoardVO;

@Controller
@RequestMapping("/QnABoard")
public class QnAController {
	
	
	private QnABoardDao qnaBoardDao;
	private QnABoardVO qnaBoardVO;
	
	
	public QnAController(QnABoardDao qnaBoardDao) {
		this.qnaBoardDao = qnaBoardDao;
	}
	
	@Autowired
	public void setQnaBoardVO(QnABoardVO qnaBoardVO) {
		this.qnaBoardVO = qnaBoardVO;
	}
	
	//게시판 메인 이동
	@RequestMapping("/mainList")
	public String allList(Model model,HttpSession session) {
		session.setAttribute("id", "cocu7712");
		List<QnABoardVO> allList = qnaBoardDao.AllList();
		model.addAttribute("allList",allList);
		return "QnABoard/mainList";
	}
	
	//비밀번호 입력 페이지 이동
	@GetMapping("/write")
	public String writeGet() {
		return "QnABoard/write";
	}
	
	//비밀번호 입력 페이지 이동
	@PostMapping("/write")
	public String writePost(BoaredCheck boaredCheck , HttpServletRequest request,HttpSession session) {
		String id = (String)session.getAttribute("id");	//세션 id 값을 가져옴
		String title = request.getParameter("title");
		String board = request.getParameter("board");
		boaredCheck.setTitle(title);
		boaredCheck.setBoard(board);
		
		//boaredCheck에 데이터 값이 null이 존재한다면 false 리턴
		boolean check = boaredCheck.check();
		
		if(check) {
			JOptionPane.showMessageDialog(null, "제목 및 내용을 입력하세요");
			return "QnABoard/mainList";
		}else if(id == null || id.equals("")) {
			return "로그인 페이지이동(미구현)";
		}else {
			//미완성
			qnaBoardDao.qnaInsert(qnaBoardVO);
			return "QnABoard/write";
		}
		
	}
	
	//비밀번호 입력 페이지 이동
	@RequestMapping("/pwCheck")
	public String pwCheck( PasswordCheck passwordCheck,Model model) {
		model.addAttribute("pwCheck", passwordCheck);
		return "QnABoard/pwCheck";
	}
	
	//게시글 작성한 페이지 이동
	@PostMapping("/answer")
	public String qna(@RequestParam(value="pw", defaultValue="false") String pw,HttpSession session, Model model) {
		
		//세션 id를 넣고 해당 db에 저장된 비밀번호 가져옴
		String dbPs = qnaBoardDao.DBpassword((String)session.getAttribute("id"));
		
		//비밀번호가 같은지 확인
		if(pw.equals(dbPs)) {
			return "QnABoard/answer";
		}else {
			model.addAttribute("pwCheck");
			return "redirect:/QnABoard/pwCheck";
		}
	}
	
	
}
