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
<h2 align="center">상품 목록</h2>
<table border="1">
	<tr><td width="40">상품코드</td><td width="150">상품이름</td>
		<td width="100">상품가격</td><td width="100">원산지</td>
		<td></td></tr>
	<c:forEach items="${ITEM_LIST }" var="item">
	<tr><td>${item.item_id }</td>
		<td><a href="../item/itemDetail.html?CODE=${item.item_id }">${item.item_name }</a></td>
		<td>${item.price }</td><td>${item.origin }</td>
		<td><a href="#" 
onClick=
"window.open('../cart/addCart.html?CODE=${item.item_id}','cart','width=400,height=250').focus()">장바구니 담기</a></td></tr>
	</c:forEach>
</table>
<c:forEach var="page" begin="1" end="${PAGE_CNT }">
	<a href="../item/itemList.html?PAGENO=${page }">${page }</a>
</c:forEach>
</body>
</html>



















