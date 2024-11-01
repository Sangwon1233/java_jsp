<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>더조은</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="icon" href="images/favicon.ico" types="images/xhr">
   <!-- bootstrap  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
   <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.bundle.min.js" integrity="sha512-7Pi/otdlbbCR+LnW+F7PwFcSDJOuUJB3OxtEHbg4vSMvzvJjde4Po1v4BR9Gdc9aXNUNFVUY+SK51wWT8WF0Gg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
   <!-- jquery -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
   <!-- bxslider -->
   <script src="https://cdn.jsdelivr.net/npm/bxslider@4.2.17/dist/jquery.bxslider.min.js"></script>
   <!-- font-awesome -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
    
    </style>
</head>
<body>
    <div class="wrap">
        <header class="container-fluid">
            <div class="container clearfix p-2">
                <a href="index.html" class="float-start"><img src="images/logo.png" class="img-fluid" alt="로고" width="250px"></a>
                <h1 class="text-center fw-bold p-3">아카데미 UI 구현 게시판 레이아웃</h1>
            </div>
        </header>
        <nav class="navbar bg-warning  navbar-expand-sm">
            <ul class="navbar-nav container justify-content-start">
                <li class="mx-4 nav-item"><a class="nav-link text-white" href="index.html">메인페이지</a></li>
                <li class="mx-4 nav-item"><a class="nav-link text-white" href="mypage.html">마이페이지</a></li>
                <li class="mx-4 nav-item"><a class="nav-link text-white" href="post.html?category=1">공지사항</a></li>
                <li class="mx-4 nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown">게시판</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="post.html?category=2">자유게시판</a></li>
                        <li><a class="dropdown-item" href="post.html?category=3">자료실</a></li>
                        <li><a class="dropdown-item" href="gallery.html">갤러리</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <main class="container">
            <h1 class="text-center mt-5">회원 가입</h1>
            <form name = "frm"class="mx-auto col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-2 mt-5">
                <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id">
                <input type="password" class="form-control my-3" id="pwd" placeholder="비밀번호" name="pwd">
                <input type="text" class="form-control my-3" id="name" placeholder="이름" name="name">
                <input type="email" class="form-control my-3" id="email" placeholder="Enter email" name="email">
                <input type="text" class="form-control my-3" id="roadAddr" placeholder="도로명 주소" name="roadAddr">
                <input type="text" class="form-control my-3" id="name" placeholder="상세주소" name="email">
                <div class="input-group my-3">
                    <input type="text" class="form-control" placeholder="도로명검색">
                    <button class="btn btn-success" id="search" type="button">주소 검색</button>
                  </div>
                  <ul class="list-group search-result-wrap">
                    
                  </ul>
                  <button class="btn btn-primary">가입하기</button>
    
            </form>
        </main>
        <footer class="bg-warning text-center p-4">
            <address>서울특별시 구로구 디지털로 306 대룡포스트 2차 2층 더조은 아카데미 204호</address>
            <p>All rights reserved &copy; copyright.</p>
        </footer>
    </div>
    <script>
        $(function(){
                $("#search").click(function(){
                const keyword = $(this).prev().val();
                if(!keyword) {
                    return;
                }
                const data = {
                    keyword,
                    confmKey : 'devU01TX0FVVEgyMDI0MTAyOTEyMTYxNDExNTE5OTQ=',
                    currentPage : 1,
                    countPerPage : 100,
                    resultType : 'json'
                };
                
                $.ajax({
                    url : "https://business.juso.go.kr/addrlink/addrLinkApiJsonp.do",
                    type : 'get',
                    data,
                    dataType : 'jsonp',
                    crossDomain : true,
                    success : function(data) {
                        console.log(data.results.juso);

                        let str =''
                        for(let i in data.results.juso) {
                            str +=`<li class="list-group-item"><a href="#" class="small">
                            \${data.results.juso[i].roadAddr}</a></li>`;

                        }
                        $("ul.search-result-wrap").html(str);
                    },
                    error : function(xhr, msg) {
                        console.log(msg);

                    }
                })
	            $("ul.search-result-wrap").on("click","a",function(){
	                $("#roadAddr").val($(this).text().trim());
	                $("ul.search-result-wrap").closest("ul.search-result-wrap").empty();
	            });
	        })
        })
    </script>
</body>
</html>