<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<form action="" method="post">
<table>
<caption>임시 글쓰기</caption>
<tr>
	<td> ${sessionScope.id } 
	<input type="hidden" value="${sessionScope.id }" >
	</td>
</tr>
<tr>
	<td>
	<input type="text" name="title" placeholder="제목을 입력하세요" onblur='write(this)'>
	</td>
</tr>
<tr>
	<td>
	<input type="text" name="board" placeholder="내용을 입력하세요" height="4">
	</td>
</tr>
<tr>
	<td>
	<input type="file" name="file">
	</td>
</tr>
<tr>
	<td>
	<input type="button" value="작성완료">
	</td>
</tr>
</table>
</form>
</body>
<script type="text/javascript" src="QnABoard.js"></script>

</html>