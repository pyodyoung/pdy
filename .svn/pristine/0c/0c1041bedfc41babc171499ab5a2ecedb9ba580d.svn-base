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
<h2 align="center">상품정보 등록</h2>
<form:form modelAttribute="item" action="../item/entry.html" method="post">
상품코드 : <form:input path="item_id" maxlength="10"/>
<font color="red"><form:errors path="item_id"/></font><br/>
상품이름 : <form:input path="item_name" maxlength="10"/>
<font color="red"><form:errors path="item_name"/></font><br/>
상품가격 : <form:input path="price" maxlength="10"/>
<font color="red"><form:errors path="price"/></font><br/>
상품설명 : <br/>
<form:textarea path="info" rows="5" cols="20"></form:textarea><br/>
원산지 : <form:input path="origin" maxlength="10"/><br/>
<input type="submit" value="등 록"/><input type="reset" value="취 소"/>
</form:form>
</body>
</html>




















