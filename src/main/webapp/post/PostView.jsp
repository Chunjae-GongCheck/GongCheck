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
    .card_{
        margin: 5rem 30rem 25rem 30rem;

    }
#img_{

}
    </style>

</head>
<body>



<%--        카드 형 이미지 --%>
<div class="card_">
        <div class="card mb-3">
            <h5 class="card-title">아이디 : ${vo.memberIdx}</h5>
            <c:forEach items="${ piVO }" var="posts" varStatus="loop">
                <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}" alt="main1" class="card-img-top" id="img_">
            </c:forEach>
            <div class="card-body">
                <div class="card-title">
                <h3 class="card-title">좋아요 개수 : ${vo.postLikecount}</h3>
                <h5 class="card-title">조회수 : ${vo.postVisitcount}</h5>
                </div>
                <p class="card-text">내용 : ${vo.postContent}</p>
<%--                여기가 댓글 자리일듯?--%>
                <div class="date">
                <p class="card-text"><small class="text-body-secondary">작성 날짜 : ${vo.postWriteDate}</small></p>
                <p class="card-text"><small class="text-body-secondary">수정 날짜 : ${vo.postUpdateDate}</small></p>
                </div>
            </div>
        </div>
</div>
        <div class="btn btn-primary"></div>

                <div class="buttons">
                    <button type="button" onclick="location.href='../member/login.do?mode=edit&idx=${ sessionScope.memberIdx }';">
                        수정하기
                    </button>
                    <button type="button" onclick="location.href='../member/login.do?mode=delete&idx=${ sessionScope.memberIdx }';">
                        삭제하기
                    </button>
                    <button type="button" onclick="location.href='../gck/MainView.do';">
                        목록 바로가기
                    </button>
                    <button type="button" id="closeBtn">닫기</button>
                </div>

</body>
</html>
