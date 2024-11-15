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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment-with-locales.min.js" integrity="sha512-4F1cxYdMiAW98oomSLaygEwmCnIP38pb4Kx70yQYqRwLVCs3DbRumfBq82T08g/4LJ/smbFGFpmeFlQgoDccgg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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
					<div class ="clearfix mt-3 mb-2">
					<label class="form-label float-start"><i class="fa-regular fa-comment-dots"></i></i> <b>댓글:</b></label>
					<button type = "button" class="btn btn-primary float-end btn-sm" id ="btnWriteReply">writer reply</button>
					</div>
					<ul class="list-group small replies">
        
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
		<script src="${cp}js/reply.js"></script>
		<script>
			moment.locale("ko");
	
			const pno = "${post.pno}";

			// replyService.write({content : 'abcd'})
			replyService.list(pno,function(data) {
				let str = "";
				for(let i in data){
					str += makeLi(data[i])
				}
				$(".replies").append(str);
				
			});
		function makeLi(reply){
            return `<li class="list-group-item"data-rno="\${reply.rno}">

                <p class="text-black fw-bold my-3 text-truncate">\${reply.content}</p>
                <div class="clearfix text-secondary">
                    <span class="float-start">\${reply.writer}</span>
                    
                    <span class="float-end small">\${moment(reply.regdate,'yyyy/MM/DD-HH:mm:ss').fromNow()}</span>
                    <a type="button" class="float-end  small text-danger mx-2">삭제</a>
                </div>
            </li>`;
        }
			$("#btnWriteReply").click(function() {
                $("#replyModal").modal("show");
            })

			
			$(function() {
                $("#btnReplyWriteSubmit").click(function() {
                    const writer = $("#replyWriter").val();
                    const content = $("#replyContent").val();
                    const reply = {pno, writer, content};
                    replyService.write(reply, function(data) {
                        $("#replyModal").modal("hide");
                        $("#replyWriter").val("");
                        $("#replyContent").val("");

                       location.reload();
                    });
                });
                $("#replyModal").modal("show")
            })
			</script>
		<jsp:include page="../common/footer.jsp" />
		</div>
	<!-- The Modal -->
    <div class="modal fade" id="replyModal">
      <div class="modal-dialog">
        <div class="modal-content">

          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">Reply</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>

          <!-- Modal body -->
          <div class="modal-body">
              <label for="replyContent" class="mb-2">content</label>
              <input type="text" class="form-control mb-3" id="replyContent">

              <label for="replyWriter" class="mb-2">writer</label>
              <input type="text" class="form-control mb-3" id="replyWriter" value="${member.id}">
          </div>

          <!-- Modal footer -->
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="btnReplyWriteSubmit">Write</button>
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
          </div>

        </div>
      </div>
    </div>


</body>
</html>