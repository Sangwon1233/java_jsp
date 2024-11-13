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
			 <div class="clearfix py-4">
				 <h2 class="float-start">공지사항</h2>
			 	<a href="write?${pageDto.cri.qs2}" class="btn btn-primary float-end">글쓰기</a>
			 </div>
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
		            <td class="text-truncate text-start "><a href="view?pno=${p.pno}&${pageDto.cri.qs2}" class="text-decoration-none">${p.title}
		            <c:if test="${p.attachFlag}"><i class="fa-solid fa-paperclip"></i></c:if>
		            </a></td>
		            <td>${p.writer }</td>
		            <td>${p.regdate}</td>
		            <td>${p.viewCount}</td>
		        </tr>
			</c:forEach>
        	</tbody>
    </table>
    ${pageDto}
    <ul class="pagination justify-content-center my-5">
    	<c:if test="${pageDto.doublePrev}">
        <li class="page-item"><a class="page-link" href="list?page=${pageDto.startPage-1}&${pageDto.cri.qs}"><i class="fa-solid fa-angles-left"></i></a></li>
        </c:if>
        <c:if test="${pageDto.prev}">
        <li class="page-item"><a class="page-link" href="list?page=${pageDto.cri.page-1}&${pageDto.cri.qs}"><i class="fa-solid fa-angle-left"></i></a></li>
        </c:if>
        <c:forEach begin="${pageDto.startPage}" end="${pageDto.endPage}" var="page">
                    <li class="page-item ${page == pageDto.cri.page ? 'active' : ''}"><a class="page-link" href="list?page=${page}&${pageDto.cri.qs}">${page}</a></li>

        </c:forEach>
        
        
    	<c:if test="${pageDto.next}">
        <li class="page-item"><a class="page-link" href="list?page=${pageDto.cri.page+1}&${pageDto.cri.qs}"><i class="fa-solid fa-angle-right"></i></a></li>
         </c:if>
         <c:if test="${pageDto.doubleNext}">
        <li class="page-item"><a class="page-link" href="list?page=${pageDto.endPage+1}&${pageDto.cri.qs}"><i class="fa-solid fa-angles-right"></i></a></li>
     	 </c:if>
      </ul>
		</main>
		<jsp:include page="../common/footer.jsp" />
	</div>
	 <script>
	 

    </script>

</body>
</html>