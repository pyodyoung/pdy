<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.loginUser ==null }">
		<h3 align="center">정상적으로 로그아웃되었습니다.</h3>
	</c:when>
	<c:otherwise>
		정상적으로 로그아웃되지 않았습니다. 관리자에 문의해주세요.
	</c:otherwise>
</c:choose>

</body>
</html>