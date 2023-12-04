<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/11/29
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GongCheck: Welcome!</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    <link href="css/signup_bootstrap.css" rel="stylesheet">
    <style>
        /* 로그인 버튼 */
        .btn-primary {
            --bs-btn-color: #fff;
            --bs-btn-bg: #FFB701;
            --bs-btn-border-color: #FFB701;
            --bs-btn-hover-color: #fff;
            --bs-btn-hover-bg: #dfa001;
            --bs-btn-hover-border-color: #c68e00;
            --bs-btn-focus-shadow-rgb: 49, 132, 253;
            --bs-btn-active-color: #fff;
            --bs-btn-active-bg: #FFB701;
            --bs-btn-active-border-color: #FFB701;
            --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);
            --bs-btn-disabled-color: #fff;
            --bs-btn-disabled-bg: #FFB701;
            --bs-btn-disabled-border-color: #FFB701;
        }
    </style>
</head>
<body>
<!-- Responsive navbar-->
<jsp:include page="../navbarAfterLogin.jsp" flush="false"/>

<!-- Header-->
<header class="py-5">
    <div class="container px-lg-5">
        <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
            <div class="m-4 m-lg-5">
                <h1 class="display-5 fw-bold">회원가입을 축하합니다!</h1>
                <p class="fs-4">공첵에서 매일 게시물을 작성하며 공부 습관을 길러 봐요!</p>
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/member/loginform.do">로그인 하러 가기</a>
            </div>
        </div>
    </div>
</header>

<!-- Footer-->
<jsp:include page="../footer_jy.jsp" flush="false"/>
</body>
</html>