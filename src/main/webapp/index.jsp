<%--
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="<%= request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="board/MainView.do">MainView로 이동</a><br>

<a href="${contextPath}/member/loginform.do">로그인 하러가기</a><br>
<a href="${contextPath}/member/login_bootstrap.jsp">로그인 하러가기(부트스트랩 사용)</a><br>
<a href="${contextPath}/member/signupform.do">회원가입 하러가기</a><br>
<a href="${contextPath}/member/logout.do?redirecturl=${pageContext.request.getServletPath()}">로그아웃</a><br>
<a href="${contextPath}/logouttest.jsp">로그아웃 테스트 페이지 1</a><br>
<a href="${contextPath}/member/logouttest.jsp">로그아웃 테스트 페이지 2</a><br>
<a href="${contextPath}/member/edit.do">회원정보 수정 하러가기</a><br>
</body>
</html>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    response.sendRedirect(request.getContextPath()  +"/board/MainView.do");
%>