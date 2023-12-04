<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>게시물 상세보기</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .card-title {
            display: flex;
            justify-content: space-between;
        }

        .date {
            display: flex;
            justify-content: space-between;
        }

        #flex-container {
            margin: 50px 50px 50px 50px;
            justify-content: center;

        }

        #card_line {
            border-style: none;
            background-color: #f8f8f8;

        }

        #img_ {
            display: flex;
            flex-basis: auto;
            margin: 0 auto;
            width: 500px;
            height: 500px;
            object-fit: fill;
        }
    </style>

</head>
<body>
<!-- Responsive navbar-->
<jsp:include page="../navbar.jsp" flush="false"/>

<%--        카드 형 이미지 --%>
<div class="d-flex align-content-between flex-wrap" id="flex-container">
    <div class="shadow p-3 mb-5 bg-body-tertiary rounded">
        <div class="card mb-3" id="card_line">
            <c:forEach items="${ piVO }" var="posts" varStatus="loop">
                <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}" alt="main1"
                     class="card-img" id="img_">
            </c:forEach>

            <div class="card-body">
                <%-- 첫 줄 : 닉네임, 좋아요, 조회수 --%>
                <div class="card-title">
                    <h5 class="card-title">닉네임 : ${vo.memberNickname}</h5>
                    <%-- 좋아요 --%>
                    <c:choose>
                        <c:when test="${ empty vo.postLikecount }">
                            <h5 class="card-title">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-heart" viewBox="0 0 16 16">
                                    <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                                </svg>
                                &nbsp;&nbsp;    ${vo.postLikecount}
                            </h5>
                        </c:when>
                        <c:otherwise>
                            <h5 class="card-title">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-heart-fill" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
                                          d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                                </svg>
                                &nbsp;&nbsp;    ${vo.postLikecount}
                            </h5>
                        </c:otherwise>
                    </c:choose>
                    <h5 class="card-title">조회수 : ${vo.postVisitcount}</h5>
                </div>

                <h5 class="card-text">제목 : ${vo.postTitle}</h5>
                <h5 class="card-text">내용 : ${vo.postContent}</h5>
                <div class="date">
                    <h5 class="card-text"><small class="text-body-secondary">작성 날짜 : ${vo.postWriteDate}</small></h5>
                    <%-- <p class="card-text"><small class="text-body-secondary">수정 날짜 : ${vo.postUpdateDate}</small></p> --%>
                </div>
            </div>

            <div class="d-grid gap-2 d-md-flex justify-content-center">
                <button class="btn btn-primary" type="button"
                        onclick="location.href='../post/PostEdit.do?postIdx=${ vo.postIdx }';">
                    수정하기
                </button>
                <button class="btn btn-primary" type="button"
                        onclick="location.href='../gck/PostDelete.do?postIdx=${ vo.postIdx }';">
                    삭제하기
                </button>
                <button class="btn btn-primary" type="button" onclick="location.href='../board/MainView.do';">
                    목록보기
                </button>
            </div>
        </div>
        <!-- 댓글 -->
        <%@ include file="/reply/Reply.jsp" %>
        <%@ include file="/reply/ReplyWrite.jsp" %>
    </div>
</div>

<!-- Footer-->
<jsp:include page="../footer.jsp" flush="false"/>

</body>
</html>
