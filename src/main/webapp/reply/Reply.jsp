<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../post/PostView.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>댓글</title>
</head>
<body>
<h2>댓글 목록</h2>
    <div class="reply_list" style="border: 2px solid #000000">
    <c:choose>
        <c:when test="${empty list}"> <!--댓글 없을 때-->
            <tr>
                <td style="align-content: center">
                    등록된 댓글이 없습니다.
                </td>
            </tr>
        </c:when>

        <c:otherwise>
            <c:forEach var="reply" items="${list}">
                <p>내용 :  ${reply.replyContent}</p>
                <p>작성자: ${reply.memberIdx}</p>
                <p>작성일시: ${reply.replyWriteDate}</p>
                <hr/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </div>
</body>
</html>
