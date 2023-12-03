<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    <link href="css/navbar_jy.css" rel="stylesheet">

    <script>

        const myModal = document.getElementById('myModal')
        const myInput = document.getElementById('myInput')

        myModal.addEventListener('shown.bs.modal', () => {
            myInput.focus()
        })

    </script>
</head>
    <body>
        <div class="modal fade" id="imageModal" tabindex="2" aria-labelledby="imageModalAria" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="imageModalAria">
                            사용자
                        </h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">
                            <%-- 해당 게시물 상세보기 start--%>
                                <div class="d-flex align-content-between flex-wrap" id="flex-container">
                                    <div class="shadow p-3 mb-5 bg-body-tertiary rounded">
                                        <div class="card mb-3" id="card_line">
                                            <h5 class="card-title">아이디 : ${row.memberIdx}</h5>
                                            <c:forEach items="${ piVO }" var="posts" varStatus="loop">
                                                <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}" alt="main1" class="card-img" id="img_">
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
                                    </div>
                                </div>
                            <%-- 해당 게시물 상세보기 end--%>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                            <button type="button" class="btn btn-dark">
                                <a class="link-light"
                                   href="${pageContext.request.contextPath}/member/loginform.do" style="text-decoration: none">
                                    로그인
                                </a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>