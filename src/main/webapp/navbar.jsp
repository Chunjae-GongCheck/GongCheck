<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/11/30
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<link href="css/navbar.css" rel="stylesheet">

<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <!-- 로고 -->
        <a class="navbar-brand" href="${pageContext.request.contextPath}/board/MainView.do">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
                <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
            </svg>
            GongCheck
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <!-- 검색 -->
                <li class="nav-item">
                    <a type="button" class="nav-link" data-bs-toggle="modal" data-bs-target="#searchModal">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                        </svg>
                    </a>
                    <jsp:include page="board/SearchModal.jsp" flush="false"/>
                </li>

                <!-- 공지사항 -->
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        공지사항
                    </a>
                </li>

                <!-- Home -->
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/board/MainView.do">
                        Home
                    </a>
                </li>

                <!-- 랭킹 -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        랭킹
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">주간 조회수 Top 10</a></li>
                        <li><a class="dropdown-item" href="#">주간 좋아요 Top 10</a></li>
                    </ul>
                </li>

                <c:choose>
                    <%-- 로그인 X --%>
                    <%-- 로그인, 회원가입 노출 --%>
                    <c:when test="${empty memberIdx }">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/member/loginform.do">
                                로그인
                            </a>
                        </li>
                    </c:when>

                    <%-- 로그인 O --%>
                    <%-- 회원정보 수정, 마이 페이지, 로그아웃 노출 --%>
                    <c:when test="${!empty memberIdx}">
                        <li class="nav-item dropdown">
                            <%-- navbar --%>
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="${pageContext.request.contextPath}/member/mypage.do" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    ${ memberNickname } 님
                            </a>
                            <%-- 드롭다운 --%>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/edit.do">회원정보 수정</a></li>
                                <li><a class="dropdown-item" href="#">내가 쓴 글 보기</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
                            </ul>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
