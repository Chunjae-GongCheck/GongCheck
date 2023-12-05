<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>게시물 상세보기</title>



    <!-- 좋아요 추가 -->




    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    <!-- ajax -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


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
                    <h5 class="card-title">
                        <div class="likes" onclick="updateLikes();">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-heart-fill" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                      d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                            </svg>
                    &nbsp;&nbsp;    ${vo.postLikecount}
                        </div>
                    </h5>
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


<script>
    function updateLikes(){
        //let postIdx = ${ requestScope.postIdx };
        let postIdx = "1";
        let memberIdx = ${ sessionScope.memberIdx };
        let url = "${pageContext.request.contextPath}/post/updatelikes.do";

        $.ajax({
            type : "POST",
            url : url,
            datatype:"text",
            data : {
                postIdx : postIdx,
                memberIdx : memberIdx
            },
            success : function(likeCheck) {
                if(likeCheck == 0){ // 좋아요 완료
                    alert("좋아요!");
                    location.reload();
                }
                else if (likeCheck == 1){   // 좋아요 취소
                    alert("좋아요를 취소하였습니다.");
                    location.reload();
                }else{  // 오류
                    alert("다시 시도해 주세요.");
                }
            },
            error : function(){
                alert("다시 시도해 주세요.");
            }
        });
    }
</script>

</body>
</html>
