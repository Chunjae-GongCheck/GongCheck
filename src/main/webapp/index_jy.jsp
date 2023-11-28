<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="gck/MainView.do">MainView로 이동</a>

<a href="gck/listsample.do">List Sample</a>
<a href="member/loginform.do">로그인 하러가기</a>
<a href="member/login_bootstrap.jsp">로그인 하러가기(부트스트랩 사용)</a>
<a href="member/signupform.do">회원가입 하러가기</a>

</body>
</html>