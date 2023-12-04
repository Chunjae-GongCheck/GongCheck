<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 작성하기</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            border-bottom: 0; /* 테이블 아래 테두리 제거 */
        }

        td, th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
            border-bottom: 0; /* 각 셀의 아래 테두리 제거 */
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="file"],
        textarea {
            width: calc(100% - 16px);
            padding: 10px;
            margin: 6px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        textarea {
            resize: vertical;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .reset-btn {
            background-color: #f44336;
        }

        .reset-btn:hover {
            background-color: #d32f2f;
        }

        .link-btn {
            background-color: #2196F3;
        }

        .link-btn:hover {
            background-color: #0d47a1;
        }

    </style>

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
<h1>글 작성하기</h1>
<form name="writefrm" method="post" enctype="multipart/form-data"
      action="../gck/PostWrite.do" onsubmit="return validateForm(this)">


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
                <button type="button" onclick="location.href='../gck/MainView.do';">
                    목록 바로가기
                </button>
        </div>
    </table>
</form>
</body>
</html>