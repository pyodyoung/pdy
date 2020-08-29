<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">게시글 목록</h3>
<table border="1">
	<tr><th width="60">글번호</th><th width="300">글제목</th>
		<th width="80">작성자</th><th width="110">작성일</th></tr>
	<c:forEach items="${BBS_LIST}" var="bbs">
	<tr><td>${bbs.seqno }</td>
		<td><a href="../read/readDetail.html?SEQNO=${bbs.seqno }">${bbs.title }</a></td>
		<td>${bbs.id }</td><td>${bbs.register_date }</td></tr>
	</c:forEach>
</table>
<c:forEach var="page" begin="1" end="${PAGE_CNT }">
	<a href="../read/read.html?PAGENO=${page }">${page }</a>
</c:forEach>
</body>
</html>




















