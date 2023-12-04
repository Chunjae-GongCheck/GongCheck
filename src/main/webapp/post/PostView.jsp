<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>게시물 상세보기</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
    .card-title{
    display: flex;
    justify-content: space-between;
    }
    .date{
    display: flex;
    justify-content: space-between;
    }
    #flex-container{
        margin: 50px 50px 50px 50px;
        justify-content: center;

    }
        #card_line{
        border-style: none;
            background-color: #f8f8f8;

        }
#img_{
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



<%--        카드 형 이미지 --%>

<div class="d-flex align-content-between flex-wrap" id="flex-container">
    <div class="shadow p-3 mb-5 bg-body-tertiary rounded">
        <div class="card mb-3" id="card_line">
            <h5 class="card-title">아이디 : ${vo.memberIdx}</h5>
            <c:forEach items="${ piVO }" var="posts" varStatus="loop">
                <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}" alt="main1" class="card-img" id="img_">
            </c:forEach>
            <div class="card-body">
                <div class="card-title">
                <h3 class="card-title">좋아요 개수 : ${vo.postLikecount}</h3>
                <h5 class="card-title">조회수 : ${vo.postVisitcount}</h5>
                </div>
                <p class="card-text">제목 : ${vo.postTitle}</p>
                <p class="card-text">내용 : ${vo.postContent}</p>
<%--                여기가 댓글 자리일듯?--%>
                <div class="date">
                <p class="card-text"><small class="text-body-secondary">작성 날짜 : ${vo.postWriteDate}</small></p>
                    <p class="card-text"><small class="text-body-secondary">수정 날짜 : ${vo.postUpdateDate}</small></p>
                </div>
            </div>
<%--            <div class="btn btn-primary"></div>--%>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-outline-success" type="button" onclick="location.href='../gck/PostEdit.do?postIdx=${ vo.postIdx }';">
                    수정하기
                </button>
                <button class="btn btn-outline-danger" type="button" onclick="location.href='../gck/PostDelete.do?postIdx=${ vo.postIdx }';">
                    삭제하기
                </button>
                <button class="btn btn-outline-dark" type="button" onclick="location.href='../gck/MainView.do';">
                    목록 바로가기
                </button>
                <button class="btn btn-outline-secondary" type="button" id="closeBtn">닫기</button>
            </div>
        </div>
        <!--지혜-->
        <%@ include file="/reply/Reply.jsp" %>
        <%@ include file="/reply/ReplyWrite.jsp" %>
</div>
</div>

</body>
</html>
