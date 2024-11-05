<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <header class="container-fluid">
            <div class="container clearfix p-2">
                <a href="index.html" class="float-start"><img src="images/logo.png" alt="로고" class="img-fluid" width="250px"></a>
                <h1 class="text-center fw-bold p-3">UI 구현 게시판 레이아웃</h1>
            </div>
        </header>
        <nav class="navbar bg-warning navbar-expand-sm">
            <ul class="navbar-nav container justify-content-start">
                <li class="mx-3 nav-item"><a class="nav-link text-white" href="index.html">메인페이지</a></li>
                <li class="mx-3 nav-item"><a class="nav-link text-white" href="mypage.html">마이페이지</a></li>
                <li class="mx-3 nav-item"><a class="nav-link text-white" href="post.html?category=1">공지사항</a></li>
                <li class="mx-3 nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown">게시판</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="post.html?category=2">자유게시판</a></li>
                        <li><a class="dropdown-item" href="post.html?category=3">자료실</a></li>
                        <li><a class="dropdown-item" href="gallery.html">갤러리</a></li>
                    </ul>
                </li>
            </ul>
        </nav>