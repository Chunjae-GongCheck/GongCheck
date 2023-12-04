<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 작성하기</title>
    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <link href="../css/signup_bootstrap.css" rel="stylesheet">

    <script>
        // 입력이 들어오면 invalid 경고 문구를 지운다.
        let inputDataCheck = (id) => {
            if (id) {
                $("#" + id).removeClass("is-invalid");
                $("#" + id).removeClass("is-valid");
            }
        }
    </script>
</head>
<body>
<!-- nav -->
<jsp:include page="/navbar.jsp">
    <jsp:param name="memberIdx" value="${ sessionScope.memberIdx }"/>
    <jsp:param name="memberNickname" value="${ sessionScope.memberNickname }"/>
</jsp:include>

<!-- content -->
<div class="container">
    <div class="input-form-backgroud row">
        <div class="input-form col-md-12 mx-auto">
            <h4 class="mb-3">글 작성하기</h4>

            <form name="writefrm" method="post" enctype="multipart/form-data" class="writefrm" action="${pageContext.request.contextPath}/post/PostWrite.do" novalidate>
                <!-- 제목 -->
                <div class="row">
                    <div class="mb-3">
                        <label for="postTitle">제목</label>
                        <input type="text" type="text" class="form-control" id="postTitle" name="postTitle" placeholder="제목을 입력해 주세요." required
                               onInput="inputDataCheck(this.id)">
                        <div class="invalid-feedback">
                            제목을 입력해 주세요.
                        </div>
                    </div>
                </div>

                <!-- 내용 -->
                <div class="row">
                    <div class="mb-3">
                        <label for="postContent">내용</label>
                        <textarea class="form-control" id="postContent" name="postContent" rows="10" placeholder="내용을 입력해 주세요." required
                        onInput="inputDataCheck(this.id)"></textarea>
                        <div class="invalid-feedback">
                            내용을 입력해 주세요.
                        </div>
                    </div>
                </div>

                <!-- 첨부 파일 -->
                <div class="row">
                    <div class="mb-3">
                        <label for="postImagePath">사진 업로드</label>
                        <div class="input-group">
                            <input type="file" class="form-control" id="postImagePath" name="postImagePath" aria-describedby="inputGroupFileAddon04" aria-label="Upload" required>
                        </div>
                        <div class="invalid-feedback">
                            사진을 첨부해 주세요.
                        </div>
                    </div>
                </div>

                <div class="col">
                    <button type="submit" class="btn btn-primary">등록하기</button>
                    <button type="reset" class="btn btn-primary">다시 작성하기</button>
                    <button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/MainView.do';">목록보기</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- footer -->
<jsp:include page="../footer.jsp" flush="false"/>

<script>
    // required 속성이 있는데 빈칸이 입력되었을 때, invalid-feedback 출력
    window.addEventListener('load', () => {
        const forms = document.getElementsByClassName('writefrm');

        Array.prototype.filter.call(forms, (form) => {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }

                form.classList.add('was-validated');
            }, false);
        });

    }, false);
</script>

</body>
</html>