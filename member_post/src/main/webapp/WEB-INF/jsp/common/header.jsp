<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <header class="container-fluid">
            <div class="container clearfix p-2">
                <a href="${cp}index" class="float-start"><img src="${cp}images/logo.png" alt="로고" class="img-fluid" width="250px"></a>
                <h1 class="text-center fw-bold p-3">UI 구현 게시판 레이아웃</h1>
            </div>
        </header>
        <nav class="navbar bg-warning navbar-expand-sm">
            <ul class="navbar-nav container justify-content-start">
                <li class="mx-3 nav-item"><a class="nav-link text-white" href="${cp}index">메인페이지</a></li>
                <li class="mx-3 nav-item"><a class="nav-link text-white" href="${cp}mypage">마이페이지</a></li>
                <li class="mx-3 nav-item"><a class="nav-link text-white" href="${cp}post/list?category=1">공지사항</a></li>
                <li class="mx-3 nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown">게시판</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="${cp}post/list?category=2">자유게시판</a></li>
                        <li><a class="dropdown-item" href="${cp}post/list?category=3">자료실</a></li>
                        <li><a class="dropdown-item" href="${cp}gallery">갤러리</a></li>
                    </ul>
                </li>
            </ul>
        </nav>