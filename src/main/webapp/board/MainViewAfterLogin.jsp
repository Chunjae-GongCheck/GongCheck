<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>GongCheck After Login</title>
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
#writebtn {
    margin-top: 10px;


}

/*header {*/
/*  display: flex;*/
/*  justify-content: space-between;*/
/*  align-items: center;*/
/*}*/



.d-flex {
    margin: 0 auto;
    /*max-width: 100%;*/
    position: relative;
    /*width: 100%;*/
    /*gap: 0px;*/
    /*justify-content: space-around;*/
}
#post_img{
    margin-top: 2vh;
    margin-bottom: 10px;
    /*padding: 10px;*/
    width: 20rem;
    height: 20rem;
    object-fit: fill;
    /*max-width: 100%;*/

}
</style>
<%--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>--%>

</head>

<body>
<div class="header">



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
      <div  id="navright">
      <div class="d-flex justify-content-end" role="search" action="${pageContext.request.contextPath}/gck/MainView.do" id="navright_">
              <select class="form-select-sm" name="searchField">
                <option value="post_title">제목</option>
                <option value="post_content">내용</option>
              </select>

              <input type="text" name="searchWord" value="${param.searchWord}"/>
              <input type="submit" value="검색하기" class="btn btn-outline-dark" style="margin-right: 50px"/>

            <a class="btn btn-outline-danger"
               href="${pageContext.request.contextPath}/member/loginform.do"
               role="button"
               style="--bs-btn-padding-y: 0.5rem; --bs-btn-padding-x: 0rem; --bs-btn-font-size: 1rem; float: right;"
            >로그인</a>
<%--          <img src="../img/프로필1.png" id="img_" />--%>
      </div>
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
      <div class="d-flex align-content-between flex-wrap" id="gridsys" >
      <c:forEach items="${ boardLists }" var="row" varStatus="loop">
        <div class="thumb_post_img" id="thumb_post_img" > <!-- 번호 -->
<%--              ${ map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index)}--%>
            <!-- 제목(링크) -->

            <a href="../gck/PostView.do?postIdx=${ row.postIdx }">
              <%-- imageList 컬렉션과 JSTL 의 앙상블 --%>

              <c:forEach items="${ postImageVOList }" var="posts" varStatus="loop">
                <%-- if문이 없었다면 다중 for 문에 의해 postIdx 마다 모든 게시물이 출력될 것임--%>
                <c:if test="${row.postIdx == posts.postIdx}" var="result">
<%-- 절대경로+ 서버에 저장된 이미지 불러오기 / loop를 계속 수행하는 동안 부모 foreach 문과 나의 Idx 가 일치하는지 확인하고 맞으면 출력 아니면 점프 --%>

                  <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}" alt="posts${loop.index}" class="shadow p-3 mb-5 bg-body-tertiary rounded" id="post_img"/>

                </c:if>
              </c:forEach>
            </a>

        </div>
      </c:forEach>
      </div>
    </c:otherwise>
  </c:choose>
</div>

<!-- 하단 메뉴(바로가기, 글쓰기) -->

<div class="pagination justify-content-center">
      ${ map.pagingImg }
</div>
<div class="d-grid gap-2 d-md-flex justify-content-lg-center" id="writebtn">
<button type="button" class="btn btn-outline-danger" onclick="location.href='../post/PostWrite.jsp';">글쓰기</button>
</div>
<%--PostView 모달--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>


</body>
</html>
