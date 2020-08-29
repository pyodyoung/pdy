<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">상품 상세 정보</h2>
[상품번호] : ${ITEM.item_id }<br/>
[상품이름] : ${ITEM.item_name }<br/>
[상품가격] : ${ITEM.price }, [원산지] : ${ITEM.origin }<br/>
[상품설명] : <br/>
<table border="1">
	<tr><td>${ITEM.info } </td></tr>
</table>
</body>
</html>