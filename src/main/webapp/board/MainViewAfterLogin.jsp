<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>GongCheck After Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <link href="css/navbar_jy.css" rel="stylesheet">
<%--    비로그인 화면--%>
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
<div class="header">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <!-- 로고 -->
            <a class="navbar-brand" href="#">GongCheck</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!-- 검색 -->
                <div id="navright">
                    <div class="d-flex justify-content-end" role="search" action="${pageContext.request.contextPath}/gck/MainView.do" id="navright_">
                        <select class="form-select-sm" name="searchField">
                            <option value="post_title">제목</option>
                            <option value="post_content">내용</option>
                        </select>

                        <input type="text" name="searchWord" value="${param.searchWord}"/>
                        <input type="submit" value="검색하기" class="btn btn-outline-dark" style="margin-right: 50px"/>
                    </div>
                </div>

                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <!-- Home -->
                    <li class="nav-item">
                        <a class="nav-link active"
                           aria-current="page"
                           href="${pageContext.request.contextPath}/member/loginform.do">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
                                <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
                            </svg>
                            Home
                        </a>
                    </li>

                    <!-- 공지사항 -->
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            공지사항
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

                    <!-- 로그인 -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">로그인</a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">회원정보 수정</a></li>
                            <li><a class="dropdown-item" href="#">내가 쓴 글 보기</a></li>
                            <li><hr class="dropdown-divider" /></li>
                            <li><a class="dropdown-item" href="#">로그아웃</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

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
