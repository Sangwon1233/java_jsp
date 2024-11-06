<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/* session.invalidate();/*로그아웃 세션 끝*/ 
	%>
	<h2>${member}</h2>
	<h2>${member.id}</h2>
	<h2>${member.getId()}</h2>
	<h2>${member.name}</h2>
	<h2>${member.email}</h2><!-- 이메일이 없는데 null이 아니라 아예 안나옴 -->
	<h2>${member.num}</h2>
	<hr>
	<h2>page : ${pageScope.number}</h2>
	<h2>request : ${requestScope.number}</h2>
	<h2>session : ${sessionScope.number}</h2>
	<h2>application : ${applicationScope.number}</h2>
	<h2>cookie : ${cookie.layer.yes }</h2>
	<h2>cookie : ${cookie['remember-id'].value }</h2>
</body>
</html>