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
				 <h2 class="float-start">게시판 보기</h2>
			 	<a href="write" class="btn btn-primary float-end">글쓰기</a>
			 </div>
			  <div class="my-3 col-md-9 mx-auto">
                <label for="title" class="form-label mt-3"><i class="fa-solid fa-heading "></i> <b>제목:</b></label>
                <input type="text" class="form-control" id="title" placeholder="title" name="title" value="${post.title}" disabled>
                
                <label for="content" class="form-label mt-3"><i class="fa-solid fa-align-left "></i> <b>내용:</b></label>
                <textarea class="form-control" rows="20" id="content" name="content"  disabled> ${post.content}</textarea>
          
                <label for="writer" class="form-label mt-3"><i class="fa-solid fa-user-pen"></i> <b>작성자:</b></label>
                <input type="text" class="form-control" id="writer" placeholder="writer" name="writer"  value="${post.writer}"disabled>
                
                <label for="regdate" class="form-label mt-3"><i class="fa-regular fa-calendar-days"></i> <b>작성 날짜:</b></label>
                <input type="text" class="form-control" id="regdate" placeholder="regdate" name="regdate"  value="${post.regdate}" disabled>
                
                <label for="updatedate" class="form-label mt-3"><i class="fa-regular fa-calendar-plus"></i><b>업데이트 날짜:</b></label>
                <input type="text" class="form-control" id="updatedate" placeholder="updatedate" name="updatedate"  value="${post.updatedate}" disabled>                
            	
            	 <label class="form-label mt-3"><i class="fa-solid fa-file-arrow-up"></i><b> Attach:</b><br></label><br>
		 			
		              <ul class="list-group attach-result">
		              <c:if test="${empty post.attachs}">
		              <li class ="list-group-item"> 첨부파일이 없습니다.</li>
		   			  </c:if>
		              <c:forEach items = "${post.attachs}" var="a">
		                <li class="list-group-item"><a href="${cp}download?uuid=${a.uuid}&origin=${a.origin}&path=${a.path}">${a.origin}</a></li> 
                     </c:forEach>
						</ul> 
            	
                <hr>
               <div class="text-center my-5">
               		<c:if test="${post.writer == member.id}">
                    <a href="modify?pno=${post.pno}&${cri.qs2}" class="btn btn-warning">수정</a>
                    <a href="remove?pno=${post.pno}&${cri.qs2}" class="btn btn-danger" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
                    </c:if>
                    <a href="list?${cri.qs2}" class="btn btn-primary">목록</a>
               </div>
            </div>
		</main>
		<jsp:include page="../common/footer.jsp" />
	</div>
	 <script>
	 

    </script>

</body>
</html>