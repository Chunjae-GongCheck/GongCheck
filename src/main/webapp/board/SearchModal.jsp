<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>--%>
<%--<link href="/css/navbar_jy.css" rel="stylesheet"/>--%>
<%--&lt;%&ndash;%>
<%--    String searchWord = request.getParameter("searchWord");--%>
<%--    String searchField = request.getParameter("searchField");--%>
<%--%>--%>
<%--<script>--%>

<%--    const myModal = document.getElementById('myModal')--%>
<%--    const myInput = document.getElementById('myInput')--%>

<%--    myModal.addEventListener('shown.bs.modal', () => {--%>
<%--        myInput.focus()--%>
<%--    })--%>

<%--</script>--%>
<body>
    <div class="modal fade" id="searchModal" tabindex="2" aria-labelledby="searchHead" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="searchHead">검색어를 입력하세요</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <%--                    드롭다운 입력 칸--%>
                            <form class="d-flex justify-content-end" action="${pageContext.request.contextPath}/gck/MainView.do" id="navright_">
                                <select class="form-select-sm" name="searchField">
                                    <option value="title">제목</option>
                                    <option value="content">내용</option>
                                </select>

                                <input type="text" name="searchWord" value="${param.searchWord}"/>
                                <input type="submit" value="검색하기" class="btn btn-outline-dark" style="margin-right: 50px"/>
                            </form>
                        <%--                    드롭다운 end--%>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                        <button type="button" class="btn btn-dark">
                            <a class="link-light"
                               href="${pageContext.request.contextPath}/gck/MainView.do" style="text-decoration: none">
                                검색
                            </a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%--<jsp:forward page="${pageContext.request.contextPath}/MainView.jsp">--%>
<%--  <jsp:param name="searchWord" value="${param.searchWord}" />--%>
<%--  <jsp:param name="searchField" value="${param.searchField}" />--%>
<%--</jsp:forward>--%>
</body>

