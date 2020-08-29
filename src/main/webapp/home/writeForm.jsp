<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">�̹��� �� �ۼ�</h3><br/>
<form:form action="../image/writen.html" method="post" modelAttribute="imageWriting"
enctype="multipart/form-data">
<form:hidden path="order_no" value="${writing.order_no + 1 }"/>
<c:if test="${ ! empty writing.group_id }">
<form:hidden path="group_id" value="${writing.group_id }"/>
</c:if>	
<c:if test="${ ! empty writing.parent_id }">
<form:hidden path="parent_id" value="${writing.parent_id }"/>
</c:if>
<table border="1">
	<tr><th>������</th><td>
		<form:input type="text" path="title" size="40" value="${title }"/>
		<form:errors path="title"/>
		</td></tr>
	<tr><th>�г���</th><td><form:input type="text" path="writer_name"
		size="20"/><form:errors path="writer_name"/></td></tr>
	<tr><th>�̸���</th><td><form:input type="text" path="email" size="20"/>
		<form:errors path="email"/></td></tr>
	<tr><th>�� ȣ</th><td><form:password path="password"
		size="20"/><form:errors path="password"/></td></tr>
	<tr><th>�̹���</th><td><input type="file" name="imagename"
		size="20"/></td></tr>
	<tr><th>�۳���</th><td><form:textarea rows="8" cols="40" path="content"/></td></tr>
	<tr><td colspan="2"><input type="submit" value="�� ��"/></td></tr>
</table>
</form:form>
</body>
</html>





















