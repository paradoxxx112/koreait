package register;

import java.sql.Timestamp;

public class RegisterDao {
	private String userId;			//유저아이디
	private String userPassword;	//유저비밀번호
	private String userName;		//유저이름
	private String userBirth;			//유저생일
	private String userPhone;			//유저핸드폰번호
	private String userEmail;			//유저이메일 
	private String userAddress;		//유저주소
	private Timestamp userRegdate;	//유저가입일시
	
	public RegisterDao(String userId, String userPassword, String userName, String userBirth, 
			String userPhone, String userEmail, String userAddress, Timestamp userRegdate) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userRegdate = userRegdate;
		
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public Timestamp getUserRegdate() {
		return userRegdate;
	}	

}
