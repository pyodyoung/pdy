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
<h2 align="center">�Խñ� �� ����</h2>
[�۹�ȣ] : ${BBS_ITEM.seqno }<br/>
[������] : ${BBS_ITEM.title }<br/>
[�ۼ���] : ${BBS_ITEM.id }, [�ۼ���] : ${BBS_ITEM.register_date }<br/>
<div align="center" id="content">
<textarea rows="5" cols="30">${BBS_ITEM.content }</textarea>
</div>
</body>
</html>



















