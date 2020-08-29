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
<h2 align="center">아이디 중복 확인</h2>
<form action="../idcheck/idcheck.html" method="get" name="frm">
아이디: <input type="text" name="ID" value="${ID }"/>
<input type="submit" value="중복검사"/><br/>
<c:if test="${DUP == 'YES' }">
${ID }는 이미 사용 중입니다.
<!-- 
	1.userentry.jsp에서 입력한 계정을 지운다. 
	2.중복검사 유무에 사용되는 파라미터(IDCHK)값을 지운다.
-->
	<script type="text/javascript">
	opener.document.registerFrm.id.value="";
	opener.document.registerFrm.IDCHK.value="";
	</script>
</c:if>
<c:if test="${DUP == 'NO' }">
${ID }는 사용 가능합니다.
<input type="button" value="사용" onClick="idOK()"/>
<!-- 
	1.출력된 계정을 userentry.jsp의 계정에 넣는다.
	2.중복검사 유무에 사용되는 파라미터(IDCHK)에 아무값이나 넣는다.
	3.현재 팝업창을 없앤다. 
 -->
</c:if>
<script type="text/javascript">
function idOK(){
	opener.document.registerFrm.id.value = document.frm.ID.value;
	opener.document.registerFrm.IDCHK.value = "YES";
	self.close();
}
</script>
</form>
</body>
</html>













