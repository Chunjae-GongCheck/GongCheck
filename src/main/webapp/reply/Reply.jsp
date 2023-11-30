<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>댓글</title>
</head>
<body>
<h2>댓글 목록</h2>

<c:if test="${not empty replies}">
    <ul>
        <c:forEach var="reply" items="${replies}">
        <div style="margin-left: ${reply.reply_depth_no * 20}px;">
        <p>내용 :  ${reply.reply_content}</p>
        <p>작성자: ${reply.member_idx}</p>
        <p>작성일시: ${reply.reply_write_date}</p>
        <hr/>
        </div>
        </c:forEach>
    </ul>
</c:if>
    <!-- 작성, 수정, 삭제 예정 -->
</body>
</html>
