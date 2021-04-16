<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>회원가입</title>

</head>

<body>
	<div align="center">
		<hr width = 500 size=2 color="blue">
		<h2>회원 가입</h2>
		<hr width = 500 size=2 color="blue">
	<form action="test" method="post">
		아이디 :<input type="text" name="userId" size="40"><br />		
		비밀번호 :<input type="password" name="userPassword" size="20"><br/>	
		이름 : <input type="text" name="userName" size="20"><br />
		생일 : <input type="text" name="userBirth" size="20"><br />	
		전화번호 : <input type="text" name="userPhone" size="20"><br />
		이메일 : <input type="text" name="userEmail" size="40"><br />
		주소 : <input type="text" name="userAddress" size="100"><br />
		<input type="submit" value="회원가입">&nbsp;&nbsp;<input type="reset" value="취소">	

	</form>

	</div>

</body>

</html>