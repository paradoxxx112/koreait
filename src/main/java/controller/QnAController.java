package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import QnABoard.QnABoardDao;
import QnABoard.QnABoardDto;

@Controller
@RequestMapping("/QnABoard")
public class QnAController {
	
	
	private QnABoardDao qnaBoardDao;
	
	
	public QnAController(QnABoardDao qnaBoardDao) {
		this.qnaBoardDao = qnaBoardDao;
	}
	
	//게시판 메인 이동
	@RequestMapping("/mainList")
	public String allList(Model model,HttpSession session) {
		session.setAttribute("id", "cocu7712");
		List<QnABoardDto> allList = qnaBoardDao.AllList();
		
		model.addAttribute("allList",allList);
		return "QnABoard/mainList";
	}
	
	//비밀번호 입력 페이지 이동
	@RequestMapping("/write")
	public String write() {
		return "QnABoard/write";
	}
	
	//비밀번호 입력 페이지 이동
	@RequestMapping("/pwCheck")
	public String pwCheck() {
		return "QnABoard/pwCheck";
	}
	
	//게시글 작성한 페이지 이동
	@RequestMapping("/answer")
	public String qna(@RequestParam(value="pw", defaultValue="false") String pw ,HttpSession session, Model model) {
		
		//세션 id값 가져옴
		String id = (String)session.getAttribute("id");
		//id를 넣고 해당 db에 저장된 비밀번호 가져옴
		String dbPs = qnaBoardDao.DBpassword(id);
		
		//비밀번호가 같은지 확인
		if(pw.equals(dbPs)) {
			return "QnABoard/answer";
		}else {
			model.addAttribute("pw", pw);
			return "redirect:/QnABoard/pwCheck";
		}
	}
}
