<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        function validateForm(form) {
            if (form.title.value == "") {
                alert("제목을 입력하세요.");
                form.title.focus();
                return false;
            }
            if (form.content.value == "") {
                alert("내용을 입력하세요.");
                form.content.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<h1>파일 업로드</h1>
<form name="writefrm" method="post" enctype="multipart/form-data"
      action="../gongcheck/PostWrite.do" onsubmit="return validateForm(this)"> <!--this는 이것을 적절하게 입력했는지 여부를 물어봄 -->

    <table border = "1" width="700px">
<%--        <div>--%>
<%--        <tr>--%>
<%--            <td width="10%" align="center">날짜</td>--%>
<%--            <td width="10%" align="center">${ vo.postWriteDate }</td><br/>--%>
<%--            <td width="10%" align="center">조회수</td>--%>
<%--            <td width="10%" align="center">${ vo.postVisitcount }</td>--%>
<%--        </tr>--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="postTitle">제목</label>
            <input type="text" value="${ vo.postTitle }"
                   class="form-control" id="postTitle" name="postTitle"
                   placeholder="제목을 입력하세요.">
        </div>
        <br/>
        <div class="form-group">
            <label for="postContent">내용</label>
            <textarea class="form-control" id="postContent" name="postContent" placeholder="내용을 입력하세요."
                      rows="3" style="margin-bottom : 20px">${ vo.postContent }</textarea>
        </div>
        <div class="form-group">
            <label for="postImagePath">첨부 파일</label>
            <input multiple type="file" class="form-control" id="postImagePath" name="postImagePath">
        </div> <br/><br/>
        <div class="form-group">
                <button type="submit">작성 완료</button>
                <button type="reset">RESET</button>
                <button type="button" onclick="location.href='../mvcboard/list.do';">
                    목록 바로가기
                </button>
            <br/><br/>
        </div>
    </table>
</form>
</body>
</html>