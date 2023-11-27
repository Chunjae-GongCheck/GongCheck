<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/11/26
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up to GongCheck</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
    <div class="login-page">
        <div class="form">
            <form class="register-form" action="#">
                <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" placeholder="5자 이상 30자 이하의 영문과 숫자 조합을 입력해 주세요."/></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" placeholder="비밀번호"/></td>
                    <!-- 비밀번호 조건 출력 -->
                </tr>
                <tr>
                    <td><p>비밀번호 확인</p></td>
                    <td><input type="text" placeholder="비밀번호 확인"/></td>
                    <!-- 일치 여부 출력 -->
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>
                        <input type="text" id="email_id" class="form_w200" value="" placeholder="이메일" maxlength="25" />
                        @
                        <input type="text" id="email_domain" class="form_w200" value="" placeholder="직접 입력" maxlength="25"/>
                        <select class="select" onclick="setEmailDomain(this.value);return false;">
                            <option value="">-선택-</option>
                            <option value="gmail.com">gmail.com</option>
                            <option value="naver.com">naver.com</option>
                            <option value="daum.net">daum.net</option>
                            <option value="nate.com">nate.com</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button>가입하기</button></td>
                </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
