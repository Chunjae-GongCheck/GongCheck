package com.gck.board.controller;

import com.gck.board.model.BoardDAO;
import com.gck.board.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/gck/board/MainView.do")
public class BoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        BoardService brdService = new BoardService();
        Map<String, Object> map = new HashMap<>();

        // 어떤 값을 가져와야되나
        // 검색어를 통한 게시물 조회도 해줘야되니까
        // 검색어를 받아와야겠다.
        // 따로 제목이니 내용이니 구분해서 받아올 필요 없으니까
        // 입력한 문자만 받아오자
        String searchField = req.getParameter("searchWord");

        // 현재 페이지 확인
        int pageNum = 1;  // 기본값
        String pageTemp = req.getParameter("pageNum");
        if (pageTemp != null && !pageTemp.equals(""))
            // pageTemp가 null값이 아니면서 공백이 아니라면
            // pageNum 은 pageTemp가 숫자로 변한 값(Int)이 된다.
            pageNum = Integer.parseInt(pageTemp); // 요청받은 페이지로 수정

        // 아 이런거 post로 가야되나...

    }
}
