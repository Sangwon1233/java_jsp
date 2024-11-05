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
			<h1 class="text-center mt-5">로그인</h1>
			<form name="frm" method="post"
				class="mx-auto col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-2 mt-5">
				<input type="text" class="form-control my-3" id="id"
					placeholder="아이디" name="id"> <input type="password"
					class="form-control my-3" id="pw" placeholder="비밀번호" name="pw">

				<div class="form-check form-switch my-3">
                    <input class="form-check-input" type="checkbox" id="mySwitch" name="remember-id" value="yes">
                    <label class="form-check-label" for="mySwitch">아이디 기억</label>
                </div>
				<button class="btn btn-primary">로그인</button>
			</form>
		</main>
		<jsp:include page="../common/footer.jsp" />
	</div>
	 <script>
    //하룻동안 보지 않기가 체크가 안되어 있을시 할입
    if(!$.cookie("layer")){
    	$(".layer-popup").show();	
    }
    
    //레이어 팝업 내의 닫기 버튼 클릭시 이벤트
    $(".layer-popup a").click(function(){
    	event.preventDefault();
    	const checked = $(this).prev().find("input:checkbox").prop("checked");
    	console.log(checked);
    	
    	if(checked){
    		$.cookie('layer','yes',{expires:1});
    	}
    	$(".layer-popup").hide();	
    });
    
    </script>

</body>
</html>