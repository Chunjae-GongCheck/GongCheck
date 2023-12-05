<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GongCheck</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <link href="/css/navbar.css" rel="stylesheet"/>

    <style>
        <%-- 네비게이션 바 --%>
        * {
            margin: 0;
            padding: 0;
        }

        #writebtn {
            margin-top: 10px;
        }

        .d-flex {
            margin: 0 auto;
            margin-top: 10px;
            position: relative;
            gap: 5px;
        }

        #post_img {
            margin-top: -1vh;
            /*margin-bottom: 5px;*/
            width: 20rem;
            height: 20rem;
            object-fit: fill;
        }

        .nickName {
            background-color: #f2f2f2;
            color: black;
            font-size: 17px;
        }
        #pagingNumber{
            margin-top: 30px;
        }
    </style>
</head>

<body>
<!-- nav -->
<jsp:include page="/navbar.jsp">
    <jsp:param name="memberIdx" value="${ sessionScope.memberIdx }"/>
    <jsp:param name="memberNickname" value="${ sessionScope.memberNickname }"/>
</jsp:include>

<%-- content --%>
<div class="container">
    <%--choose when otherwise 는 java로 치면
    if else 문이랑 비슷한 반복문 성질을 가지고 있다.
    MVC2 패턴을 잘 나타내고 분리된 메서드를 이용해 동적으로 처리하기 위함.--%>
    <c:choose>
        <%-- 게시물이 없을 때 --%>
        <c:when test="${ empty boardLists }">
            <div>
                <div align="center">
                    등록된 게시물이 없습니다.
                </div>
            </div>
        </c:when>
        <%--d-flex align-content-end flex-wrap  style="max-width: 70%;"--%>

        <%-- 게시물이 있을 때 --%>
        <c:otherwise>
            <div class="d-flex align-content-between flex-wrap" id="gridsys">
                <c:forEach items="${ boardLists }" var="row" varStatus="loop">
                    <div class="thumb__post_img" id="thumb__post_img">
                        <%-- 게시물 번호 --%>
                            <%--              ${ map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index)}--%>


                        <%-- 해당 게시물 링크 --%>
                            <%--            <div class="d-flex justify-content-center"></div>--%>
                            <%--            <a type="button" class="image_Modal" data-bs-toggle="modal" data-bs-target="#imageModal"></a>--%>

                        <a href="../posts/PostView.do?postIdx=${ row.postIdx }">

                                <%-- imageList 컬렉션과 JSTL 의 앙상블 --%>
                            <c:forEach items="${ postImageVOList }" var="posts" varStatus="loop">

                                <%-- if문이 없었다면 다중 for 문에 의해 postIdx 마다 모든 게시물이 출력될 것임--%>
                                <c:if test="${row.postIdx == posts.postIdx}" var="result">

                                    <%-- 절대경로+ 서버에 저장된 이미지 불러오기 / loop를 계속 수행하는 동안 부모 foreach 문과 나의 Idx 가 일치하는지 확인하고 맞으면 출력 아니면 점프 --%>
                                    <div class="nickName" style="float: left">
<%--                                        여기에 프사 넣으면 될듯? --%>
                                        <p><strong>${posts.postIdx}</strong></p>
                                    <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}"
                                         alt="posts${loop.index}" id="post_img"/>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<%-- 하단 메뉴(바로가기)--%>
<div class="d-flex justify-content-center">
    <div class="d-flex" id="pagingNumber">
        ${ map.pagingImg }
    </div>
</div>


<%--글쓰기 버튼--%>
<div class="d-grid gap-2 d-md-flex justify-content-lg-center" id="writebtn">
    <button type="button" class="btn btn-outline-danger" onclick="location.href='../post/PostWrite.do';">글쓰기</button>
</div>

<%-- footer --%>
<jsp:include page="../footer.jsp" flush="false"/>
</body>
</html>
