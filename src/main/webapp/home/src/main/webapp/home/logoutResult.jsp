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
		<h3 align="center">���������� �α׾ƿ��Ǿ����ϴ�.</h3>
	</c:when>
	<c:otherwise>
		���������� �α׾ƿ����� �ʾҽ��ϴ�. �����ڿ� �������ּ���.
	</c:otherwise>
</c:choose>

</body>
</html>