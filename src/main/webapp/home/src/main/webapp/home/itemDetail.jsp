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
<h2 align="center">��ǰ �� ����</h2>
[��ǰ��ȣ] : ${ITEM.item_id }<br/>
[��ǰ�̸�] : ${ITEM.item_name }<br/>
[��ǰ����] : ${ITEM.price }, [������] : ${ITEM.origin }<br/>
[��ǰ����] : <br/>
<table border="1">
	<tr><td>${ITEM.info } </td></tr>
</table>
</body>
</html>