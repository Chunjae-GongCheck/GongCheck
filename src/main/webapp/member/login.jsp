<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/11/26
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in to GongCheck</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="login-page">
  <div class="form">
    <form class="login-form" method="post" action="../member/login.do">
      <input type="text" placeholder="아이디" name="memberId"/>
      <input type="password" placeholder="비밀번호" name="passwordMember"/>
      <button>로그인</button>
      <p class="message">아직 회원이 아니신가요?  <a href="./signup.do">회원가입</a></p>
        <p>${message}</p>
    </form>
  </div>
</div>

<!-- 로그인 <-> 회원가입 변환 함수 -->
<!-- 회원가입 페이지로 이동하여 불필요 -->
<!--
<script>
  $('.message a').click(function(){
    $('form').stop().animate({height: "toggle", opacity: "toggle"}, 'slow');
  });
</script>
-->
</body>
</html>

