<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#content{height:100px; width:100%; border:1px solid blue;}
</style>
</head>
<body>
<h2 align="center">게시글 상세 정보</h2>
[글번호] : ${BBS_ITEM.seqno }<br/>
[글제목] : ${BBS_ITEM.title }<br/>
[작성자] : ${BBS_ITEM.id }, [작성일] : ${BBS_ITEM.register_date }<br/>
<div align="center" id="content">
<textarea rows="5" cols="30">${BBS_ITEM.content }</textarea>
</div>
</body>
</html>



















