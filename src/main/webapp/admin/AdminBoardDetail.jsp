<%--<%@ page contentType="text/html;charset=utf-8" import="java.sql.*" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>관리자 - 회원정보 상세</title>--%>
<%--    <style>--%>
<%--        table {--%>
<%--            width: 70%; /* 테이블 전체 너비 */--%>
<%--            border-collapse: collapse; /* 테두리 겹침 */--%>
<%--            margin: 20px 0; /* 위아래 여백 */--%>
<%--        }--%>
<%--        th, td {--%>
<%--            padding: 10px; /* 셀 안쪽 여백 */--%>
<%--            text-align: left; /* 텍스트 정렬 */--%>
<%--            border: 1px solid #000000; /* 셀 테두리 */--%>
<%--        }--%>
<%--        th {--%>
<%--            background-color: #f8f8f8; /* 테이블 헤더 배경색 */--%>
<%--            color: #333; /* 테이블 헤더 글자색 */--%>
<%--        }--%>
<%--        tr:nth-child(odd) {--%>
<%--            background-color: #ffff00; /* 짝수 행 배경색 */--%>
<%--        }--%>
<%--        a {--%>
<%--            color: #337ab7; /* 링크 색상 */--%>
<%--            text-decoration: none; /* 밑줄 없앰 */--%>
<%--        }--%>
<%--        a:hover {--%>
<%--            color: #23527c; /* 링크 호버 색상 */--%>
<%--        }--%>
<%--        th.number, td.number { width: 1%; } /* 번호 열 너비 */--%>
<%--        th.id, th.name, td.id, td.name { width: 25%; } /* ID와 이름 열 너비 */--%>
<%--        th.password, td.password { width: 25%; } /* 비밀번호 열 너비 */--%>
<%--        th.management, td.management { width: 5%; } /* 관리 열 너비 */--%>
<%--        button { padding: 10px 20px; }--%>
<%--    </style>--%>
<%--    <script type="text/javascript">--%>
<%--        function validation() {--%>
<%--            const passwordOrig = document.getElementById("password_orig")--%>
<%--            const passwordNew = document.getElementById("password_new")--%>

<%--            if (!passwordOrig.value) {--%>
<%--                alert("기존 Password를 입력해주세요.")--%>
<%--                return--%>
<%--            }--%>

<%--            if (!passwordNew.value) {--%>
<%--                alert("신규 Password를 입력해주세요.")--%>
<%--                return--%>
<%--            }--%>

<%--            const [form] = document.getElementsByName("form")--%>
<%--            form.submit();--%>
<%--        }--%>
<%--    </script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>관리자 - 가입회원 상세</h2>--%>
<%--<!-- 관리자 페이지의 회원 정보 상세 제목 -->--%>

<%--<form name="form" action="${pageContext.request.contextPath}/UpdateMemberServlet" method="post">--%>
<%--    <table>--%>
<%--        <!-- 회원 정보를 나열하기 위한 테이블 -->--%>
<%--        <tr>--%>
<%--            <!-- 테이블 헤더 -->--%>
<%--            <th>Number</th> <!-- 고유 번호 -->--%>
<%--            <td>--%>
<%--                ${ adminResultVo.adminIdx }--%>
<%--                <input type="hidden" name="admin_idx" value="${adminResultVo.adminIdx}" />--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>ID</th> <!-- 회원 ID -->--%>
<%--            <td>${ adminResultVo.adminId }</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>기존 Password</th> <!-- 회원 비밀번호 -->--%>
<%--            <td><input type="password" id="password_orig" name="password_orig" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>신규 Password</th> <!-- 회원 비밀번호 -->--%>
<%--            <td><input type="password" id="password_new" name="password_new"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan="2" style="text-align: center;">--%>
<%--                <button onclick="validation()">수정하기</button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
