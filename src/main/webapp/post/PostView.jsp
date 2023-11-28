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
    color: black;
    width: 640px;
    height: 640px;
    background-color: gray;
}
div#popup>div{
    position: relative;
    background-color: #FFFFFF;
    /* bottom: 0px;*/
    border: 1px solid gray;
    padding: 10px;
    color: black;
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
<h2>상세보기 팝업 페이지</h2>

<div id = "popup">
    <h2 align="center">상세보기</h2>
    <div align="right">
        <form name="popFrm">
            <button type="button" onclick="location.href='../member/login.do?mode=edit&idx=${ param.memberIdx }';">
                수정하기
            </button>
            <button type="button" onclick="location.href='../board/login.do?mode=delete&idx=${ param.memberIdx }';">
                삭제하기
            </button>
            <button type="button" onclick="location.href='../gck/MainView.do';">
                목록 바로가기
            </button>
            <button type="button" id="closeBtn">닫기</button>
        </form>
    </div>
</div>
</body>
</html>
