<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">��ٱ��� ����</h3>
<c:choose>
	<c:when test="${CART_LIST == null || totalAmount == '0' }">
	��ٱ��ϰ� ������ϴ�.
	</c:when>
	<c:otherwise>
	<table border="1">
		<tr><th width="70">��ǰ�ڵ�</th><th width="250">��ǰ�̸�</th>
			<th width="80">��ǰ����</th>	<th width="50">��ǰ����</th>
			<th width="100">�ݾ�</th><th width="80">����/����</th></tr>
		<c:forEach var="item" items="${CART_LIST }">
		<form action="../cart/modify.html" method="post">
			<input type="hidden" name="CODE" value="${item.code }"/>
			<tr><td>${item.code }</td><td>${item.name }</td>
				<td><fmt:formatNumber groupingUsed="true">
					${item.price }</fmt:formatNumber></td>
				<td><input type="text" name="NUMBER" value="${item.num }"
					size="3"/></td>
				<td><fmt:formatNumber groupingUsed="true">
					${item.price * item.num }</fmt:formatNumber></td>
				<td><input type="submit" value="����" name="BTN"/>
					<input type="submit" value="����" name="BTN"/></td></tr>
		</form>
		</c:forEach>
	</table>
	</c:otherwise>
</c:choose>
<form action="" method="post">
�� �� : <fmt:formatNumber groupingUsed="true">${totalAmount }</fmt:formatNumber>
<br/><input type="submit" value="�����ϱ�"/>
<input type="reset" value="�� ��"/>
</form>
</body>
</html>














