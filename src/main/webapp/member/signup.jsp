<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/11/28
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GongCheck: SignUp (Bootstrap)</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    <link href="css/signup_bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script>
        // input 길이 제한
        function maxLengthCheck(object) {
            if (object.value.length > object.maxLength) {
                // 길이 초과 시, 입력 무시
                object.value = object.value.slice(0, object.maxLength);
                // 경고 메세지 출력
                object.addClass("is-invalid");
            }else{  // 경고 메세지 삭제
                object.removeClass("is-invalid");
            }
        }

        // 입력이 들어오면 invalid 경고 문구를 지운다.
        let inputDataCheck = (id) => {
            if (id) {
                $("#" + id).removeClass("is-invalid");
            }
        }

        // id 중복 확인
        function id_overlap_check(object) {
            // 아이디
            let inputMemberId =  $("#memberId").val();

            // null 입력
            if(!inputMemberId){
                //alert("아이디를 입력해 주세요.");
                object.addClass("is-invalid");
                return;
            }

            // id 길이 미만 혹은 초과 시, 경고 문구 출력
            if(object.value.length < object.minLength || object.value.length > object.maxLength){
                object.addClass("is-invalid");
                return;
            }

            $.ajax({
                url : "${pageContext.request.contextPath}/member/idoverlapcheck.do", // 요청 주소
                type : 'POST',
                data : { // 요청 시, 넘겨줄 데이터
                    memberId : inputMemberId
                },
                success : function(data) {
                    // data : 응답 정보. url의 실행 결과가 넘어 온다. (주석 포함)
                    // alert('data: ' + $.trim(data));

                    if ($.trim(data) == "1") { // data의 앞 뒤 공백을 제거(trim)한 후 "1"인지 확인
                        alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                        //아이디가 존재할 경우 빨강으로, 아니면 파랑으로 처리하는 디자인
                        $("#memberId").addClass("is-invalid")
                        // $("#memberId").removeClass("has-success")
                        $("#memberId").focus();
                    } else {
                        alert("사용 가능한 아이디입니다.");
                        //아이디가 존재할 경우 빨강으로, 아니면 파랑으로 처리하는 디자인
                        // $("#memberId").addClass("has-success")
                        $("#memberId").removeClass("is-invalid")
                        $("#memberId").focus();
                    }
                }
            });
        }

        // 비밀번호 일치 확인
        function passwordCheck(){
            let passwordMember = $("#passwordMember").val();
            let passwordMemberCheck = $("#passwordMemberCheck").val();

            if(passwordMember !== passwordMemberCheck){ // 불일치
                $("#passwordMemberCheck").addClass("is-invalid");
                $("#passwordMemberCheck").removeClass("has-success");
            }else{  // 일치
                $("#passwordMemberCheck").removeClass("is-invalid")
                // $("#passwordMemberCheck").addClass("has-success")
            }
        }
    </script>
</head>

<body>
<!-- Responsive navbar-->
<jsp:include page="../navbar_jy.jsp" flush="false"/>

