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
<h3 align="center">�Խñ� ���</h3>
<table border="1">
	<tr><th width="60">�۹�ȣ</th><th width="300">������</th>
		<th width="80">�ۼ���</th><th width="110">�ۼ���</th></tr>
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




















