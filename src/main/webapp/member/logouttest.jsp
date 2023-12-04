<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/2/23
  Time: 3:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>test 2</title>
</head>
<body>
<p>test page 2</p>
<a href="${pageContext.request.contextPath}/member/loginform.do">로그인 하러가기</a><br>
${pageContext.request.getServletPath()}
<br>
<a href="${pageContext.request.contextPath}/member/logout.do?redirecturl=${pageContext.request.getServletPath()}">로그아웃</a><br>
</body>
</html>