<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스르를 하는 중입니다.</title>
</head>
<body>
<table>
<caption>목록</caption>
<tr>
	<td>no</td>
	<td>글쓴이</td>
	<td>제목</td>
	<td>작성 날짜</td>
	<td>조회수</td>
</tr>
<c:forEach var="item" items="${allList}" varStatus="1">
<tr>
	<td>${item.no }</td>
	<td>${item.id }</td>
	<td>${item.title }</td>
	<td>${item.r_date }</td>
	<td>${item.step }</td>
</tr>
</c:forEach>
<a href="pwCheck"><input type="button" value="이동"></a>
<a href="write"><input type="button" value="write"></a>
</table>
</body>
</html>