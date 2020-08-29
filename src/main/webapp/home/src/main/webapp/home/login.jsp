<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="right"><a href="../home/userentry.html">가입하기</a></div>
<form:form action="../login/loginPost.html" modelAttribute="user" method="post"><!--  계정과 암호를 은닉해야하므로 포스트  -->
아이디: <form:input type="text" path="id" size="12" placeholder="아이디"/>
<font color="red"><form:errors path="id"/></font><br/>
암호 :   <form:input type="password" path="pwd" size="12"/>
<font color="red"><form:errors path="pwd"/></font><br/>
 <input type="submit" value="로그인"/>
 <input type="reset" value="취 소"/>
</form:form>
</body>
</html>