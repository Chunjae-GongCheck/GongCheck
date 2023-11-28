<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <title>게시물 상세보기</title>
    <style>
div#popup{
    position: absolute;
    top: 100px;
    left: 640px;
    color: yellow;
    width: 640px; height: 640px; background-color: gray;
}
div#popup>div{
    position: relative; background-color: #FFFFFF; top: 0px;
    border: 1px solid gray; padding: 10px; color: black;
}
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script>
        $(function (){
            $('#closeBtn').click(function (){
                $('#popup').hide();
            });
        });
    </script>
</head>
<body>
<h2>팝업 메인 페이지</h2>

<div id = "popup">
    <h2 align="center">상세보기</h2>
    <div align="right">
        <form name="popFrm">
            <input type="button" value="닫기" id="closeBtn" />
        </form></div>
</div>
</body>
</html>
