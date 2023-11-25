<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap demo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
  #logo{
  width: 3rem;
  }
  #img {
  width: 3rem;
  }
.btn_ {
  border: 0px;
}
</style>
</head>

<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="../img/logo.jpg" id="logo"/>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0" id="main_menu">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Notice</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Rank
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
<%--            <li><hr class="dropdown-divider"></li>--%>
<%--            <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
          </ul>
        </li>
<%--        <li class="nav-item">--%>
<%--          <a class="nav-link" href="#">Disabled</a>--%>
<%--        </li>--%>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
        <button class="btn_" type="submit"><img src="../img/프로필1.png" id="img">
        </button>
      </form>
    </div>
  </div>
</nav>

<!-- 목록 테이블 -->
<%--<table border="1" width="90%">--%>
<%--  <tr>--%>
<%--    <th width="10%">번호</th>--%>
<%--    <th width="*">제목</th>--%>
<%--    <th width="15%">작성자</th>--%>
<%--    <th width="10%">조회수</th>--%>
<%--    <th width="15%">작성일</th>--%>
<%--    <th width="8%">첨부</th>--%>
<%--  </tr>--%>
<%--  <c:choose>--%>
<%--    <c:when test="${ empty boardLists }">  <!-- 게시물이 없을 때 -->--%>
<%--      <tr>--%>
<%--        <td colspan="6" align="center">--%>
<%--          등록된 게시물이 없습니다.--%>
<%--        </td>--%>
<%--      </tr>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>  <!-- 게시물이 있을 때 -->--%>
<%--      <c:forEach items="${ boardLists }" var="row" varStatus="loop">--%>
<%--        <c:set var="i" value="${i+1}" />  <!-- 샘플용 번호 -->--%>
<%--        <tr align="center">--%>
<%--          <!-- 번호 -->--%>
<%--          <td>--%>
<%--              ${ i }--%>
<%--          </td>--%>
<%--          <!-- 제목(링크) -->--%>
<%--          <td align="left">--%>
<%--            <a href="#">${ row.postTitle }</a>--%>
<%--          </td>--%>
<%--          <!-- 작성자 -->--%>
<%--          <td>${ row.memberIdx }</td>--%>
<%--          <!-- 조회수 -->--%>
<%--          <td>${ row.postVisitcount }</td>--%>
<%--          <!-- 작성일 -->--%>
<%--          <td>${ row.postWriteDate }</td>--%>
<%--          <!-- 첨부 파일 -->--%>
<%--          <td>--%>
<%--              <a href="#">[Down]</a>--%>
<%--          </td>--%>
<%--        </tr>--%>
<%--      </c:forEach>--%>
<%--    </c:otherwise>--%>
<%--  </c:choose>--%>
<%--</table>--%>

<%--<!-- 하단 메뉴(바로가기, 글쓰기) -->--%>
<%--<table border="1" width="90%">--%>
<%--  <tr align="center">--%>
<%--    <td>--%>
<%--      1--%>
<%--    </td>--%>
<%--    <td width="100">--%>
<%--      <button type="button" onclick="location.href='#';">글쓰기</button>--%>
<%--    </td>--%>
<%--  </tr>--%>
<%--</table>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
