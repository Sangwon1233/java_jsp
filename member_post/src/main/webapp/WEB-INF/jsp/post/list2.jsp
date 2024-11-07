<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:forEach begin="2" end="9" var="i" step="2"><!-- 2시작 9까지 i라는 변수 하겠음 -->
	<h1>${i}단</h1>
		<c:forEach begin="1" end="9" var="j" step="2" >
		<p>${i} * ${j}= ${i*j}</p>
		</c:forEach>
	</c:forEach> --%>
	<%-- ${posts}<!-- 이엘로 확인 (포워드 처리 확인 스코프)--> --%>
	
	<%-- <c:forEach items="${posts}" var="post"> <!-- 항상포문에 posts리스트를 넘고 post라는 이름을 줌 -->
		<h3>${post.title}</h3>
	</c:forEach> --%>
	<%-- <c:forEach items="${posts}" var="post" varStatus="stat" begin="3" end="10" step="2"><!--인덱스 비교-->
		<h3>${stat.index}//${stat.count} // ${post.title}</h3>
		<p> ${posts[stat.index] == post} </p> 
	</c:forEach> --%>
</body>
</html>