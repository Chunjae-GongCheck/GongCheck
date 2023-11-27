<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/11/26
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap demo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

  <style>
    body {
      background-size: 100%;
      font-size: 0.75rem;
    }
    #loginBoxTitle {
      color:#000000;
      font-weight: bold;
      font-size: 1.9rem;
      text-transform: uppercase;
      padding: 5px;
      margin-bottom: 20px;
      background: linear-gradient(to right, #270a09, #8ca6ce);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
    }

    input[type="button"] {
      font-size: 0.75rem;
      padding: 5px 10px;
    }
    .login-box {
      margin:150px auto;
      background-color: rgba(255, 255, 255, 1);
      border-radius: 10px;
      padding:40px 30px;
      border:5px solid #0e0e0e;width:350px;
      filter: drop-shadow(0px 0px 10px rgba(0,0,0,.5));
    }

    .form-group label {
      font-size: 0.75rem;
      margin:5px 0;
    }
    #login-btn-box{
      display: flex;
      align-items: center;
      justify-content: space-between;
      margin-top:10px;
    }
  </style>

</head>
<body>
<!-- 로그인 ,회원가입 -->
<body class="">
<div id="container">
  <!-- login Box -->
  <div class="login-box">
    <div id="loginBoxTitle">GongSta Login</div>
    <div class="form-group">
      <label>회원 아이디</label>
      <input type="text" name="uid" id="uid" class="form-control" value="" style="text-transform:uppercase;ime-mode:disabled">
    </div>
    <div class="form-group">
      <label>비밀번호</label>
      <input type="password" name="upw" id="upw" class="form-control" value="" autocomplete="off">
    </div>
    <div id="login-btn-box">
      <div style=""><span> 아이디 저장</span> <input type="checkbox" id="workSite" name="worksite" style="margin-bottom: 5px"> </div>
      <div style=""><input type="button" id="btnLogin" value="로그인" class="btn btn-danger"></div>
      <div style=""><input type="button" id="btnLoginAdmin" value="관리자 로그인" class="btn btn-danger"></div>
    </div>
  </div><!-- login Box //-->
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>

</body>
</html>