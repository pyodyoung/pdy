<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="../logout/logout.html" method="get">
<!-- POST는 서버의 값이나 상태를 바꾸기 위해서 사용합니다. -->
<!-- GET은 서버에서 어떤 데이터를 가져와서 보여준다거나 하는 용도이지 서버의 값이나 상태등을 바꾸지 않습니다. -->
안녕하세여? ${sessionScope.LOGIN}<br/>
<!--  HttpServletRequest의 경우 Request가 Default값이었기 때문에 
      EL내에서 requestScope는 생략을 해도 됐었다
            근데 session은 아니야 ㅋ
 ------------참고--------------------------------------------------------------------------
 pageContext JSP의 page 기본 객체와 동일하다. 

 pageScope  pageContext 기본 객체에 저장된 속성의 [속성, 값] 매핑을 저장한 Map 객체 

 requestScope  request 기본 객체에 저장된 속성의 [속성, 값] 매핑을 저장한 Map 객체 

 sessionScope session 기본 객체에 저장된 속성의 [속성, 값] 매핑을 저장한 Map 객체 

 applicationScope  application 기본 객체에 저장된 속성의  [속성, 값]  매핑을 저장한 Map 객체 

 param  요청 파라미터의 [파라미터이름, 값] 매핑을 저장한 Map 객체, 타입은 String (request.getParameter(이름)의 결과와 동일)

 paramValues 요청 파라미터의[파라미터이름, 값배열]매핑을 저장한 Map 객체, 타입은 String[] (request.getParameterValues(이름)의 결과와 동일)

 header 요청 정보의 [헤더이름, 값] 매핑을 저장한 Map 객체 (request.getHeader(이름)의 결과와 동일)

 headerValues 요청 정보의[헤더이름, 값 배열] 매핑을 저장한 Map 객체 (request.getHeaders(이름)의 결과와 동일)

 cookie [쿠키 이름, Cookie] 매핑을 저장한 Map 객체 (request.getCookies()로 구한 Cookie 배열로 부터 매핑을 생성) 

 initParam 초기화 파라미터의[이름, 값] 매핑을 저장한 Map 객체 (application.getInitParameter(이름)의 결과와 동일) 
 -->
<input type="submit" value="로그아웃"/> 
<!--  로그인정보를 삭제한다. 
	  Body페이지를 로그아웃 성공메시지로 바꾼다. 
	    이 때, 1.세션에 저장된 정보를 삭제 / 2. 세션 자체를 비활성화한다. 
	    2번을 선택한다.
	    세션은 항시 종료가 되어야 한다. 세션이 남아있는 것은 쓰잘데없는 자원의 소모와 더불어 보안위협이 된다.  
-->

</form>
</body>
</html>