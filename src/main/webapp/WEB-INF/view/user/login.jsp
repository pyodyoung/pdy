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

<jsp:include page="/WEB-INF/view/header/header.jsp"></jsp:include>

<form:form modelAttribute="user" action="../login/loginPost.html" method="post">
아이디:<form:input path="id" size="10" placeholder="아이디"/>
<font color="red"><form:errors path="id"/></font><br/>
암 호:<form:password path="pwd" size="10"/>
<font color="red"><form:errors path="pwd"/></font><br/>

<input type="submit" value="로그인"/><input type="reset" value="취소"/>
<div align="submit"><a href="../home/userentry.html">가입하기</a></div>
<!-- <input type="submit"><a href="../home/userentry.html">가입하기</a>-->
</form:form>
</body>
</html>