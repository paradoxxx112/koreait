<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 입력 페이지</title>
</head>
<body>
	<form action="answer" method="post"">
	<input type="password" name="pw" value="${pw }">
	<input type="submit" value="비밀번호 입력">
	</form>
</body>
</html>