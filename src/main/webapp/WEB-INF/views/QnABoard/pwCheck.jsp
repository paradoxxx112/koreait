<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 입력 페이지</title>
</head>
<body>
	<form:form action="answer" modelAttribute="pwCheck">
	비밀번호 입력:
	${pwCheck.ererr }
	<form:input path="pw"/>
	<input type="submit" value="전송">
	</form:form>
</body>
</html>