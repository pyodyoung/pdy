<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function formCheck(frm){
/* 	if(frm.IDCHK.value==''){
		alert("ID중복검사를 해주세요.");return false;
	}
 */	if(frm.name.value==''){
		alert("이름을 입력하세요."); return false;
	}
	if(frm.id.value==''){
		alert("ID를 입력하세요."); return false;
	}
	if(frm.pwd.value==''){
		alert("암호를 입력하세요."); return false;
	}
	if(frm.pwd.value != frm.CONFIRM.value){
		alert("암호가 일치하지 않습니다.");return false;
	}
	if(!frm.gender[0].checked && 
			!frm.gender[1].checked){
		alert("성별을 선택하세요."); return false;
	}
	if(frm.job.selectedIndex < 1){
		alert("직업을 선택하세요."); return false;
	}
	if(confirm("입력한 내용이 맞습니까?")){
		//서블릿으로 전송
	}else{
		return false;
	}
}
function idCheck(){
	//1.ID가 입력되었는지를 판단한다.
	if(document.registerFrm.id.value==''){
		alert("아이디를 입력하세요.");
		document.registerFrm.id.focus();
		return;//함수 종료
	}
	//2.팝업창을 띄운다.
	var url = "../idcheck/idcheck.html?ID="+document.registerFrm.id.value;
	window.open(url,"_blank","width=450,height=200");
}
</script>
<div align="center">
<h2 align="center">개인정보 입력</h2>
<form:form action="../entry/entry.html" modelAttribute="user" method="post" 
	onSubmit="return formCheck(this)" name="registerFrm">
<input type="hidden" name="IDCHK" />	
이름: <form:input path="name" /><br/>
아이디: <form:input path="id" />
<input type="button" value="중복 검사" onClick="idCheck()"/><br/>
암호: <form:password path="pwd" /><br/>
암호 확인: <input type="password" name="CONFIRM"/><br/>
성별: 남<form:radiobutton path="gender" value="M"/>
여<form:radiobutton path="gender" value="F"/><br/>
이메일: <form:input path="email" /><br/>
주소: <form:input path="address" /><br/>
직업: <form:select path="job">
	<form:option value="--선택하세요--"/>
	<form:option value="회사원"/><form:option value="학생"/>
	<form:option value="자영업"/><form:option value="주부"/>
	<form:option value="기타"/>
</form:select><br/><br/>
<input type="submit" value="회원가입" />
<input type="reset" value="취 소"/>
</form:form>
</div>
</body>
</html>












