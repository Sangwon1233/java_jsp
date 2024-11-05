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
		Cookie cookie =new Cookie("newjeans","hypeboy");//문자열 쌍만 저장된다
		cookie.setMaxAge(60*60*24);//long일땐ms int타입이면 
		response.addCookie(cookie);
		
	%>	

</body>
</html>
