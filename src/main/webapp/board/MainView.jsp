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
#img_ {
  width: 3rem;
  border-radius: 100%;
}
.btn_ {
  border: 0px;
}
#post_img{
  width: 320px;
  height: 320px;
  margin-top: 10px;
  margin-bottom: 10px;
  object-fit:fill;
}

header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
#gridsys {
gap: 5px;
  justify-content: space-between;
}

.tb_bottom {
  border: 1px black;
  align-items: center;
text-align: center;
}

</style>
<%--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>--%>

</head>

<body>
<div class="header">
<h1>GongCheck</h1>
  <button class="btn_" type="submit"><a href="${pageContext.request.contextPath}/member/loginform.do">로그인</a></button>

</div>
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
      <div class="search">
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

        <button class="btn_" type="submit" >
          <img src="../img/프로필1.png" id="img_" />
        </button>
      </form>
      </div>
    </div>
  </div>
</nav>

<div class="container">
  <%--choose when otherwise 는 java로 치면
  if else 문이랑 비슷한 반복문 성질을 가지고 있다.
  MVC2 패턴을 잘 나타내고 분리된 메서드를 이용해 동적으로 처리하기 위함.--%>
  <c:choose>
    <c:when test="${ empty boardLists }">  <!-- 게시물이 없을 때 -->
      <div>
        <div align="center">
          등록된 게시물이 없습니다^^*
        </div>
      </div>
    </c:when>
<%--d-flex align-content-end flex-wrap  style="max-width: 70%;"--%>
    <c:otherwise>  <!-- 게시물이 있을 때 -->
      <div class="d-flex align-content-end flex-wrap" id="gridsys" >
      <c:forEach items="${ boardLists }" var="row" varStatus="loop">
        <div class="thumb_post_img" id="thumb_post_img"> <!-- 번호 -->
<%--              ${ map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index)}--%>
            <!-- 제목(링크) -->
            <a href="../gck/PostView.do?postIdx=${ row.postIdx }">
<%--              이미지 정보는 불러왔는데 난리부르스임--%>
              <c:forEach items="${ postImageVOList }" var="posts" varStatus="loop">

              <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}" alt="posts${loop.index}" class="rounded float-start" id="post_img"/>
                </c:forEach>
            </a>
        </div>
      </c:forEach>
      </div>
    </c:otherwise>
  </c:choose>
</div>

<!-- 하단 메뉴(바로가기, 글쓰기) -->
<div style="position: fixed;">
  <tr align="center">
    <td>
      ${ map.pagingImg }
    </td>
    <td width="100"><button type="button"
                            onclick="location.href='../post/PostWrite.jsp';">글쓰기</button></td>
  </tr>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<%--<script>--%>
<%--  var target = document.querySelectorAll('.btn_open');--%>
<%--  var btnPopClose = document.querySelectorAll('.pop_wrap .btn_close');--%>
<%--  var targetID;--%>

<%--  // 팝업 열기--%>
<%--  for(var i = 0; i < target.length; i++){--%>
<%--    target[i].addEventListener('click', function(){--%>
<%--      targetID = this.getAttribute('href');--%>
<%--      document.querySelector(targetID).style.display = 'block';--%>
<%--    });--%>
<%--  }--%>

<%--  // 팝업 닫기--%>
<%--  for(var j = 0; j < target.length; j++){--%>
<%--    btnPopClose[j].addEventListener('click', function(){--%>
<%--      this.parentNode.parentNode.style.display = 'none';--%>
<%--    });--%>
<%--  }--%>
<%--</script>--%>
</body>
</html>
