<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
            
                <hr>
               <div class="text-center my-5">
                    <a href="list" class="btn btn-primary">목록</a>
               </div>
            
            </div>
		</main>
		<jsp:include page="../common/footer.jsp" />
	</div>
	 <script>
	 

    </script>

</body>
</html>