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
<h2 align="center">�Խ��� �۾���</h2>
<br/>
<form:form modelAttribute="bbs" action="../home/write.html" method="post">
�� �� : <form:input path="title"/>
<font color="red"><form:errors path="title"/></font><br/><br/>
<form:textarea rows="5" cols="80" path="content"></form:textarea>
<font color="red"><form:errors path="content"/></font>
<br/><div align="center">
<input type="submit" value="�ۿø���"/>
<input type="reset" value="�� ��"/></div>
</form:form>
</body>
</html>

















