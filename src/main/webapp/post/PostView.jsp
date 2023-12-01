<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <title>게시물 상세보기</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .container{
            margin: 0 auto;
            width: 640px;
            height: 640px;
            border-style: solid;
        }

        .mainpost {
            margin: 0 auto;

        }

/*div#popup{*/
/*    position: absolute;*/
/*    top: 100px;*/
/*    left: 640px;*/
/*    color: black;*/
/*    width: 640px;*/
/*    height: 640px;*/
/*    !*background-color: gray;*!*/
/*}*/
/*div#popup>div{*/
/*    position: relative;*/
/*    background-color: #FFFFFF;*/
/*    !* bottom: 0px;*!*/
/*    !*border: 1px solid gray;*!*/
/*    padding: 10px;*/
/*    color: black;*/
/*}*/
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<%--    <script>--%>
<%--        $(function (){--%>
<%--            $('#closeBtn').click(function (){--%>
<%--                $('#popup').hide();--%>
<%--            });--%>
<%--        });--%>

    </script>
</head>
<body>
<h2>상세보기 팝업 페이지</h2>

<div id = "popup">
    <h2 align="center">상세보기</h2>
    <div class="container" id="mainimg">
        <div class="mainpost">
            <c:forEach items="${ piVO }" var="posts" varStatus="loop">
                <img src="${pageContext.request.contextPath}/Uploads/${posts.postTImagePath}" alt="main1" class="postimg" id="img_">
            </c:forEach>
        </div>
            <div class="visitCount" id="postVisitCount" >조회수 : ${vo.postVisitcount}</div>
                <div class="buttons">
                    <button type="button" onclick="location.href='../member/login.do?mode=edit&idx=${ sessionScope.memberIdx }';">
                        수정하기
                    </button>
                    <button type="button" onclick="location.href='../member/login.do?mode=delete&idx=${ sessionScope.memberIdx }';">
                        삭제하기
                    </button>
                    <button type="button" onclick="location.href='../gck/MainView.do';">
                        목록 바로가기
                    </button>
                    <button type="button" id="closeBtn">닫기</button>
                </div>
    </div>
</div>
</body>
</html>
