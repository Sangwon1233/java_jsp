<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<div class="wrap">
		<jsp:include page="../common/header.jsp" />
		<main class="container">
			 <h2 class="my-3">게시판</h2>
    	<table class="table table-hover text-center" style="table-layout: fixed;">
	        <thead>
		        <tr>
		            <th style="width: 6%;">글번호</th>
		            <th>제목</th>
		            <th style="width: 15%;">작성자</th>
		            <th style="width: 15%;">작성일</th>
		            <th style="width: 6%;">조회수</th>
		        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${posts}" var="p" >
		        <tr>
		            <td>${p.pno}</td>
		            <td class="text-truncate text-start "><a href="view?pno=${p.pno}" class="text-decoration-none">${p.title}</a></td>
		            <td>${p.writer }</td>
		            <td>${p.regdate}</td>
		            <td>${p.viewCount}</td>
		        </tr>
			</c:forEach>
        	</tbody>
    </table>
    <ul class="pagination justify-content-center my-5">
        <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
      </ul>
		</main>
		<jsp:include page="../common/footer.jsp" />
	</div>
	 <script>
	 

    </script>

</body>
</html>