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
<div align="right"><a href="../home/userentry.html">�����ϱ�</a></div>
<form:form action="../login/loginPost.html" modelAttribute="user" method="post"><!--  ������ ��ȣ�� �����ؾ��ϹǷ� ����Ʈ  -->
���̵�: <form:input type="text" path="id" size="12" placeholder="���̵�"/>
<font color="red"><form:errors path="id"/></font><br/>
��ȣ :   <form:input type="password" path="pwd" size="12"/>
<font color="red"><form:errors path="pwd"/></font><br/>
 <input type="submit" value="�α���"/>
 <input type="reset" value="�� ��"/>
</form:form>
</body>
</html>