<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>GongCheck</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
<%-- 네비게이션 바 --%>
*{
  margin: 0;
  padding: 0;
}
  #logo{
  width: 3rem;
  }
  #img {
  width: 3rem;
  border-radius: 100%;
  }
.btn_ {
  border: 0px;
}
#writebtn{
  float: right;
  margin: 1rem;
}
</style>
  <script>

  </script>
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
            <li><a class="dropdown-item" href="#">주간 조회수 Top 10</a></li>
            <li><a class="dropdown-item" href="#">주간 좋아요 Top 10</a></li>
<%--            <li><hr class="dropdown-divider"></li>--%>
<%--            <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
          </ul>
        </li>
<%--        <li class="nav-item">--%>
<%--          <a class="nav-link" href="#">Disabled</a>--%>
<%--        </li>--%>
      </ul>
      <form class="d-flex" role="search" action="${pageContext.request.contextPath}/gck/MainView.do">
<%--        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
        <table border="1" width="90%">
          <tr>
            <td align="center">
              <select name="searchField">
                <option value="post_title">제목</option>
                <option value="post_content">내용</option>
              </select>

              <input type="text" name="searchWord" value="${param.searchWord}"/>
              <input type="submit" value="검색하기"/>
            </td>
          </tr>
        </table>
        <button class="btn_" type="submit"><img src="../img/프로필1.png" id="img">
        </button>
      </form>
    </div>
  </div>
</nav>
<table border="1" width="100%">
  <tr>
    <th width="10%">번호</th>
    <th width="*">제목</th>
    <th width="15%">작성자</th>
    <th width="10%">조회수</th>
    <th width="15%">작성일</th>
    <th width="8%">첨부</th>
  </tr>

  <%--choose when otherwise 는 java로 치면
  if else 문이랑 비슷한 반복문 성질을 가지고 있다.
  MVC2 패턴을 잘 나타내고 분리된 메서드를 이용해 동적으로 처리하기 위함.--%>
  <c:choose>
    <c:when test="${ empty boardLists }">  <!-- 게시물이 없을 때 -->
      <tr>
        <td colspan="6" align="center">
          등록된 게시물이 없습니다^^*
        </td>
      </tr>
    </c:when>

    <c:otherwise>  <!-- 게시물이 있을 때 -->
      <c:set var="no" value="${ map.totalCount - ((map.pageNum - 1) * 10)}" />
      <c:forEach items="${ boardLists }" var="row" varStatus="loop">
        <tr align="center">
          <td>  <!-- 번호 -->
              ${no}
          </td>
          <td align="left">  <!-- 제목(링크) -->
            <a href="../board/post.do?idx=${ row.postIdx }" >${ row.postTitle }</a>
          </td>
          <td>${ row.memberIdx }</td>  <!-- 작성자 -->
          <td>${ row.postVisitcount }</td>  <!-- 조회수 -->
          <td>${ row.postWriteDate }</td>  <!-- 작성일 -->
<%--          <td>  <!-- 첨부 파일 -->--%>
<%--            <c:if test="${ not empty row.ofile }">--%>
<%--              <a href="../board/download.do?ofile=${ row.ofile }&sfile=${ row.sfile }&idx=${ row.postIdx }">[Down]</a>--%>
<%--            </c:if>--%>
<%--          </td>--%>
        </tr>
        <c:set var="no" value="${no - 1}" />
      </c:forEach>
    </c:otherwise>
  </c:choose>
</table>

<!-- 하단 메뉴(바로가기, 글쓰기) -->
<table border="1" width="100%">
  <tr align="center">
    <td>
      ${ map.pagingImg }
    </td>
    <td width="100"><button type="button"
                            onclick="location.href='../board/PostWrite.do';">글쓰기</button></td>
  </tr>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
