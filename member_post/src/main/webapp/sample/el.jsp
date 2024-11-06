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
		Member member = Member.builder().id("javaman").name("자바맨").build();
		System.out.println(page==this);
		pageContext.setAttribute("member", member);//setter라 값이 2개를 줄수있음
		
		pageContext.setAttribute("number", 10);
		request.setAttribute("number", 20);
		session.setAttribute("number", 30);
		application.setAttribute("number", 40);
		
	%>
	<h2>${member}</h2>
	<h2>${member.id}</h2>
	<h2>${member.getId()}</h2>
	<h2>${member.name}</h2>
	<h2>${member.num}</h2>
	<h2>${member.email}</h2><!-- 이메일이 없는데 null이 아니라 아예 안나옴 -->
	
	<jsp:forward page="el2.jsp"/><!--el forward  --> >
	<%
		/* response.sendRedirect("el2.jsp");  */
	%>
</body>
</html>