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
<!-- POST�� ������ ���̳� ���¸� �ٲٱ� ���ؼ� ����մϴ�. -->
<!-- GET�� �������� � �����͸� �����ͼ� �����شٰų� �ϴ� �뵵���� ������ ���̳� ���µ��� �ٲ��� �ʽ��ϴ�. -->
�ȳ��ϼ���? ${sessionScope.LOGIN}<br/>
<!--  HttpServletRequest�� ��� Request�� Default���̾��� ������ 
      EL������ requestScope�� ������ �ص� �ƾ���
            �ٵ� session�� �ƴϾ� ��
 ------------����--------------------------------------------------------------------------
 pageContext JSP�� page �⺻ ��ü�� �����ϴ�. 

 pageScope  pageContext �⺻ ��ü�� ����� �Ӽ��� [�Ӽ�, ��] ������ ������ Map ��ü 

 requestScope  request �⺻ ��ü�� ����� �Ӽ��� [�Ӽ�, ��] ������ ������ Map ��ü 

 sessionScope session �⺻ ��ü�� ����� �Ӽ��� [�Ӽ�, ��] ������ ������ Map ��ü 

 applicationScope  application �⺻ ��ü�� ����� �Ӽ���  [�Ӽ�, ��]  ������ ������ Map ��ü 

 param  ��û �Ķ������ [�Ķ�����̸�, ��] ������ ������ Map ��ü, Ÿ���� String (request.getParameter(�̸�)�� ����� ����)

 paramValues ��û �Ķ������[�Ķ�����̸�, ���迭]������ ������ Map ��ü, Ÿ���� String[] (request.getParameterValues(�̸�)�� ����� ����)

 header ��û ������ [����̸�, ��] ������ ������ Map ��ü (request.getHeader(�̸�)�� ����� ����)

 headerValues ��û ������[����̸�, �� �迭] ������ ������ Map ��ü (request.getHeaders(�̸�)�� ����� ����)

 cookie [��Ű �̸�, Cookie] ������ ������ Map ��ü (request.getCookies()�� ���� Cookie �迭�� ���� ������ ����) 

 initParam �ʱ�ȭ �Ķ������[�̸�, ��] ������ ������ Map ��ü (application.getInitParameter(�̸�)�� ����� ����) 
 -->
<input type="submit" value="�α׾ƿ�"/> 
<!--  �α��������� �����Ѵ�. 
	  Body�������� �α׾ƿ� �����޽����� �ٲ۴�. 
	    �� ��, 1.���ǿ� ����� ������ ���� / 2. ���� ��ü�� ��Ȱ��ȭ�Ѵ�. 
	    2���� �����Ѵ�.
	    ������ �׽� ���ᰡ �Ǿ�� �Ѵ�. ������ �����ִ� ���� ���ߵ����� �ڿ��� �Ҹ�� ���Ҿ� ���������� �ȴ�.  
-->

</form>
</body>
</html>