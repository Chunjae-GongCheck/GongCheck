<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 수정하기</title>
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
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
            width: 100%;
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
        console.log("postIdx in JSP: ${postVO.postIdx}");
    </script>
</head>
<body>
<h1>글 수정하기</h1>
<form name="writefrm" method="post" enctype="multipart/form-data" action="../gck/PostEdit.do" onsubmit="return validateForm(this)">
    <input type="hidden" name="postIdx" value="${postVO.postIdx}" />
    <input type="hidden" name="postImagePath" value="${postImageVO.postImagePath}" />
    <input type="hidden" name="postTImagePath" value="${postImageVO.postTImagePath}" />

    <div class="form-group">
        <label for="postTitle">제목</label>
        <input type="text" value="${postVO.postTitle}" class="form-control" id="postTitle" name="postTitle" placeholder="제목을 입력하세요." />
    </div>

    <div class="form-group">
        <label for="postContent">내용</label>
        <textarea class="form-control" id="postContent" name="postContent" placeholder="내용을 입력하세요." rows="3" style="margin-bottom: 20px">${postVO.postContent}</textarea>
    </div>

    <div class="form-group">
        <label for="postImagePath">첨부 파일</label>
        <input multiple type="file" class="form-control" id="postImagePath" name="postImagePath" />
    </div>

    <div class="form-group">
        <button type="submit" onclick="location.href='../gck/MainView.do';">수정 완료</button>
        <button type="reset">RESET</button>
        <button type="button" onclick="location.href='../gck/MainView.do';">목록 바로가기</button>
    </div>
</form>
</body>
</html>