<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../common/head.jsp" />
</head>
<body>
    <div class="wrap">
        <jsp:include page="../common/header.jsp" />
        <main class="container">
            <h1 class="text-center mt-5">회원 가입</h1>
            <form name = "frm"class="mx-auto col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-2 mt-5" method="post">
                <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id">
                <input type="password" class="form-control my-3" id="pw" placeholder="비밀번호" name="pw">
                <input type="text" class="form-control my-3" id="name" placeholder="이름" name="name">
                <input type="email" class="form-control my-3" id="email" placeholder="이메일" name="email">
                <input type="text" class="form-control my-3" id="roadAddr" placeholder="도로명 주소" name="roadAddr">
                <input type="text" class="form-control my-3" id="detailAddr" placeholder="상세주소" name="detailAddr">
                <div class="input-group my-3">
                    <input type="text" class="form-control" placeholder="도로명검색">
                    <button class="btn btn-success" id="search" type="button">검색</button>
                  </div>
                  <ul class="list-group search-result-wrap">
                    
                  </ul>
                  <button class="btn btn-primary">가입하기</button>
            </form>
        </main>
         <jsp:include page="../common/footer.jsp" />
    </div>
    <script>
        $("#search").click(function() {
            const keyword = $(this).prev().val();
            if(!keyword) return;

            const data = { 
                keyword ,
                confmKey : 'devU01TX0FVVEgyMDI0MTExMjExNDQzMjExNTIyOTE=' ,
                currentPage : 1,
                countPerPage : 100,
                resultType : 'json'
            };
            console.log(data);

            $.ajax({
                url : "https://business.juso.go.kr/addrlink/addrLinkApiJsonp.do",
                type : 'get',
                data,
                dataType : 'jsonp',
                crossDomain : true,
                success : function(data) {
                    console.log(data.results.juso);

                    let str = '';
                    for(let i in data.results.juso) {
                        str += `<li class="list-group-item"><a href="#" class="small">\${data.results.juso[i].roadAddr}</a></li>`;
                    }
                    $("ul.search-result-wrap").html(str);
                },
                error : function(xhr, msg) {
                    console.log(msg);
                }
            })

            $("ul.search-result-wrap").on("click", "a", function() {
                $("#roadAddr").val($(this).text());
                $(this).closest("ul").empty();
            })
        });
</script>
</body>
</html>