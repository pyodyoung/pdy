<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${RESULT == 'nocart'}">
		<h3 align="center">상품을 담으려면 로그인 해야 합니다.</h3>
	</c:when>
</c:choose>
<form:form modelAttribute="user" action="../cart/login.html"
		method="post">
아이디 : <form:input path="id" size="10"/>
<font color="red"><form:errors path="id"/></font><br/>
암 호 : <form:password path="pwd" size="10"/>
<font color="red"><form:errors path="pwd"/></font><br/>
<input type="submit" value="로그인"/> 
</form:form>
</body>
</html>






