<div class="container">
    <div class="input-form-backgroud row">
        <div class="input-form col-md-12 mx-auto">
            <h4 class="mb-3">회원가입</h4>

            <form class="validation-form" method="post" action="${pageContext.request.contextPath}/member/signup.do" novalidate>
                <!-- 아이디 -->
                <div class="row">
                    <div class="col-md-8 mb-3">
                        <label for="memberId">아이디</label>
                        <input type="text" class="form-control" id="memberId" name="memberId" placeholder="5자 이상 30자 이하의 영문과 숫자 조합을 입력해 주세요." required
                        minlength="5" maxlength="30" onInput="maxLengthCheck(this)" onKeyUp="inputDataCheck(this.id)">
                        <div class="invalid-feedback">
                            아이디를 입력해 주세요.(5자 이상 30자 이하)
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <br/>
                        <button id="memberIdCheck" class="btn btn-primary btn-sm btn-block" type="button" onclick="id_overlap_check(this)">중복확인</button>
                    </div>
                </div>

                <!-- 비밀번호 -->
                <div class="mb-3">
                    <label for="passwordMember">비밀번호</label>
                    <input type="password" class="form-control" id="passwordMember" name="passwordMember" placeholder="5자 이상 30자 이하의 영문과 숫자 조합을 입력해 주세요." required
                    minlength="5" maxlength="128" onInput="maxLengthCheck(this);" onKeyUp="inputDataCheck(this.id);">
                    <div class="invalid-feedback">
                        비밀번호를 입력해 주세요. (5자 이상 128자 이하)
                    </div>
                </div>

                <div class="mb-3">
                    <label for="passwordMemberCheck">비밀번호 확인</label>
                    <input type="password" class="form-control" id="passwordMemberCheck" placeholder="5자 이상 30자 이하의 영문과 숫자 조합을 입력해 주세요." required
                    onInput="passwordCheck(this); " onKeyUp="passwordCheck(this);">
                    <div class="invalid-feedback">
                        비밀번호를 정확히 입력해 주세요.
                    </div>
                </div>

                <!-- 닉네임 -->
                <div class="row">
                    <div class="col-md-8 mb-3">
                        <label for="memberNickname">닉네임</label>
                        <input type="text" class="form-control" id="memberNickname" name="memberNickname" placeholder="5자 이상 30자 이하의 영문과 숫자 조합을 입력해 주세요." required>
                        <div class="invalid-feedback">
                            닉네임을 입력해 주세요. (30자 이하)
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <br/>
                        <button id="memberNicknameCheck" class="btn btn-primary btn-sm btn-block">중복확인</button>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8 mb-3">
                        <label for="memberEmail">이메일</label>
                        <input type="email" class="form-control" id="memberEmail" name="memberEmail" placeholder="you@example.com" required>
                        <div class="invalid-feedback">
                            이메일을 입력해 주세요.
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <br/>
                        <button id="memberEmailSearch" class="btn btn-primary btn-sm btn-block">중복확인</button>
                    </div>
                </div>
                <!--
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="memberZonecode">우편번호</label>
                        <input type="text" class="form-control" id="memberZonecode" name="memberZonecode" placeholder="" required>
                        <div class="invalid-feedback">
                            우편번호를 검색해 주세요. readonly
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <br/>
                        <button id="memberZonecodeSearch" class="btn btn-primary btn-sm btn-block">우편번호 검색</button>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="memberAddress">주소</label>
                    <input type="text" class="form-control" id="memberAddress" name="memberAddress" placeholder="서울특별시 강남구" required>
                    <div class="invalid-feedback">
                        주소를 입력해 주세요. readonly
                    </div>
                </div>

                <div class="mb-3">
                    <label for="memberAddressDetailed">상세주소</label>
                    <input type="text" class="form-control" id="memberAddressDetailed" name="memberAddressDetailed" placeholder="상세주소를 입력해주세요." required>
                    <div class="invalid-feedback">
                        상세주소를 입력해 주세요.
                    </div>
                </div>
                -->
                <!--
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name">이름</label>
                        <input type="text" class="form-control" id="name" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            이름을 입력해주세요.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="nickname">별명</label>
                        <input type="text" class="form-control" id="nickname" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            별명을 입력해주세요.
                        </div>
                    </div>
                </div>
                -->
                <!-- 이메일 select
                <div class="col-md-3">
                    <label for="validationCustom04" class="form-label">State</label>
                    <select class="form-select" id="validationCustom04" required>
                        <option selected disabled value="">Choose...</option>
                        <option value="">-선택-</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="naver.com">naver.com</option>
                        <option value="daum.net">daum.net</option>
                        <option value="nate.com">nate.com</option>
                    </select>
                    <div class="invalid-feedback">
                        Please select a valid state.
                    </div>
                </div>
                -->
                <!--
                <div class="row">
                    <div class="col-md-8 mb-3">
                        <label for="root">가입 경로</label>
                        <select class="custom-select d-block w-100" id="root">
                            <option value=""></option>
                            <option>검색</option>
                            <option>카페</option>
                        </select>
                        <div class="invalid-feedback">
                            가입 경로를 선택해주세요.
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="code">추천인 코드</label>
                        <input type="text" class="form-control" id="code" placeholder="" required>
                        <div class="invalid-feedback">
                            추천인 코드를 입력해주세요.
                        </div>
                    </div>
                </div>
                -->
                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="agreement" required>
                    <label class="custom-control-label" for="agreement">개인정보 수집 및 이용에 동의합니다.</label>
                </div>

                <div class="d-grid col-6 mx-auto">
                <button class="btn btn-primary btn-lg btn-block" type="submit">가입하기</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Footer-->
<jsp:include page="../footer_jy.jsp" flush="false"/>

<script>
    // required 속성이 있는데 빈칸이 입력되었을 때, invalid-feedback 출력
    window.addEventListener('load', () => {
        const forms = document.getElementsByClassName('validation-form');

        Array.prototype.filter.call(forms, (form) => {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }

                form.classList.add('was-validated');
                form.classList.r('was-validated');
            }, false);
        });
    }, false);
</script>
<!--<script src="script/signup.js"></script>-->
</body>
</html>
