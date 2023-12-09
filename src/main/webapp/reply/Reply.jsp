<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>댓글 작성</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <%--    <link href="css/bootstrap.css" rel="stylesheet">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script>
        // 기본 실행
        $(function(){
            // 댓글 조회
            getCommentList();
        });

        // 댓글 조회
        function getCommentList(){
            let url = "${contextPath}/gck/ReplyViews.do";
            let postIdx = $("#postIdx").val().toString();

            $.ajax({
                type:'POST',
                url : url,
                data:{
                    postIdx: postIdx
                },
                dataType: "json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                success : function(data){
                    // data
                    // data.reply[i].replyIdx : 댓글 인덱스
                    // data.reply[i].memberNickname : 댓글 작성 회원 닉네임
                    // data.reply[i].replyContent : 댓글 내용
                    // data.reply[i].replyWriteDate : 댓글 작성일시

                    // 댓글이 들어갈 html 요소
                    var html = "";
                    // 댓글 갯수
                    let cCnt = 0;

                    let oCnt = Object.keys(data).length; // json 객체 개수 확인
                    if(oCnt <= 0) {  // 댓글이 0개인 경우 경우
                        html += "<div>";
                        html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                        html += "</table></div>";
                        html += "</div>";
                    } else{          // 댓글이 1개 이상일 경우
                        // 작성된 댓글 갯수
                        cCnt = Object.keys(data.reply).length;

                        for(i = 0; i < cCnt; i++){
                            html += "<div>";
                            html += "<input type='hidden' id='postIdx_"+ data.reply[i].replyIdx +"' name='postIdx_" + data.reply[i].replyIdx + "' value='" + postIdx + "' />";
                            html += "<div><table class='table'><h6><strong>"+data.reply[i].memberIdx+"</strong></h6>";
                            html += "<tr><td>" + data.reply[i].replyContent + "</td></tr>";
                            html += "<tr><td>" + data.reply[i].replyWriteDate + "</td></tr>";
                            html += "<tr><td><button type='button' class='btn btn-primary' onclick='showUpdateForm(" + data.reply[i].replyIdx + ", \"" + data.reply[i].replyContent + "\");'>수정</button></td></tr>";
                            html += "</table></div>";
                            html += "</div>";
                            // 수정 폼(수정 버튼 클릭 시 화면 나옴)
                            html += "<div id='updateForm" + data.reply[i].replyIdx + "' style='display: none;'>";
                            html += "<textarea class='form-control' id='updateContent" + data.reply[i].replyIdx + "'>" + data.reply[i].replyContent + "</textarea>";
                            html += "<button type='button' class='btn btn-success' onclick='updateComment(" + data.reply[i].replyIdx + ");'>수정 완료</button>";
                            html += "<button type='reset'>Reset</button>";
                            html += "</div>";
                        }
                    }

                    // 해당 요소의 내용을 변경한다.
                    $("#cCnt").html(cCnt);
                    $("#commentList").html(html);
                },
                error:function(request,status,error){
                }
            });
        }

        // 댓글 등록
        function insertComment(){
            let memberIdx = "${ sessionScope.memberIdx }";  // 로그인된 회원 idx

            // 로그인 안 된 사용자가 댓글 등록 버튼을 눌렀을 때, 로그인 페이지로 이동
            if(!memberIdx || memberIdx.length <= 0){
                alert("먼저 로그인을 해주세요.");
                location.href = "${pageContext.request.contextPath}/member/loginform.do";
                return;
            }

            let postIdx = "${ vo.postIdx }";        // 게시물 idx

            // 오류 : 게시물 idx 없음
            if(!postIdx || postIdx.length <= 0){
                alert("게시물 정보를 확인할 수 없습니다.");
                location.href = "${pageContext.request.contextPath}/board/MainView.do";
                return;
            }
            let replyContent = $("#replyContent").val().toString();   // 댓글 내용

            console.log(postIdx+"    "+replyContent);

            // 유효성 검사 : 댓글 내용이 없는 경우 alert
            if(!replyContent || replyContent.length <= 0){
                alert("댓글 내용을 입력해 주세요.");
                return;
            }

            // 댓글 등록 컨트롤러 요청명
            let url = "${contextPath}/gck/ReplyWrite.do";

            $.ajax({
                type : "POST",
                url : url,
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                data : {
                    memberIdx : memberIdx,
                    postIdx : postIdx,
                    replyContent : replyContent
                },
                success : function(insertCheck) {
                    if(insertCheck == 1){ // 댓글 등록 완료
                        getCommentList();           // 댓글 다시 조회
                        $('#replyContent').val(''); // 댓글 입력 폼 초기화
                    } else{  // 오류
                        alert("다시 시도해 주세요.");
                    }
                },
                error : function(){
                    alert("다시 시도해 주세요.");
                }
            });
        }


        // 댓글 수정
        function updateComment(replyIdx) {
            let memberIdx = "${sessionScope.memberIdx}";  // 로그인된 회원 idx

            // 로그인 안 된 사용자가 댓글 수정 버튼을 눌렀을 때, 로그인 페이지로 이동
            if (!memberIdx || memberIdx.length <= 0) {
                alert("먼저 로그인을 해주세요.");
                location.href = "${pageContext.request.contextPath}/member/loginform.do";
                return;
            }

            let postIdx = $("#postIdx").val().toString();  // 게시물 idx
            let replyContent = $("#updateContent" + replyIdx).val().toString();  // 수정된 댓글 내용

            // 유효성 검사 : 댓글 내용이 없는 경우 alert
            if (!replyContent || replyContent.length <= 0) {
                alert("댓글 내용을 입력해 주세요.");
                return;
            }

            // 댓글 수정 컨트롤러 요청명
            let url = "${contextPath}/gck/ReplyEdit.do";

            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                data: {
                    memberIdx: memberIdx,
                    replyIdx: replyIdx,
                    postIdx: postIdx,
                    replyContent: replyContent
                },
                success: function (updateCheck) {
                    if (updateCheck == 1) { // 댓글 수정 완료
                        getCommentList(); // 댓글 다시 조회
                    } else { // 오류
                        alert("수정은 본인만 가능합니다");
                    }
                }
            });

            // 수정 폼 감추기
            $("#updateForm" + replyIdx).hide();
        }

        // 수정 폼 보여주기
        function showUpdateForm(replyIdx, replyContent) {
            // 현재 댓글 내용을 수정 폼 textarea에 채워줌
            $("#updateContent" + replyIdx).val(replyContent);

            // 해당 댓글의 수정 폼을 보여줍니다.
            $("#updateForm" + replyIdx).show();
        }
    </script>
</head>
<body>
<hr/>
<!-- postidx, memberidx 가져오기 -->
<div>
    <!-- postIdx -->
    <input type="hidden" id="postIdx" name="postIdx" value="${param.postIdx}" />
    <!-- memberidx -->
    <input type="hidden" name="memberIdx" value="${sessionScope.memberIdx}" />
</div>

<!-- 댓글 등록하기 -->
<div class="container">
    <form id="commentForm" name="commentForm" method="post">
        <br><br>
        <div>
            <div>
                <span><strong>댓글</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">
                    <tr>
                        <td>
                            <textarea class="form-control" placeholder="댓글을 입력하세요." id="replyContent" name="replyContent"></textarea>
                            <br>
                            <div>
                                <button type="button" class="btn btn-primary" onclick="insertComment();">등록</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" id="b_code" name="b_code" value="${result.code }" />
    </form>
</div>

<!-- 댓글 목록 -->
<div class="container" id="commentContainer">
    <form id="commentListForm" name="commentListForm" method="post">
        <div id="commentList">
        </div>

    </form>
</div>

</body>
</html>