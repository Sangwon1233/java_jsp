<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--사칙 연산  -->
	<h3>${10 + 4}</h3>
	<h3>${'10'+ 4}</h3>
	<h3>${"10"+ 4}</h3>
	<h3>${"10"- 4}</h3>
	<h3>${"10"* 4}</h3>
	<h3>${"10"/ 4}</h3>
	<%-- <h3>${"10"div 4}</h3> --%>
	<h3>${"10"% 4}</h3>
	<h3>${"10"mod 4}</h3>
	<h3>${3.14+1}</h3>
	<!-- 비교 연산 -->
	<h3>${3.14>1}</h3>
	<h3>${3.14>=1}</h3>
	<h3>${3.14 gt 1}</h3>
	<h3>${3.14>=1}</h3>
	<h3>${3.14 ge 1}</h3>
	<h3>${3.14!=1}</h3>
	<h3>${3.14 eq 1}</h3>
	<!-- 논리 연산 -->
	<h3>${true and false}</h3>
	<h3>\${true and false} ::${true or false}</h3>
	<h3>${true or false}</h3>
	<h3>${not true}</h3>
	
	
	<hr>
	
	<%
		List<String> list = new ArrayList<>();
		list.add("abcd");
		String[] strings = {};
		
		pageContext.setAttribute("list", list);
		pageContext.setAttribute("array", strings);
		pageContext.setAttribute("str1", "");
		pageContext.setAttribute("str2", "abcd");
		pageContext.setAttribute("str3", null);
	%>
	<h3>${empty list}</h3>
	<h3>${empty array}</h3>
	<h3>${empty str1}</h3>
	<h3>${empty str2}</h3>
	<h3>${empty str3}</h3>
	<hr>
	<h3>${not empty list}</h3>
	<h3>${not empty array}</h3>
	<h3>${not empty str1}</h3>
	<h3>${not empty str2}</h3>
	<h3>${not empty str3}</h3>
	

	
</body>
</html>