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
    <title>Sign in to GongCheck</title>
    <link href="css/signin.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="login-page">
  <div class="form">
    <form class="register-form">
      <input type="text" placeholder="name"/>
      <input type="password" placeholder="password"/>
      <input type="text" placeholder="email address"/>
      <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form class="login-form">
      <input type="text" placeholder="아이디"/>
      <input type="password" placeholder="비밀번호"/>
      <button>로그인</button>
      <p class="message">아직 회원이 아니신가요?  <a href="#">회원가입</a></p>
    </form>
  </div>
</div>

<script>
  $('.message a').click(function(){
    $('form').stop().animate({height: "toggle", opacity: "toggle"}, 'slow');
  });
</script>
</body>
</html>

