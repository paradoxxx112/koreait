package controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import register.RegisterDao;
import register.RegisterVO;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private RegisterDao registerDao;
	
	//Dao 메서드를 사용
	public RegisterController(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}

	@RequestMapping("/register")
	public String register() {		
		return "register/register";
		
	}
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request){
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userAddress = request.getParameter("userAddress");
		Timestamp userRegdate = new Timestamp(System.currentTimeMillis());
		
		int userGrade = 0;
		
		RegisterVO vo = new RegisterVO(userId, userPassword, userName, userBirth, userPhone, userEmail, userAddress, userRegdate, userGrade);
		registerDao.userInsert(vo);
		return "register/test";
		
	}	
}
