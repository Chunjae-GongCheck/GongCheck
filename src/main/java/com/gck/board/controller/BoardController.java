package com.gck.board.controller;


import com.gck.board.model.BoardDAO;
import com.gck.board.model.BoardVO;
import com.gck.board.service.BoardService;
import com.gck.paging.BoardPage;
import com.gck.post.controller.PostWriteController;
import com.gck.post.model.PostImageDAO;
import com.gck.post.model.PostImageDAOImpl;
import com.gck.post.model.PostImageVO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "MainView", value = "/gck/MainView.do")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // 서비스 생성 후 getter 만들어서 싱글톤 유지하면 편할 것 같습니다.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        BoardService brdService = new BoardService();
        Map<String, Object> map = new HashMap<>();

        String searchField = req.getParameter("searchField");
        String searchWord = req.getParameter("searchWord");
        System.out.println("test");



        // DAO를 통해 전체 게시물 수 조회
        int totalCount = brdService.selectCount(map);
        System.out.println("totalCount ======" + totalCount);


        // Image정보도 boardLists 에 추가하기 위해 메서드 작성
        PostImageVO postImageVO = new PostImageVO();
        int postImageIdx = postImageVO.getPostImageIdx();
        String postImagePath = postImageVO.getPostImagePath();
        String postTImagePath = postImageVO.getPostTImagePath();



        System.out.println("postImagePath 정보 =========" +postImagePath);
        System.out.println("postImageIdx 정보 ======== "+postImageIdx);
        System.out.println("postTImagePath 정보 =======" +postTImagePath);

        // 검색어가 존재하는 경우, Map에 추가
        if (searchWord != null && !searchWord.trim().equals("")) {
            map.put("searchField", searchField);
            map.put("searchWord", searchWord);
        }


        // 페이징 처리
        // ServletContext 객체를 통해 웹 애플리케이션의 초기 파라미터 값 가져오기
        ServletContext application = getServletContext();
        int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
        int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));

        // 현재 페이지 확인
        int pageNum = 1; // 기본값
        String pageTemp = req.getParameter("pageNum");
        if (pageTemp != null && !pageTemp.equals(""))
            pageNum = Integer.parseInt(pageTemp); // 요청받은 페이지로 수정

        // 목록에 출력할 게시물 범위 계산
        int start = (pageNum - 1) * pageSize + 1;  // 첫 게시물 번호
        int end = pageNum * pageSize; // 마지막 게시물 번호
        // map 에 키와 값 추가
        map.put("start", start);
        map.put("end", end);

        List<BoardVO> boardLists = brdService.selectListPage(map);

        System.out.println("boardLists ====== " + boardLists); // 콘솔출력용

        /* 페이지 처리 end */

        // 뷰에 전달할 매개변수 추가
        String pagingImg = BoardPage.pagingStr(totalCount, pageSize,
                blockPage, pageNum,"../gck/MainView.do" ,searchField, searchWord );  // 바로가기 영역 HTML 문자열
        // map 에 키와 값 추가
        map.put("pagingImg", pagingImg);
        map.put("totalCount", totalCount);
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);


        // 전달할 데이터를 request 영역에 저장 후 list.jsp로 포워드

        req.setAttribute("map",map);
        req.setAttribute("boardLists", boardLists);
        req.getRequestDispatcher("/board/MainView.jsp").forward(req, resp);

    }
}
