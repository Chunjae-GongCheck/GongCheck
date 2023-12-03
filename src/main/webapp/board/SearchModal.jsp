<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>--%>
<%--<link href="/css/navbar_jy.css" rel="stylesheet"/>--%>
<%--&lt;%&ndash;%>
<%--    String searchWord = request.getParameter("searchWord");--%>
<%--    String searchField = request.getParameter("searchField");--%>
<%--%>--%>
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
                        <div class="input-group mb-lg-0">
                            <select class="form-select"
                                    name="searchField">
                                <option value="title">제목</option>
                                <option value="content">내용</option>
                            </select>
                            <input type="text" class="form-control" name="searchWord" value="${param.searchWord}" aria-label="검색어를 입력하세요"/>
                        </div>
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

