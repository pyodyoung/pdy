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
<c:choose>
	<c:when test="${sessionScope.loginUser == null }">
	정상적으로 로그아웃 되었습니다.
	</c:when>
	<c:otherwise>
	정상적으로 로그아웃되지 않았습니다.<br/>관리자에 문의해 주세요.
	</c:otherwise>
</c:choose>
</body>
</html>








