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
			<div class="clearfix py-4">
				 <h2 class="float-start">게시글 쓰기</h2>
			 </div>
			  <div class="my-3 col-md-9 mx-auto">
				  <form method="post" action="write?page=1&${cri.qs}">
				  
				  	     <label for="title" class="form-label mt-3"><i class="fa-solid fa-heading text-primary mx-2"></i><b>제목:</b></label>
		                <input type="text" class="form-control" id="title" placeholder="title" name="title">
		                
		                <label for="content" class="form-label mt-3"><i class="fa-solid fa-align-left "></i> <b>내용:</b></label>
		                <textarea class="form-control" rows="20" id="content" name="content"  placeholder="content"></textarea>
		          
		                <label for="writer" class="form-label mt-3"><i class="fa-solid fa-user-pen"></i> <b>작성자:</b></label>
		                <input type="text" class="form-control" id="writer" placeholder="writer" name="writer" value="${member.id}" readonly>
		                
		                <label class="form-label mt-3"><i class="fa-solid fa-file-arrow-up"></i><b> Attach:</b><br></label><br>
		                <label for="attach" class="form-label"><span class="btn btn-primary">파일첨부</span> </label>
		                <span class="mx-2 attach-count-txt"></span>
		                <input type="file" id="attach" name="files" class="d-none" multiple>
		                <ul class="list-group attach-result">
						</ul> 
		           
		               <div class="text-center my-5">
		               		<button class="btn btn-primary">작성</button>
		                    <a href="list?" class="btn btn-primary">목록</a>
		               </div>
		               
		               <div class="uploaded-input">
		               
		               </div>
		
	               </form>
            </div>
		</main>
		<jsp:include page="../common/footer.jsp" />
	</div>
	<script>
	$("#attach").change(function() {
		const url= '${cp}' + 'upload'
		// console.log($(this).val());
		const formData = new FormData();
		const files = this.files;
		
		if(!files){
			$(".attach-count-txt").text("");
			$(".attach-result").empty();
			return;
		}
		for(let i = 0 ; i < files.length ; i++) {
			formData.append("file", files[i]);
		}
		$.post({
			url,
			contentType:false,
			processData:false,
			data:formData
		})
		.done(function(data) {
			$(".attach-count-txt").text(data.length + "개의 파일");
			let str = '';
			let strHidden='';
			for(let i in data){
				str += `<li class="list-group-item">\${data[i].origin}</li>`;
				strHidden +=`<input type = "hidden" name="uuid" value="\${data[i].uuid}">`;
				strHidden +=`<input type = "hidden" name="origin" value="\${data[i].origin}">`;
				strHidden +=`<input type = "hidden" name="image" value="\${data[i].image}">`;
				strHidden +=`<input type = "hidden" name="path" value="\${data[i].path}">`;
			}
			
			$(".attach-result").html(str);
			$(".uploaded-input").html(strHidden);
			console.log(data);
		});
	});
	
	</script>
	
</body>
</html>