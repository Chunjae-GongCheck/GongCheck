<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    <link href="css/navbar_jy.css" rel="stylesheet">


    <body>
<%--<c:set var="posts" value="${postImageVOList}" scope="request"></c:set>--%>

    <div class="modal fade" id="imageModal" tabindex="2" aria-labelledby="imageHead" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="imageHead"></h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <%--                    드롭다운 입력 칸--%>
                            <div class="d-flex justify-content-center">

                                <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}" id="imagePath"/>

                            </div>
                        <%--                    드롭다운 end--%>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                        <button type="button" class="btn btn-dark">
                            <a class="link-light"
                               href="${pageContext.request.contextPath}/gck/MainView.do" style="text-decoration: none">
                                검색
                            </a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>