<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.loginUser !=null }">
		<h3 align="center">로그인되었습니다. ${sessionScope.loginUser }님</h3>
	</c:when>
	<c:otherwise>
	<c:if test="${cartLogin=='FAIL' }">
		<a href="../cart/login.html">다시 로그인 하기</a>
	</c:if>
			<h3 align="center">로그인실패입니다.</h3>
			<h3 align="center">계정과 암호를 확인하세요.</h3>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${cartLogin == 'SUCCESS'}">
		<script type="text/javascript">
		self.close(); opener.window.location.reload();
		</script>
	</c:when>
</c:choose>
</body>
</html>