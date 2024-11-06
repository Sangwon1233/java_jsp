<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="head.jsp" />
    <style>
    	  /* 레이어 팝업 영역 */
        .layer-popup {width: 420px; position: absolute; top: 150px; left: calc(50% - 210px);display: none;}    
        .layer-popup img {display: block;}
        .layer-popup p {background-color: rgb(127, 197, 255); color:#eee; margin: 0; padding: 8px; font-size: 13px;}
        .layer-popup p input {vertical-align: middle;}
        .layer-popup p a {color: #eee; text-decoration: none; float: right;}
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
   <body>
    <div class="wrap">
        <jsp:include page="header.jsp" />
        <main class="container">
            <div class="row">
            <div class="col-md-9">
                <div class="p-3">
                    <h1>index</h1>
                </div>
            </div>
            <div class="col-md-3">
                <div class="p-3 d-grid gap-2">
                 <c:if test="${empty member }">
                    <a href="signin" class="btn btn-primary btn-block btn-sm">로그인</a>
                        <div class="small clearfix">
                            <a href="signup" class="small float-start text-decoration-none">회원가입</a>
                            <a href="signin.html" class="small float-end text-decoration-none">아이디/비밀번호 찾기</a>
                        </div>
                   </c:if>
                   <c:if test="${not empty member }">
                        <p><a href='mypage.html' class="text-decoration-none text-dark"> <strong>${member.name}</strong>님 환영합니다</a></p>
                        <div class="small clearfix">
                                <a href="logout" class="small float-start text-decoration-none">로그아웃</a>
                            <a href="mypage.html" class="small float-end text-decoration-none">마이페이지</a>
                        </div>
                   </c:if>
                    </div>
                </div>
            </div>
        </main>
	        <div class="layer-popup">
	        <img src="https://image.yes24.com/momo/scmfiles/AdvertFiles/202410/2575682_241011091003.jpg" alt="서적">
		        <p class="clearfix">
		            <span>오늘은 그만 보기 <input type="checkbox"></span>
		            <a href="#">닫기</a>
		       </p>
		        
    </div>    
        <jsp:include page="footer.jsp" />
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


	