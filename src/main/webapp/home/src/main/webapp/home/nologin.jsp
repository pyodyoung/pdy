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
	<c:when test="${RESULT == 'nomember' }">
		<h3 align="center">���� �ø��÷��� �α��� �ؾ� �մϴ�.</h3>
	</c:when>
</c:choose>
<form:form modelAttribute="user" method="post" 
	action="../login/login.html">
���̵� : <form:input path="id"/>
<font color="red"><form:errors path="id"/></font><br/>
��ȣ : <form:password path="pwd"/>
<font color="red"><form:errors path="pwd"/></font><br/>
<input type="submit" value="�α���"/><input type="reset" value="���"/>
</form:form><br/>
<div align="right"><a href="../home/userentry.html">�����ϱ�</a></div>
</body>
</html>





















