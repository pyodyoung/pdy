<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.loginUser !=null }">
		<h3 align="center">�α��εǾ����ϴ�. ${sessionScope.loginUser }��</h3>
	</c:when>
	<c:otherwise>
	<c:if test="${cartLogin=='FAIL' }">
		<a href="../cart/login.html">�ٽ� �α��� �ϱ�</a>
	</c:if>
			<h3 align="center">�α��ν����Դϴ�.</h3>
			<h3 align="center">������ ��ȣ�� Ȯ���ϼ���.</h3>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${cartLogin == 'SUCCESS'}">
		<script type="text/javascript">
		self.close(); opener.window.location.reload();
		</script>
	</c:when>
</c:choose>
</body>
</html>