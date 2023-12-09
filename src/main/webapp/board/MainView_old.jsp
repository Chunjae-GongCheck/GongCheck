<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<!doctype html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--  <meta charset="utf-8">--%>
<%--  <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--  <title>GongCheck</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">--%>


<%--    <link href="/css/navbar.css" rel="stylesheet"/>--%>

<%--    <style>--%>
<%--&lt;%&ndash; 네비게이션 바 &ndash;%&gt;--%>
<%--*{--%>
<%--  margin: 0;--%>
<%--  padding: 0;--%>
<%--}--%>
<%--#writebtn {--%>
<%--    margin-top: 10px;--%>
<%--}--%>
<%--.d-flex {--%>
<%--    margin: 0 auto;--%>
<%--    position: relative;--%>
<%--}--%>
<%--#imagePath{--%>
<%--    margin-top: 2vh;--%>
<%--    margin-bottom: 10px;--%>
<%--    width: 20rem;--%>
<%--    height: 20rem;--%>
<%--    object-fit: fill;--%>
<%--}--%>


<%--</style>--%>


<%--</head>--%>

<%--<body>--%>
<%--&lt;%&ndash;수정된 nav&ndash;%&gt;--%>


<%--&lt;%&ndash;두번째 모달&ndash;%&gt;--%>
<%--&lt;%&ndash;클릭하면 해당 게시물의 url 자체를 불러올 것이냐&ndash;%&gt;--%>
<%--&lt;%&ndash;새로 이미지 ?? 버튼을 저기다 넣어볼까&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="d-flex justify-content-center"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a type="button" class="nav-link" data-bs-toggle="modal" data-bs-target="#imageModal">검색&ndash;%&gt;--%>
<%--&lt;%&ndash;<jsp:include page="../ImageModal.jsp" flush="false"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;메인 게시판&ndash;%&gt;--%>

<%--<div class="container">--%>
<%--    &lt;%&ndash;choose when otherwise 는 java로 치면--%>
<%--    if else 문이랑 비슷한 반복문 성질을 가지고 있다.--%>
<%--    MVC2 패턴을 잘 나타내고 분리된 메서드를 이용해 동적으로 처리하기 위함.&ndash;%&gt;--%>
<%--    <c:choose>--%>
<%--        <c:when test="${ empty boardLists }">  <!-- 게시물이 없을 때 -->--%>
<%--            <div>--%>
<%--                <div align="center">--%>
<%--                    등록된 게시물이 없습니다^^*--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:when>--%>
<%--        &lt;%&ndash;d-flex align-content-end flex-wrap  style="max-width: 70%;"&ndash;%&gt;--%>
<%--        <c:otherwise>  <!-- 게시물이 있을 때 -->--%>
<%--            <div class="d-flex align-content-between flex-wrap" id="gridsys" >--%>

<%--                <c:forEach items="${ boardLists }" var="row" varStatus="loop">--%>
<%--                    <a href="../post/PostView.do?postIdx=${ row.postIdx }">--%>
<%--                        <div class="thumb_post_img" id="thumb_post_img" >--%>
<%--                            <!-- 게시물 번호 -->--%>
<%--&lt;%&ndash;                                ${ map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index)}&ndash;%&gt;--%>

<%--                            <!-- 해당 게시물 링크 -->--%>
<%--                                &lt;%&ndash;            <div class="d-flex justify-content-center"></div>&ndash;%&gt;--%>

<%--&lt;%&ndash;                            <a href="../gck/PostView.do?postIdx=${ row.postIdx }">&ndash;%&gt;--%>
<%--                                &lt;%&ndash; imageList 컬렉션과 JSTL 의 앙상블 &ndash;%&gt;--%>
<%--                                <c:forEach items="${ postImageVOList }" var="posts" varStatus="loop">--%>

<%--                                    &lt;%&ndash; if문이 없었다면 다중 for 문에 의해 postIdx 마다 모든 게시물이 출력될 것임&ndash;%&gt;--%>
<%--                                    <c:if test="${row.postIdx == posts.postIdx}" var="result" scope="request">--%>

<%--                                        &lt;%&ndash; 절대경로+ 서버에 저장된 이미지 불러오기 / loop를 계속 수행하는 동안 부모 foreach 문과 나의 Idx 가 일치하는지 확인하고 맞으면 출력 아니면 점프 &ndash;%&gt;--%>

<%--                                        <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}"--%>
<%--                                             alt="${loop.index}"--%>
<%--                                             class="shadow p-3 mb-5 bg-body-tertiary rounded"--%>
<%--                                             id="imagePath"/>--%>

<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                        </div>--%>
<%--                    </a>--%>
<%--&lt;%&ndash;                    <jsp:include page="../ImageModal.jsp" flush="false"/>&ndash;%&gt;--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
<%--</div>--%>


<%--&lt;%&ndash; 하단 메뉴(바로가기)&ndash;%&gt;--%>

<%--    <div class="pagination justify-content-center" >--%>
<%--        <div class="d-flex">--%>
<%--          ${ map.pagingImg }--%>
<%--        </div>--%>
<%--    </div>--%>



<%--&lt;%&ndash;글쓰기 버튼&ndash;%&gt;--%>
<%--<div class="d-grid gap-2 d-md-flex justify-content-lg-center" id="writebtn">--%>
<%--<button type="button" class="btn btn-outline-danger" onclick="location.href='../post/PostWrite.jsp';">글쓰기</button>--%>
<%--</div>--%>
<%--&lt;%&ndash; footer &ndash;%&gt;--%>
<%--<jsp:include page="../footer.jsp" flush="false"/>--%>

<%--&lt;%&ndash; 검색 버튼 모달 창 스크립트 &ndash;%&gt;--%>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>--%>
<%--<script>--%>

<%--    const myModal = document.getElementById('myModal')--%>
<%--    const myInput = document.getElementById('myInput')--%>

<%--    myModal.addEventListener('shown.bs.modal', () => {--%>
<%--        myInput.focus()--%>
<%--    })--%>

<%--</script>--%>


<%--</body>--%>
<%--</html>--%>
