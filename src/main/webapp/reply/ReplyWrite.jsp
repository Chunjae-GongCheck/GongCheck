<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>댓글 작성</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <style>
        .card {
            margin : 10px;
        }
    </style>
    <script type="text/javascript">
        function validateForm(form){
            if(form.replyContent.value == ""){
                alert("내용을 입력하세요");
                form.replyContent.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<hr/>
<!--댓글 작성 칸-->
<div class="container">
    <div class="form-group">
        <form name="ReplyWrite" method="post" encType = "multipart/form-data"
              action="${contextPath}/gck/ReplyWrite.do" onsubmit="return validateForm(this);">
            <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                <input type="hidden" name="postIdx" value="${param.postIdx}" />
                <tr>
                    <p>postIdx 값: ${param.postIdx}</p>
                    <input type="hidden" name="memberIdx" value="${memberIdx}" />
                    <p>작성자 : ${memberIdx}</p>
                    <td><input type="text" style="height:100px;" class="form-control" placeholder="내용을 입력해주세요" name="replyContent" value="${replyVO.replyContent}"></td>
                    <td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
