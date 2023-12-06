<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/11/28
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GongCheck: 로그인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <!-- <link href="css/login_bootstrap.css" rel="stylesheet">-->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script type="text/javascript">
        // 페이지를 시작할 때 기본적으로 실행되는 함수(기본 실행 함수)
        $(function() {
            fnInit();
        });

        // 기존 쿠키 유무 확인
        function fnInit(){
            // 저장된 아이디가 있는지 쿠키를 확인한다.
            let cookieid = getCookie("saveid");
            console.log(cookieid);
            if(cookieid != ""){
                // 아이디 기억하기 버튼에 체크 표시
                $("input:checkbox[id='remember-me']").prop("checked", true);
                // 아이디 폼에 쿠키에 저장된 아이디 값을 넣어준다.
                $('#memberId').val(cookieid);
            }
        }

        // 로그인 버튼 후 호출되는 함수
        function frm_check(){
            saveid();
        }

        // 아이디 기억하기 버튼의 체크 유무에 따라 쿠키 생성
        function saveid() {
            // 현재 시간, 날짜를 가진 객체 생성
            let expdate = new Date();
            // 아이디 기억하기 버튼이 체크되어 있다면
            if ($("#remember-me").is(":checked")) {
                expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 7);  // 7일 보관
                setCookie("saveid", $("#memberId").val(), expdate);
            } else { // 버튼이 체크되어 있지 않다면
                expdate.setTime(expdate.getTime() - 1000 * 3600 * 24 * 7); // 현재 시간 - 7일. 즉, 과거
                setCookie("saveid", $("#memberId").val(), expdate);
            }
        }

        // 쿠키 값 입력
        function setCookie(key, value, expiredays) {
            let todayDate = new Date();
            todayDate.setTime(todayDate.getTime() + 0);
            if(todayDate > expiredays){ // 쿠키 유효시간을 지난 경우, 유효 시간을 현재보다 과거로 설정하여 쿠키가 삭제된다.
                document.cookie = key + "=" + escape(value) + "; path=/; expires=" + expiredays + ";";
            }else if(todayDate < expiredays){
                todayDate.setDate(todayDate.getDate() + expiredays);
                document.cookie = key + "=" + escape(value) + "; path=/; expires=" + todayDate.toUTCString() + ";";
            }

            console.log(document.cookie);
        }

        // 쿠키 값 가져오기
        function getCookie(key) {
            let search = key + "=";
            console.log("search : " + search);

            if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면
                offset = document.cookie.indexOf(search);
                console.log("offset : " + offset);
                if (offset != -1) { // 쿠키가 존재하면
                    offset += search.length;
                    // set index of beginning of value
                    end = document.cookie.indexOf(";", offset);
                    console.log("end : " + end);
                    // 쿠키 값의 마지막 위치 인덱스 번호 설정
                    if (end == -1)
                        end = document.cookie.length;
                    console.log("end위치  : " + end);

                    return unescape(document.cookie.substring(offset, end));
                }
            }
            return "";
        }
    </script>
</head>
<body>
<!-- Responsive navbar-->
<%--<jsp:include page="../navbar.jsp" flush="false"/>--%>

    <div class="container">
        <div class="input-form-backgroud row">
            <div class="input-form col-md-12 mx-auto">
                <form action="${pageContext.request.contextPath}/member/login.do" method="post" name="" class="validation-form" onsubmit="return frm_check();">
                    <p>${message != null ? message : ""}</p>

                    <h4 class="mb-3">로그인</h4>

                    <!-- 아이디 -->
                    <div class="mb-3">
                        <label for="memberId">아이디</label>
                        <input type="text" class="form-control" id="memberId" name="memberId" required
                               minlength="5" maxlength="30" onInput="inputDataCheck(this.id)" onKeyUp="maxLengthCheck(this.id)">
                        <div class="invalid-feedback">
                            아이디를 다시 입력해 주세요.(5자 이상 30자 이하)
                        </div>
                    </div>


                    <!-- 비밀번호 -->
                    <div class="mb-3">
                        <label for="passwordMember">비밀번호</label>
                        <input type="password" class="form-control" id="passwordMember" name="passwordMember" required
                               minlength="5" maxlength="128" onInput="maxLengthCheck(this.id);" onKeyUp="inputDataCheck(this.id);">
                        <div class="invalid-feedback">
                            비밀번호를 다시 입력해 주세요. (5자 이상 128자 이하)
                        </div>
                    </div>


                    <div class="d-grid col-6 mx-auto">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">가입하기</button>
                    </div>

                    <figure class="text-center">
                        <blockquote class="blockquote">
                            <h6>아직 회원이 아니신가요?  <a href="${pageContext.request.contextPath}/member/signupform.do">회원가입</a></h6>
                        </blockquote>
                    </figure>
                </form>
            </div>
        </div>
    </div>


<!-- Footer-->
<%--<jsp:include page="../footer.jsp" flush="false"/>--%>

<script>
    // 아이디, 비밀번호 빈칸 유효성 검사
    window.addEventListener('load', () => {
        const forms = document.getElementsByClassName('validation-form');

        Array.prototype.filter.call(forms, (form) => {
            form.addEventListener('submit', function (event) {
                // input 태그에 required가 있는데 빈칸이라면 false
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }

                form.classList.add('was-validated');
            }, false);
        });
    }, false);
</script>

</body>
</html>
