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
<div align="right">
<a href="../home/userentry.html">�����ϱ�</a></div>
<form:form modelAttribute="user" action="../login/loginPost.html" 
						method="post">
���̵�:<form:input path="id" size="10" placeholder="���̵�"/>
<font color="red"><form:errors path="id"/></font><br/>
�� ȣ:<form:password path="pwd" size="10"/>
<font color="red"><form:errors path="pwd"/></font><br/>
<input type="submit" value="�α���"/><input type="reset" value="���"/>
</form:form>
</body>
</html>






















