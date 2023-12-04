<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ include file="../post/PostView.jsp"%>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>댓글</title>
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
<!--댓글 목록-->
<hr/>
    <form method="get">
    <c:choose>
        <c:when test="${empty list}">
    <div class="card text-bg-light mb-3" style="
    max-width: 18rem;">
        <div class="card-header">
            <p style="align-content: center">
                등록된 댓글이 없습니다.
            </p>
        </div>
    </div>
        </c:when>

        <c:otherwise>
            <c:forEach var="reply" items="${list}">
    <div class="card text-bg-light mb-3" style="max-width: 18rem;">
        <div class="card-header">
            <a href="/GongCheck_war_exploded/gck/ReplyViews.do?postIdx=${reply.postIdx}}"></a>
        <p>작성자: ${reply.memberIdx}</p>
        <p>작성일시: ${reply.replyWriteDate}</p>
        </div>
    <div class="card-body">
        <p>내용 :  ${reply.replyContent}</p>
    </div>
    </div>
        <hr/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </form>

    <!--댓글 작성 칸-->
<div class="container">
    <div class="form-group">
      <form name="ReplyWrite" method="post" encType = "multipart/form-data"
            action="/GongCheck_war_exploded/gck/ReplyWrite.do" onsubmit="return validateForm(this);">
            <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                <input type="hidden" name="postIdx" value="${postIdx}" />
                <tr>
                    <input type="hidden" name="memberIdx" value="${memberIdx}" />
                    <td><input type="text" style="height:100px;" class="form-control" placeholder="내용을 입력해주세요" name = "replyContent"></td>
                    <td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
